package com.kpztech.practice.netty.nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;

public class NioServer {

  private ServerSocketChannel ssc;
  private Selector selector;

  public void start() throws IOException {
    try {
      ssc = ServerSocketChannel.open();
      selector = Selector.open();
      AtomicInteger counter = new AtomicInteger(0);

      ssc.configureBlocking(false);
      ssc.bind(new InetSocketAddress(8098));
      ssc.register(selector, SelectionKey.OP_ACCEPT);

      while (true) {
        int flag = selector.select();

        if (flag > 0) {
          Iterator<SelectionKey> keys = selector.selectedKeys().iterator();
          counter.getAndIncrement();
          while (keys.hasNext()) {
            SelectionKey key = keys.next();
            keys.remove();

            if (key.isAcceptable()) {
              SocketChannel sc = ssc.accept();
              sc.configureBlocking(false);
              sc.register(selector, SelectionKey.OP_READ);

            } else if (key.isReadable()) {
              SocketChannel channel = (SocketChannel) key.channel();
              acceptFile("/Users/q/Desktop/docs1/1.txt", channel);
              channel.close();
              System.out.println(counter.get());
            }
          }
        }


      }
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      ssc.close();
      selector.close();
    }

  }

  private void acceptFile(String fileName, SocketChannel sc) throws IOException {
    ByteBuffer buffer = ByteBuffer.allocate(8);

    sc.read(buffer);
    buffer.flip();
    long fileSize = buffer.getLong(0);

    buffer.clear();

    FileChannel fc = new RandomAccessFile(fileName, "rw").getChannel();
    long count = 0;
    while (count < fileSize) {
      // SocketChannel -> FileChannel
      long accepted = fc.transferFrom(sc, count, fileSize - count);
      count += accepted;
    }
    fc.close();

  }

  public static void main(String[] args) {
    NioServer server = new NioServer();
    try {
      server.start();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }


}
