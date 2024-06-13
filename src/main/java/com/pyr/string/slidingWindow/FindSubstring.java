package com.pyr.string.slidingWindow;

import java.util.HashMap;

public class FindSubstring {
    public static Integer[] minSubArrayLen(String s, String[] words) {
        int left = 0;
        Integer[] startPos;
        HashMap<String, Integer> map;
        for (int i = 0; i < s.length(); i++) {

        }
        return null;
    }

    public static void main(String[] args) {
        String s = "barfoothefoobarman";
        String[] words = new String[]{"foo", "bar"};
        Integer[] substring = minSubArrayLen(s, words);
        System.out.println(substring);
    }
}
