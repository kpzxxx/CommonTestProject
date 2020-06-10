package com.kpztech.practice.netty.nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;

public class NioClient {

  private SocketChannel sc;

  private void connect() {
    try {
      sc = SocketChannel.open(new InetSocketAddress("localhost", 8098));
      fileUp("/Users/q/Desktop/docs/1.txt", sc);

    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      try {
        sc.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }

  private void fileUp(String fileName, SocketChannel sc) throws IOException {
    FileChannel fc = new RandomAccessFile(fileName, "r").getChannel();
    long count = fc.size();

    // 这里ByteBuffer只维护了文件的大小 putLong(size)
    ByteBuffer buffer = ByteBuffer.allocate(8);
    buffer.putLong(count);
    buffer.flip();
    // 写入SocketChannel
    sc.write(buffer);
    buffer.clear();

    int transfered = 0;

    while (transfered < count) {
      // FileChannel -> SocketChannel
      long by = fc.transferTo(transfered, count - transfered, sc);
      transfered += by;
    }
    fc.close();

  }

  public static void main(String[] args) {
    NioClient nioClient = new NioClient();
    nioClient.connect();
  }

}
