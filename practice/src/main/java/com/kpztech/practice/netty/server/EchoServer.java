package com.kpztech.practice.netty.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpServerCodec;

@Component
public class EchoServer {

  @Autowired
  private EchoServerHandler handler;

  // 主线程组
  private final EventLoopGroup bossGroup = new NioEventLoopGroup();
  // 从线程组
  private final EventLoopGroup workerGroup = new NioEventLoopGroup();
  private Channel channel;

  public ChannelFuture start(String url, int port) {
    ChannelFuture future = null;
    ServerBootstrap serverBootstrap = new ServerBootstrap();

    try {
      serverBootstrap.group(bossGroup, workerGroup).channel(NioServerSocketChannel.class).childHandler(
          new ChannelInitializer<SocketChannel>() {
            @Override
            protected void initChannel(SocketChannel socketChannel) {
              socketChannel.pipeline().addLast("HttpServerCodec", new HttpServerCodec())
                           .addLast(handler);
            }
          });

      future = serverBootstrap.bind(port).sync();

      channel = future.channel();

    } catch (InterruptedException e) {
      e.printStackTrace();
    } finally {
      if (future != null && future.isSuccess()) {
        System.out.println("[Netty]Server listening " + url + " on port " + port + " and ready for connections...");
      } else {
        System.out.println("[Netty]Server start up failed...");
      }
    }

    return future;
  }

  public void destroy() {
    System.out.println("[Netty]Server start to shutdown...");
    if (channel != null) {
      channel.close();
    }
    workerGroup.shutdownGracefully();
    bossGroup.shutdownGracefully();
    System.out.println("[Netty]Server shutdown finished...");
  }

}
