package com.kpztech.practice.boot.netty;

import com.kpztech.practice.boot.netty.client.EchoClient;
import com.kpztech.practice.boot.netty.server.EchoServer;

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

	private final EchoServer echoServer;

	public SpringNettyUtil(EchoServer echoServer, EchoClient echoClient) {
		this.echoServer = echoServer;
		this.echoClient = echoClient;
	}

	private final EchoClient echoClient;

	@Override
	public void run(String... args) {
		ChannelFuture serverFuture = echoServer.start(url, port);

		Runtime.getRuntime().addShutdownHook(new Thread(echoServer::destroy));

		serverFuture.channel().closeFuture().syncUninterruptibly();
	}

	public void send(String msg) {
		echoClient.send(msg);
	}

}
