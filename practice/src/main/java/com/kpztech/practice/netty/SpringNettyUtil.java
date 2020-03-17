package com.kpztech.practice.netty;

import com.kpztech.practice.netty.server.EchoServer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import io.netty.channel.ChannelFuture;

@Component
public class SpringNettyUtil implements CommandLineRunner {

  @Value("${netty.url}")
  private String url;

  @Value("${netty.port}")
  private int port;

  @Autowired
  private EchoServer echoServer;

//  @Autowired
//  private EchoClient echoClient;

  @Override
  public void run(String... args) {
    ChannelFuture serverFuture = echoServer.start(url, port);
//    ChannelFuture clientFuture = echoClient.start(url, port);

    Runtime.getRuntime().addShutdownHook(new Thread(() -> echoServer.destroy()));
//    Runtime.getRuntime().addShutdownHook(new Thread(() -> echoClient.destroy()));

    serverFuture.channel().closeFuture().syncUninterruptibly();
//    clientFuture.channel().closeFuture().syncUninterruptibly();
  }

//  public void send(String msg) {
//    echoClient.send(msg);
//  }

}
