package com.kpztech.practice.netty.client;

import org.springframework.beans.factory.annotation.Autowired;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

//@Component
public class EchoClient {

  @Autowired
  private EchoClientHandler echoClientHandler;

  private Channel channel;


  public ChannelFuture start(String url, int port) {
    EventLoopGroup executors = new NioEventLoopGroup();
    Bootstrap bootstrap = new Bootstrap();
    try {
      bootstrap.group(executors).channel(NioSocketChannel.class)
               .handler(new ChannelInitializer<SocketChannel>() {
        @Override
        protected void initChannel(SocketChannel socketChannel) {
          socketChannel.pipeline().addLast(echoClientHandler);
        }
      });

      ChannelFuture future = bootstrap.connect(url, port).sync();

      channel = future.channel();

    } catch (InterruptedException e) {
      e.printStackTrace();
      try {
        executors.shutdownGracefully().sync();
      } catch (InterruptedException e1) {
        e1.printStackTrace();
      }
    }
    return null;
  }

  public void destroy() {
    System.out.println("[Netty]Client start to shutdown...");
    if (channel != null) {
      channel.close();
    }
    System.out.println("[Netty]Client shutdown finished...");
  }

  public void send(String msg){
    channel.writeAndFlush(msg);
  }
}
