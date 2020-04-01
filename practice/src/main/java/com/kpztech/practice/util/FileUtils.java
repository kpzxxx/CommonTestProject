package com.kpztech.practice.util;

import org.springframework.util.StringUtils;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletResponse;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FileUtils {

  public static String getFileSuffix(String fileName) {
    String[] splits = StringUtils.split(fileName, ".");
    if (splits != null && splits.length > 1) {
      return splits[1];
    }
    return null;
  }

  public static void download(HttpServletResponse response, String fileName, String filePath, String downloadName) {
    response.setContentType("application/octet-stream");
    try {
      response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(downloadName, "UTF-8"));
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
    }

    byte[] buff = new byte[1024];
    BufferedInputStream bufferedInputStream = null;
    OutputStream outputStream;
    try {
      outputStream = response.getOutputStream();
      bufferedInputStream = new BufferedInputStream(new FileInputStream(new File(filePath + fileName)));
      int i = bufferedInputStream.read(buff);
      while (i != -1) {
        outputStream.write(buff, 0, buff.length);
        outputStream.flush();
        i = bufferedInputStream.read(buff);
      }
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      if (bufferedInputStream != null) {
        try {
          bufferedInputStream.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }


  }

  public static void delete(String fileName, String filePath){
    File file = new File(filePath + fileName);
    if(file.exists()){
      boolean delete = file.delete();
      if(delete){
        log.info("Delete file[" + fileName + "] success!");
      }else {
        log.warn("Delete file[" + fileName + "] failed!");
      }
    }
  }

}
