package com.kharevich.anagram.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class FinalSolution {


    public Collection collectAnagrams(String[] dictionary, String searchAnagramsFor) {
        int cores = Runtime.getRuntime().availableProcessors();
        if(cores>1) {
            return Arrays
                .stream(dictionary).parallel()
                .filter(el -> isAnagram(el, searchAnagramsFor))
                .collect(Collectors.toList());
        } else {
            List<String> result = new ArrayList<>();
            for (String world : dictionary) {
                if(isAnagram(world, searchAnagramsFor)) {
                    result.add(world);
                }

            }
            return result;
        }
    }

        public boolean isAnagram (String s1, String s2){
            if (s1.length() != s2.length()) {
                return false;
            }
            String arr1 = sort(s1);
            String arr2 = sort(s2);
            return arr1.equals(arr2);
        }

    private String sort(String s) {
        char[] letters = s.toCharArray();
        Arrays.sort(letters);
        return new String(letters);
    }

}
