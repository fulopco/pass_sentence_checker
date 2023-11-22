package com.corinna.fulop;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Reader {

  private Validator validator;

  public Reader(Validator validator) {
    this.validator = validator;
  }

  public void readEachLine() throws IOException {

    List<String> sentences = new ArrayList<>();

    File file = new File("input.txt");
    FileReader fileReader = new FileReader(file);
    BufferedReader bufferedReader = new BufferedReader(fileReader);

    String line;
    while ((line = bufferedReader.readLine()) != null) {
        System.out.println(line);
        sentences.add(line);
    }
    validator.checkSentences(sentences);

  }

}
