package com.training;

import com.training.stringUtils.StringUtils;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StringUtilsTest {

    @Test
    void testIsPalindrome() {
        assertTrue(StringUtils.isPalindrome("level"));
        assertTrue(StringUtils.isPalindrome("А роза упала на лапу Азора"));
        assertFalse(StringUtils.isPalindrome("hello"));
    }

    @Test
    void testCountVowels() {
        assertEquals(5, StringUtils.countVowels("education"));
        assertEquals(0, StringUtils.countVowels("rhythm"));
    }

    @Test
    void testReverse() {
        assertEquals("cba", StringUtils.reverse("abc"));
        assertEquals("", StringUtils.reverse(""));
    }

    @Test
    void testToTitleCase() {
        assertEquals("Hello World", StringUtils.toTitleCase("hello world"));
        assertEquals("Java Developer", StringUtils.toTitleCase("java developer"));
    }

    @Test
    void testRemoveSpaces() {
        assertEquals("helloworld", StringUtils.removeSpaces("hello world"));
        assertEquals("abc", StringUtils.removeSpaces("a b c"));
    }

}
