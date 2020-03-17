package com.kpztech.practice.netty.client;

import org.springframework.stereotype.Component;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;

@Component
public class EchoClientHandler extends SimpleChannelInboundHandler<ByteBuf> {

  @Override
  public void channelActive(ChannelHandlerContext context) {
    context.writeAndFlush(Unpooled.copiedBuffer("[Netty]Ready!", CharsetUtil.UTF_8));
  }

  @Override
  protected void channelRead0(
      ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf) throws Exception {
    System.out.println("[Netty]Client got: " + byteBuf.toString(CharsetUtil.UTF_8));
  }

  public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
    cause.printStackTrace();
    ctx.close();
  }
}
