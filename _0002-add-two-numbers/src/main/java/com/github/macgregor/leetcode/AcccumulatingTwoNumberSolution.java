package com.github.macgregor.leetcode;

import java.math.BigInteger;

public class AcccumulatingTwoNumberSolution extends TwoNumberSolution {

    @Override
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return toList(toNumber(l1).add(toNumber(l2)));
    }

    protected BigInteger toNumber(ListNode listNode){
        BigInteger val = BigInteger.ZERO;

        ListNode current = listNode;
        BigInteger digit = BigInteger.ONE;
        while(current != null){
            val = val.add(digit.multiply(BigInteger.valueOf(current.val)));
            digit = digit.multiply(BigInteger.TEN);
            current = current.next;
        }

        return val;
    }

    protected ListNode toList(BigInteger val){
        if(val == BigInteger.ZERO){
            return new ListNode(0);
        }

        ListNode current = null;
        ListNode prev = null;
        ListNode first = null;
        BigInteger quotient = val;
        while(quotient != BigInteger.ZERO){
            BigInteger remainder = quotient.mod(BigInteger.TEN);
            current = new ListNode(remainder.intValue());
            if(prev != null){
                prev.next = current;
            } else{
                first = current;
            }
            prev = current;
            quotient = quotient.divide(BigInteger.TEN);
        }
        return first;
    }
}
