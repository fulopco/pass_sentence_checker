package com.corinna.fulop;

import java.io.*;

public class Reader {


  public void readEachLine() throws IOException {

    File file = new File("input.txt");
    FileReader fileReader = new FileReader(file);
    BufferedReader bufferedReader = new BufferedReader(fileReader);

    String line;
    while ((line = bufferedReader.readLine()) != null) {
        System.out.println(line);
    }

  }

}
