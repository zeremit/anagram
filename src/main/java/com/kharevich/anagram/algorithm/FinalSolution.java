package com.kharevich.anagram.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class FinalSolution {

    public Collection collectAnagrams(String[] dictionary, String searchAnagramsFor) {
        int cores = Runtime.getRuntime().availableProcessors();
        String resultWorld = sort(searchAnagramsFor);
        if (cores > 1) {
            return Arrays
                .stream(dictionary).parallel()
                .filter(el -> fastCheck(el, resultWorld) && isAnagram(el, resultWorld))
                .collect(Collectors.toList());
        } else {
            List<String> result = new ArrayList<>();
            for (String world : dictionary) {
                if (fastCheck(world, searchAnagramsFor) && isAnagram(world, searchAnagramsFor)) {
                    result.add(world);
                }

            }
            return result;
        }
    }

    public boolean isAnagram(String s1, String s2) {
        String arr1 = sort(s1);
        return arr1.equals(s2);
    }

    private boolean fastCheck(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        int sum = 0;
        for (int i = 0; i < s1.length(); i++) {
            sum += s1.charAt(i);
            sum -= s2.charAt(i);
        }
        return sum == 0;
    }

    private String sort(String s) {
        char[] letters = s.toCharArray();
        Arrays.sort(letters);
        return new String(letters);
    }

}
