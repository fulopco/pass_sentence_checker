package com.corinna.fulop;

import java.io.IOException;

public class Main {

  public static void main(String[] args) throws IOException {
    Reader reader = new Reader();
    Validator validator = new Validator(reader);
    validator.checkSentences();
  }
}