package com.corinna.fulop;

import java.io.IOException;

public class Main {

  public static void main(String[] args) throws IOException {
    Validator validator = new Validator();
    Reader reader = new Reader(validator);
    reader.readEachLine();
  }
}