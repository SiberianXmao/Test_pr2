package com.training.textAnalyzer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TextAnalyzer {

    // количество слов
    public int countWords(String text) {
        // приводим к нижнему регистру и преобразуем в массив убирая все точки, пробелы и тд
        String[] words = text.toLowerCase().split("[\\s\\p{Punct}]+");
        return words.length;
    }

    // количество символов ( пробелы и ему подобные не учитываютя )
    public long countCharacters(String text) {
        return text.chars()
                .filter(c -> !Character.isWhitespace(c))
                .count();
    }

    // количество уникальных слов
    public int countUniqueWords(String text) {
        // приводим к нижнему регистру и преобразуем в массив убирая все точки, пробелы и тд
        String[] words = Arrays.stream(text.split("[\\s\\p{Punct}]+"))
                .filter(c -> !c.isEmpty())
                .toArray(String[]::new);

        Set<String> uniqueWords = new HashSet<>(Arrays.asList(words));

        return uniqueWords.size();
    }

    // наиболее часто встречающееся слово
    public String mostFrequentWord(String text) {
        // приводим к нижнему регистру и преобразуем в массив убирая все точки, пробелы и тд
        String[] words = text.toLowerCase().split("[\\s\\p{Punct}]+");
        Map<String, Integer> wordFrequency = new HashMap<>();

        for (String word : words) {
            wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
        }

        int maxFrequency = 0;
        String mostFrequentWord = "";

        for (Map.Entry<String, Integer> entry : wordFrequency.entrySet()) {
            if (entry.getValue() > maxFrequency) {
                maxFrequency = entry.getValue();
                mostFrequentWord = entry.getKey();
            }
        }

        return mostFrequentWord;
    }

    // сколько раз встречается конкретное слово
    public int wordFrequency(String text, String targetWord) {
        String[] words = text.toLowerCase().split("[\\s\\p{Punct}]+");
        Map<String, Integer> wordFrequency = new HashMap<>();

        for (String word : words) {
            wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
        }

        return wordFrequency.getOrDefault(targetWord, 0);
    }


}
