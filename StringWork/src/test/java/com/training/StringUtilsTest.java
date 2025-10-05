package com.training;

import com.training.stringUtils.StringUtils;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class StringUtilsTest {

    @Test
    public void testIsPalindrome() {
        assertTrue(StringUtils.isPalindrome("level"));
        assertTrue(StringUtils.isPalindrome("А роза упала на лапу Азора"));
        assertTrue(StringUtils.isPalindrome("Madam, I'm Adam"));
        assertFalse(StringUtils.isPalindrome("hello"));
        assertFalse(StringUtils.isPalindrome(null));
        assertTrue(StringUtils.isPalindrome("")); // пустая строка - палиндром
    }

    @Test
    public void testCountVowels() {
        assertEquals(5, StringUtils.countVowels("education"));
        assertEquals(0, StringUtils.countVowels("rhythm"));
        assertEquals(3, StringUtils.countVowels("Привет мир")); // русские гласные
        assertEquals(0, StringUtils.countVowels(null));
        assertEquals(0, StringUtils.countVowels(""));
    }

    @Test
    public void testReverse() {
        assertEquals("cba", StringUtils.reverse("abc"));
        assertEquals("", StringUtils.reverse(""));
        assertNull(StringUtils.reverse(null));
    }

    @Test
    public void testToTitleCase() {
        assertEquals("Hello World", StringUtils.toTitleCase("hello world"));
        assertEquals("Java Developer", StringUtils.toTitleCase("java developer"));
        assertEquals("Привет Мир", StringUtils.toTitleCase("привет мир"));
        assertEquals("", StringUtils.toTitleCase(""));
        assertNull(StringUtils.toTitleCase(null));
    }

    @Test
    public void testRemoveSpaces() {
        assertEquals("helloworld", StringUtils.removeSpaces("hello world"));
        assertEquals("abc", StringUtils.removeSpaces("a b c"));
        assertEquals("", StringUtils.removeSpaces(""));
        assertNull(StringUtils.removeSpaces(null));
    }
}
