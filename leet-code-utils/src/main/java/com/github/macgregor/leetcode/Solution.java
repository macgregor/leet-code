package com.github.macgregor.leetcode;

public abstract class Solution {

    protected final Profiler profiler;

    public Solution(Profiler profiler) {
        this.profiler = profiler;
    }

    public Profiler getProfiler() {
        return profiler;
    }
}
