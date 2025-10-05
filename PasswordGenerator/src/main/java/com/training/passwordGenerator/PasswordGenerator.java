package com.training.passwordGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class PasswordGenerator {
    // сосавные части алфавита
    public static final String LOWER = "abcdefghijklmnopqrstuvwxyz";
    public static final String UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String DIGITS = "0123456789";
    private static final String SPECIAL = "!@#$%^&*()-_=+[]{};:,.<>/?";
    private static final Random random = new Random();

    // генерация случайного пароля
    // Ошибка - неправильная переменная при генерации
    public String generatePassword(int length, boolean useDigits, boolean useSpecial) {
        if (length <= 0) {
            throw new IllegalArgumentException("Length must be greater than zero");
        }

        StringBuilder alphabet = new StringBuilder();
        alphabet.append(LOWER).append(UPPER);
        if (useDigits) alphabet.append(DIGITS);
        if (useSpecial) alphabet.append(SPECIAL);

        char[] result = new char[length];
        int index = 0;

        if (useDigits) result[index++] = getRandomChar(DIGITS);
        if (useSpecial) result[index++] = getRandomChar(SPECIAL);

        for (; index < length; index++) {
            result[index] = getRandomChar(alphabet.toString());
        }

        for (int i = result.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            char temp = result[i];
            result[i] = result[j];
            result[j] = temp;
        }



        return new String(result);
    }


    // проверка на надёжность ( минимум 8 символов, цифры, заглавные, сец.с )
    public boolean isStrongPassword(String password) {
        if (password.length() < 8) {
            return false;
        }
        if(!containsDigit(password)) {return false;}

        return containsSpecial(password);
    }

    // содержит ли числа
    public boolean containsDigit (String password) {
        return password.chars().anyMatch(Character::isDigit);
    }

    // содержит ли спецсимволы
    public boolean containsSpecial (String password) {
        return password.chars().anyMatch(ch -> SPECIAL.indexOf(ch) >= 0);
    }

    // содержит ли заглавные буквы
    public boolean containsUppercase (String password) {
        return password.chars().anyMatch(ch -> UPPER.indexOf(ch) >= 0);
    }

    // содержит строчные буквы
    public boolean containsLowercase (String password) {

        return password.chars().anyMatch(ch -> LOWER.indexOf(ch) >= 0);
    }

    // получение случайного числа из строки
    private static char getRandomChar(String s){
        int ind = random.nextInt(s.length());
        return s.charAt(ind);
    }


}
