package com.training.stringUtils;



public class StringUtils {

    // проверка палиндрома
    public static boolean isPalindrome(String str) {
        if (str == null) return false;
        String clean = str.replaceAll("[\\s\\p{Punct}]", "").toLowerCase();
        String reversed = new StringBuilder(clean).reverse().toString();
        return clean.equals(reversed);
    }

    // количество гласных
    public static int countVowels(String str) {

        if (str == null) return 0;
        int count = 0;
        String vowels = "аеёиоуыэюяaeiou"; // поддержка русских и английских
        for (char c : str.toLowerCase().toCharArray()) {
            if (vowels.indexOf(c) != -1) count++;
        }
        return count;
    }

    // переворот строки
    public static String reverse(String str) {
        if (str == null) return null;
        return new StringBuilder(str).reverse().toString();
    }

    // перевод в формат "Каждое Слово С Большой Буквы"
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
