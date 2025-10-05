package com.training;

import com.training.passwordGenerator.PasswordGenerator;
import org.junit.Test;
import static org.junit.Assert.*;

public class PasswordGeneratorTest {

    private final PasswordGenerator generator = new PasswordGenerator();

    @Test
    public void testGeneratePasswordLength() {
        String pwd = generator.generatePassword(12, true, true);
        assertEquals("Пароль должен быть заданной длины", 12, pwd.length());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGeneratePasswordInvalidLengthZero() {
        generator.generatePassword(0, true, true);
    }

    @Test
    public void testGeneratePasswordMinimumLength() {
        String pwd = generator.generatePassword(1, false, false);
        assertEquals(1, pwd.length());
    }

    @Test
    public void testGeneratePasswordWithDigits() {
        String pwd = generator.generatePassword(10, true, false);
        assertTrue(generator.containsDigit(pwd));
        assertFalse(generator.containsSpecial(pwd));
    }

    @Test
    public void testGeneratePasswordWithSpecials() {
        String pwd = generator.generatePassword(10, false, true);
        assertTrue(generator.containsSpecial(pwd));
        assertFalse(generator.containsDigit(pwd));
    }

    @Test
    public void testGeneratePasswordLettersOnly() {
        String pwd = generator.generatePassword(10, false, false);
        assertFalse(generator.containsDigit(pwd));
        assertFalse(generator.containsSpecial(pwd));
        assertTrue(generator.containsLowercase(pwd) || generator.containsUppercase(pwd));
    }

    @Test
    public void testContainsDigit() {
        assertTrue(generator.containsDigit("pass123"));
        assertFalse(generator.containsDigit("password"));
    }

    @Test
    public void testContainsSpecial() {
        assertTrue(generator.containsSpecial("abc!def"));
        assertFalse(generator.containsSpecial("abcdef"));
    }

    @Test
    public void testContainsUppercase() {
        assertTrue(generator.containsUppercase("Hello"));
        assertFalse(generator.containsUppercase("hello"));
    }

    @Test
    public void testContainsLowercase() {
        assertTrue(generator.containsLowercase("ABCd123"));
        assertFalse(generator.containsLowercase("ABC123"));
    }

    @Test
    public void testIsStrongPassword() {
        assertTrue(generator.isStrongPassword("Aa1!abcd")); // strong
        assertFalse(generator.isStrongPassword("Aa1!")); // too short
        assertFalse(generator.isStrongPassword("Aa123456")); // no special
    }

    @Test
    public void testShuffleEffect() {
        String pwd1 = generator.generatePassword(12, true, true);
        String pwd2 = generator.generatePassword(12, true, true);
        assertNotEquals("Пароли не должны быть идентичны при повторной генерации", pwd1, pwd2);
    }

    @Test
    public void testStraightEqualityPath() {
        PasswordGenerator gen = new PasswordGenerator();
        String pwd = gen.generatePassword(1, false, false);
        assertNotNull(pwd);
    }
    @Test
    public void testContainsUppercaseBoundaries() {
        assertTrue(generator.containsUppercase("A"));
        assertTrue(generator.containsUppercase("Z"));

        assertFalse(generator.containsUppercase("abcdefghijklmnopqrstuvwxyz"));
    }


    @Test
    public void testContainsLowercaseBoundaries() {
        assertTrue(generator.containsLowercase("a"));
        assertTrue(generator.containsLowercase("z"));
        assertFalse(generator.containsLowercase("NOLOWERCASE"));
    }

    @Test
    public void testShuffleEffectKillsLastMutant() {
        PasswordGenerator generator = new PasswordGenerator();

        // Генерируем пароль только из букв, длина > 1
        int length = 10;
        String pwd = generator.generatePassword(length, false, false);

        // Прямой порядок букв
        String straight = (PasswordGenerator.LOWER + PasswordGenerator.UPPER).substring(0, length);

        // Проверяем, что пароль перемешан
        assertFalse("Пароль должен быть перемешан и отличаться от прямого порядка", pwd.equals(straight));
    }

    @Test
    public void testFisherYatesBoundaryKillsMutant() {
        PasswordGenerator generator = new PasswordGenerator();
        String pwd = generator.generatePassword(1, false, false);
        assertNotNull("Пароль длиной 1 должен генерироваться без ошибок", pwd);
        assertEquals(1, pwd.length());
    }

    @Test
    public void testGeneratePasswordLengthOne() {
        PasswordGenerator generator = new PasswordGenerator();

        // Без цифр и спецсимволов
        String pwd1 = generator.generatePassword(1, false, false);
        assertEquals(1, pwd1.length());
        assertTrue(generator.containsLowercase(pwd1) || generator.containsUppercase(pwd1));

        // С цифрой
        String pwd2 = generator.generatePassword(1, true, false);
        assertEquals(1, pwd2.length());
        assertTrue(generator.containsDigit(pwd2));

        // Со спецсимволом
        String pwd3 = generator.generatePassword(1, false, true);
        assertEquals(1, pwd3.length());
        assertTrue(generator.containsSpecial(pwd3));

        // С цифрой и
    }



}
