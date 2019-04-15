package com.github.macgregor.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Difficulty: [ Medium ]
 *
 * Given a string, find the length of the longest substring without repeating characters.
 *
 * Example 1:
 *
 * Input: "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 *
 * Input: "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 *
 * Input: "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 *              Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class LongestSubstringSolution extends Solution{
    public LongestSubstringSolution() {
    }

    public LongestSubstringSolution(Profiler profiler) {
        super(profiler);
    }

    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }

        // keep track of characters encountered and the last encountered position
        Map<Character, Integer> encountered = new HashMap<>();

        int maxLength = 0, start = 0, i = 0;
        for(i = 0; i < s.length(); i++){
            getProfiler().iterate();
            char c = s.charAt(i);
            if(encountered.containsKey(c) && encountered.get(c) >= start){
                maxLength = i - start > maxLength ? i - start : maxLength;
                start = encountered.get(c) + 1;

                // if there are fewer remaining characters in the string than current maxLength there no way a longer substring can be found
                if(s.length() - start < maxLength){
                    break;
                }
            }
            encountered.put(c, i);
        }
        maxLength = i - start > maxLength ? i - start : maxLength;
        return maxLength;
    }
}
