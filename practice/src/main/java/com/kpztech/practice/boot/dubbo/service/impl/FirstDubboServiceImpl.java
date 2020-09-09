package com.kpztech.practice.boot.dubbo.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.dubbo.rpc.RpcContext;
import com.kpztech.practice.boot.dubbo.service.FirstDubboService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class FirstDubboServiceImpl implements FirstDubboService {

  @Override
  public String test() {
    log.info("Yes, you have done it!");

    log.info(RpcContext.getContext().getRemotePort() + "");

    return "success!";
  }
}
