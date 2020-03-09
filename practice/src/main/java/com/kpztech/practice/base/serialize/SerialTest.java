package com.kpztech.practice.base.serialize;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Objects;

/**
 * 序列化和反序列化
 */
public class SerialTest{
  private static final String PATH = "/tmp/person.txt";

  public static void main(String[] args) {
    serial();
    deserial();

  }

  // 当前类的绝对路径
  private String getPath(){
    return Objects.requireNonNull(this.getClass().getClassLoader().getResource("")).getPath();
  }

  private static void serial() {
    SonPerson serialPerson = new SonPerson(1L, "A", 32, "India");
    System.out.println("Initiate person: " + serialPerson);

    File file = new File(PATH);
    if(!file.exists()){
      try {
        boolean result = file.createNewFile();
        if(result){
          System.out.println("Create file: " + file.getName());
        }
      } catch (IOException e) {
        e.printStackTrace();
      }
    }

    try (FileOutputStream fos = new FileOutputStream(PATH); ObjectOutputStream oos = new ObjectOutputStream(
        fos)) {
      oos.writeObject(serialPerson);
      oos.flush();

    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private static void deserial() {
    SonPerson serialPerson;
    try (FileInputStream fis = new FileInputStream(PATH); ObjectInputStream ois =
        new ObjectInputStream(fis)) {
      serialPerson = (SonPerson)ois.readObject();
      System.out.println("Got person: " + serialPerson);

    } catch (IOException | ClassNotFoundException e) {
      e.printStackTrace();
    }
  }
}
