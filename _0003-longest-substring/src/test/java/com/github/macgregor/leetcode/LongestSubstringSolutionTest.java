package com.github.macgregor.leetcode;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SolutionProfilerExtension.class)
public class LongestSubstringSolutionTest {

    @Test
    public void sampleInputTest1(Profiler profiler){
        LongestSubstringSolution solution = new LongestSubstringSolution(profiler);
        assertThat(solution.lengthOfLongestSubstring("abcabcbb")).isEqualTo(3);
    }

    @Test
    public void sampleInputTest2(Profiler profiler){
        LongestSubstringSolution solution = new LongestSubstringSolution(profiler);
        assertThat(solution.lengthOfLongestSubstring("bbbbb")).isEqualTo(1);
    }

    @Test
    public void sampleInputTest3(Profiler profiler){
        LongestSubstringSolution solution = new LongestSubstringSolution(profiler);
        assertThat(solution.lengthOfLongestSubstring("pwwkew")).isEqualTo(3);
    }

    @Test
    public void sampleInputTest4(Profiler profiler){
        LongestSubstringSolution solution = new LongestSubstringSolution(profiler);
        assertThat(solution.lengthOfLongestSubstring("dvdf")).isEqualTo(3);
    }

    @Test
    public void sampleInputTest5(Profiler profiler){
        LongestSubstringSolution solution = new LongestSubstringSolution(profiler);
        assertThat(solution.lengthOfLongestSubstring("anviaj")).isEqualTo(5);
    }

    @Test
    public void lengthZero(Profiler profiler){
        LongestSubstringSolution solution = new LongestSubstringSolution(profiler);
        assertThat(solution.lengthOfLongestSubstring("")).isEqualTo(0);
    }

    @Test
    public void lengthOne(Profiler profiler){
        LongestSubstringSolution solution = new LongestSubstringSolution(profiler);
        assertThat(solution.lengthOfLongestSubstring("a")).isEqualTo(1);
    }

    @Test
    public void repeatesBefore(Profiler profiler){
        LongestSubstringSolution solution = new LongestSubstringSolution(profiler);
        assertThat(solution.lengthOfLongestSubstring("aaaaaaabc")).isEqualTo(3);
    }

    @Test
    public void repeatesAfter(Profiler profiler){
        LongestSubstringSolution solution = new LongestSubstringSolution(profiler);
        assertThat(solution.lengthOfLongestSubstring("abcaaaaaa")).isEqualTo(3);
    }

    @Test
    public void longSubString(Profiler profiler){
        LongestSubstringSolution solution = new LongestSubstringSolution(profiler);
        assertThat(solution.lengthOfLongestSubstring("...................abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ...................")).isEqualTo(53);
    }
}
