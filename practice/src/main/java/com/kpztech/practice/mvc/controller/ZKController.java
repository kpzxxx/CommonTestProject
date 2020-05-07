package com.kpztech.practice.mvc.controller;

import com.kpztech.practice.mvc.common.CommonResponse;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.ACL;
import org.apache.zookeeper.data.Stat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import lombok.extern.slf4j.Slf4j;

import static com.kpztech.practice.mvc.common.Constants.ZK_FILE_PATH;
import static com.kpztech.practice.mvc.common.ResponseEnum.ZK_CREATE_FAILED;

@RestController
@RequestMapping("/zk")
@Slf4j
public class ZKController {

  private final ZooKeeper zooKeeper;

  @Autowired
  public ZKController(ZooKeeper zooKeeper) {
    this.zooKeeper = zooKeeper;
  }

  @GetMapping("/get")
  public ResponseEntity<CommonResponse<String>> get() {
    String result;
    try {
      byte[] data = zooKeeper.getData(ZK_FILE_PATH, false, exists());
      result = new String(data);
      return ResponseEntity.ok(CommonResponse.of(result));

    } catch (KeeperException | InterruptedException e) {
      log.error("[ZK]Get node data failed.", e);
      return ResponseEntity.ok(CommonResponse.of(ZK_CREATE_FAILED));

    }

  }

  private Stat exists() throws KeeperException, InterruptedException {
    return zooKeeper.exists(ZK_FILE_PATH, false);
  }

  @GetMapping("/create")
  public ResponseEntity<CommonResponse<String>> create(@RequestParam String nodeData) {
    log.info("[ZK]Create node: {}", nodeData);
    List<ACL> acls = ZooDefs.Ids.OPEN_ACL_UNSAFE;
    String result = "Success.";
    try {
      result = zooKeeper.create(ZK_FILE_PATH, nodeData.getBytes(), acls, CreateMode.PERSISTENT);
    } catch (KeeperException | InterruptedException e) {
      log.error("[ZK]Create node failed.", e);
      return ResponseEntity.ok(CommonResponse.of(result));
    }
    return ResponseEntity.ok(CommonResponse.of(result));
  }
}
