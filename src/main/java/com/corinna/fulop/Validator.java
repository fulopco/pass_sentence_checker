package com.corinna.fulop;

import java.io.IOException;
import java.util.List;

public class Validator {

  private final Reader reader;

  public Validator(Reader reader) {
    this.reader = reader;
  }

  public int checkSentences() throws IOException {
    List<String> sentences = reader.readEachLine();
    int counter = 0;

    return counter;
  }


}
