package com.github.macgregor.leetcode;

import java.util.Objects;

public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ListNode listNode = (ListNode) o;
        if(val != listNode.val){
            return false;
        }
        if(next != null && listNode.next != null){
            return next.equals(listNode.next);
        } else if(next == null && listNode.next == null){
            return true;
        } else{
            return false;
        }
    }

    @Override
    public int hashCode() {

        return Objects.hash(val, next);
    }
}
