package com.kodilla.patterns.testing;

class OnlyVowels {

    public String onlyVowels(String text) {
        String result = "";
        for (Character letter : text.toCharArray()) {
            char lcletter = Character.toLowerCase(letter);
            if (lcletter == 'a' || lcletter == 'e' || lcletter == 'i' || lcletter == 'o' || lcletter == 'u') {
                result += letter;
            }
        }
        return result;
    }

}

public class ZadanieDodatkowe61 {
    public static void main(String[] args) {
        System.out.println("ZadanieDodatkowe");
        OnlyVowels onlyVowels = new OnlyVowels();
        System.out.println(onlyVowels.onlyVowels("Zadanie Dodatkowe"));

    }
}
