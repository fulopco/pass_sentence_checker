package com.corinna.fulop;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Reader {

  public List<String> readEachLine() throws IOException {

    List<String> sentences = new ArrayList<>();

    File file = new File("input.txt");
    FileReader fileReader = new FileReader(file);
    BufferedReader bufferedReader = new BufferedReader(fileReader);

    String line;
    while ((line = bufferedReader.readLine()) != null) {
        sentences.add(line);
    }

    return sentences;
  }

}
