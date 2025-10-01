package com.training;

import com.training.textAnalyzer.TextAnalyzer;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TextAnalyzerTest {
    private final TextAnalyzer analyzer = new TextAnalyzer();

    @Test
    void testCountWords() {
        String text = "Hello world this is a test";
        assertEquals(6, analyzer.countWords(text));
    }

    @Test
    void testCountCharacters() {
        String text = "abc 123";
        assertEquals(6, analyzer.countCharacters(text));
    }

    @Test
    void testCountUniqueWords() {
        String text = "apple orange apple banana";
        assertEquals(3, analyzer.countUniqueWords(text));
    }

    @Test
    void testMostFrequentWord() {
        String text = "dog cat dog bird dog cat";
        assertEquals("dog", analyzer.mostFrequentWord(text));
    }

    @Test
    void testWordFrequency() {
        String text = "one two one three one";
        assertEquals(3, analyzer.wordFrequency(text, "one"));
    }


}
