package com.github.macgregor.leetcode;

public abstract class Solution {

    protected Profiler profiler;

    public Solution() {
    }

    public Solution(Profiler profiler) {
        this.profiler = profiler;
    }

    public Profiler getProfiler() {
        return profiler;
    }

    public void setProfiler(Profiler profiler) {
        this.profiler = profiler;
    }
}
