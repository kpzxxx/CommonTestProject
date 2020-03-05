package com.kpztech.practice.base.serialize;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * 序列化
 */
public class SerialTest{

  public static void main(String[] args) {
    serial();
    deserial();
  }

  public static void serial() {
    SonPerson serialPerson = new SonPerson(1L, "A", 32, "India");
    System.out.println("Initiate person: " + serialPerson);
    try (FileOutputStream fos = new FileOutputStream("person.txt"); ObjectOutputStream oos = new ObjectOutputStream(
        fos)) {
      oos.writeObject(serialPerson);
      oos.flush();

    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static void deserial() {
    SonPerson serialPerson;
    try (FileInputStream fis = new FileInputStream("person.txt"); ObjectInputStream ois = new ObjectInputStream(fis)) {
      serialPerson = (SonPerson)ois.readObject();
      System.out.println("Got person: " + serialPerson);

    } catch (IOException | ClassNotFoundException e) {
      e.printStackTrace();
    }
  }
}
