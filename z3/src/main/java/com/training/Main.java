package com.training;

import com.training.textAnalyzer.TextAnalyzer;

public class Main {
    public static void main(String[] args) {
        System.out.println("world");
        TextAnalyzer textAnalyzer = new TextAnalyzer();
        String text = "one two one three one";
        System.out.println(textAnalyzer.countWords(text));
        System.out.println(textAnalyzer.countUniqueWords(text));
        System.out.println(textAnalyzer.mostFrequentWord(text));
        System.out.println(textAnalyzer.wordFrequency(text,"one"));
    }
}