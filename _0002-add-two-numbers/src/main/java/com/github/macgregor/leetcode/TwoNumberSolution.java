package com.github.macgregor.leetcode;

public abstract class TwoNumberSolution extends Solution {

    public TwoNumberSolution(Profiler profiler) {
        super(profiler);
    }

    public TwoNumberSolution() {
    }

    public abstract ListNode addTwoNumbers(ListNode l1, ListNode l2);
}
