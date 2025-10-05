package com.training;

import com.training.textAnalyzer.TextAnalyzer;
import org.junit.Test;
import static org.junit.Assert.*;

public class TextAnalyzerTest {

    private final TextAnalyzer analyzer = new TextAnalyzer();

    @Test
    public void testCountWords() {
        String text = "Hello world this is a test";
        assertEquals(6, analyzer.countWords(text));
    }

    @Test
    public void testCountCharacters() {
        String text = "abc 123";
        assertEquals(6, analyzer.countCharacters(text));
    }

    @Test
    public void testCountUniqueWords() {
        String text = "apple orange apple banana";
        assertEquals(3, analyzer.countUniqueWords(text));
    }

    @Test
    public void testMostFrequentWord() {
        String text = "dog cat dog bird dog cat";
        assertEquals("dog", analyzer.mostFrequentWord(text));
    }

    @Test
    public void testWordFrequency() {
        String text = "one two one three one";
        assertEquals(3, analyzer.wordFrequency(text, "one"));
    }

    // -------------- После мутации
    @Test
    public void testCountUniqueWordsEmptyString() {
        String text = "";
        assertEquals(0, analyzer.countUniqueWords(text));
    }
    @Test
    public void testCountUniqueWordsSpacesOnly() {
        String text = "   ";
        assertEquals(0, analyzer.countUniqueWords(text));
    }
    @Test
    public void testMostFrequentWordTie() {
        String text = "apple banana apple banana";
        String result = analyzer.mostFrequentWord(text);
        // допустим, в таком случае должно вернуть первое по порядку "apple"
        assertEquals("apple", result);
    }




}
