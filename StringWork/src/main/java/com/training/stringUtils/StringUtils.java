package com.training.stringUtils;

import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

public class StringUtils {

    // проверка палиндрома
    public static boolean isPalindrome(String str) {
        if (str == null) return false;

        // Убираем пробелы, пунктуацию и приводим к нижнему регистру
        String clean = str.replaceAll("[\\s\\p{Punct}]", "").toLowerCase();

        // Переворачиваем и сравниваем
        String reversed = new StringBuilder(clean).reverse().toString();
        return clean.equals(reversed);
    }

    // количество гласных (русские + английские)
    public static int countVowels(String str) {
        if (str == null || str.isEmpty()) return 0;

        String vowelsStr = "аеёиоуыэюяAEIOUаеёиоуыэюяaeiou";
        Set<Character> vowels = new HashSet<>();
        for (char c : vowelsStr.toCharArray()) {
            vowels.add(c);
        }

        int count = 0;
        for (char c : str.toCharArray()) {
            if (vowels.contains(c)) {
                count++;
            }
        }
        return count;
    }


    // переворот строки
    public static String reverse(String str) {
        if (str == null) return null;
        return new StringBuilder(str).reverse().toString();
    }

    // каждое слово с заглавной буквы
    public static String toTitleCase(String str) {
        if (str == null || str.isEmpty()) return str;

        String[] words = str.toLowerCase().split("\\s+");
        StringBuilder sb = new StringBuilder();

        for (String w : words) {
            if (!w.isEmpty()) {
                sb.append(Character.toUpperCase(w.charAt(0)))
                        .append(w.substring(1))
                        .append(" ");
            }
        }
        return sb.toString().trim();
    }

    // убрать все пробелы
    public static String removeSpaces(String str) {
        if (str == null) return null;
        return str.replaceAll("\\s+", "");
    }
}
