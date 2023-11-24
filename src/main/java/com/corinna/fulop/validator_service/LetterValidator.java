package com.corinna.fulop.validator_service;

public class LetterValidator implements ValidatorI {

  private final int ASCII_SPACE = 32;
  private final int ASCII_LOWERCASE_A = 97;
  private final int ASCII_LOWERCASE_Z = 122;

  @Override
  public boolean validate(String sentence) {
    char[] letters = sentence.substring(0,sentence.length()-1).toCharArray(); // if
    for (char letter : letters){
      int lettersCharCode = (int) letter;
      if(lettersCharCode != ASCII_SPACE && (lettersCharCode < ASCII_LOWERCASE_A || lettersCharCode > ASCII_LOWERCASE_Z)) {
        return false;
      }
    }
    return true;
  }

}
