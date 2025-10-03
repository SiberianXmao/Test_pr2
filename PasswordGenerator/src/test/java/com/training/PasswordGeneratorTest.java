package com.training;

import com.training.passwordGenerator.PasswordGenerator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PasswordGeneratorTest {

    private final PasswordGenerator generator = new PasswordGenerator();

    @Test
    void testGeneratePasswordLength() {
        String pwd = generator.generatePassword(12, true, true);
        assertEquals(12, pwd.length(), "Пароль должен быть заданной длины");
    }

    @Test
    void testGeneratePasswordWithDigits() {
        String pwd = generator.generatePassword(10, true, false);
        assertTrue(generator.containsDigit(pwd), "Пароль должен содержать хотя бы одну цифру");
    }

    @Test
    void testGeneratePasswordWithSpecials() {
        String pwd = generator.generatePassword(10, false, true);
        assertTrue(generator.containsSpecial(pwd), "Пароль должен содержать спецсимвол");
    }

    @Test
    void testContainsUppercase() {
        assertTrue(generator.containsUppercase("Test123"));
        assertFalse(generator.containsUppercase("lowercase"));
    }

    @Test
    void testIsStrongPassword() {
        assertTrue(generator.isStrongPassword("Aa1!abcd"));
        assertFalse(generator.isStrongPassword("weak"));
    }

}
