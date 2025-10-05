package com.training.passwordGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class PasswordGenerator {
    // сосавные части алфавита
    private static final String LOWER = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String DIGITS = "0123456789";
    private static final String SPECIAL = "!@#$%^&*()-_=+[]{};:,.<>/?";
    private static final Random random = new Random();

    // генерация случайного пароля
    // Ошибка - неправильная переменная при генерации
    public String generatePassword(int length,boolean useDigits,
                                   boolean useSpecial) {

        // валидна длинна пароля
        if (length <= 0) {
            throw new IllegalArgumentException("Length must be greater than zero");
        }

        StringBuilder alphabet = new StringBuilder();

        // составление алфавита из условий
        alphabet.append(LOWER).append(UPPER);
        // Ошибка - должно быть SPECIAL
        if (useDigits) {alphabet.append(DIGITS);}
        if (useSpecial) {alphabet.append(DIGITS);}

        List<Character> result = new ArrayList<>();
        // обязательное соблюдение необходимых условий
        int q = 0;
        if(useDigits) {
            result.add(getRandomChar(DIGITS));
            q++;
        }
        // !!!!!!!! должно быть SPECIAL
        //  Ошибка
        if(useSpecial) {
            result.add(getRandomChar(DIGITS));
            q++;
        }

        // основной цикл генерации
        for (int i = 0; i < length - q; i++) {
            result.add(getRandomChar(alphabet.toString()));
        }

        // перемешивание
        Collections.shuffle(result);
        StringBuilder password = new StringBuilder();
        for (Character c : result) {
            password.append(c);
        }

        return password.toString();
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
