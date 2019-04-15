package com.github.macgregor.leetcode;

/**
 * Difficulty: [ Medium ]
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Example:
 *
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 */
public class BruteForceAddTwoNumbersSolution extends TwoNumberSolution {
    public BruteForceAddTwoNumbersSolution(Profiler profiler) {
        super(profiler);
    }

    public BruteForceAddTwoNumbersSolution() {
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return toList(toNumber(l1) + toNumber(l2));
    }

    long toNumber(ListNode listNode){
        ListNode current = listNode;
        String representation = "";
        while(current != null){
            getProfiler().iterate().compare();
            representation = Integer.toString(current.val) + representation;
            current = current.next;
        }
        return Long.parseLong(representation);
    }

    ListNode toList(Long number){
        char[] representation = number.toString().toCharArray();
        ListNode current = null;
        ListNode first = null;
        for(int i = representation.length - 1; i >= 0; i--){
            getProfiler().iterate().compare();
            ListNode next = new ListNode(Integer.parseInt(String.valueOf(representation[i])));
            if(current != null){
                current.next = next;
            } else{
                first = next;
            }
            current = next;
        }
        return first;
    }
}
