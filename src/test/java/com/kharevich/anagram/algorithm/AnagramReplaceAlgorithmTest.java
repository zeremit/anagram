package com.kharevich.anagram.algorithm;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AnagramReplaceAlgorithmTest {

    AnagramFindAlgorithm anagramFindAlgorithm = new AnagramReplaceAlgorithm();

    @Test
    public void testIsAnagram() {
        Assertions.assertTrue(anagramFindAlgorithm.isAnagram("cat", "tac"));
    }

    @Test
    public void testIsAnagramFalse() {
        Assertions.assertFalse(anagramFindAlgorithm.isAnagram("cat", "ta"));
    }

    @Test
    public void testIsAnagramFalse1() {
        Assertions.assertFalse(anagramFindAlgorithm.isAnagram("cat", "catt"));
    }
}
