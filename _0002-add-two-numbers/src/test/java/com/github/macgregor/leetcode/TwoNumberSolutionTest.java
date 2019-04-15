package com.github.macgregor.leetcode;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SolutionProfilerExtension.class)
public class TwoNumberSolutionTest {

    @ParameterizedTest
    @MethodSource("solutions")
    public void basicTest(TwoNumberSolution twoNumberSolution, Profiler profiler) {
        twoNumberSolution.setProfiler(profiler);
        ListNode l1 = createList(342L);
        ListNode l2 = createList(465L);
        ListNode expected = createList(807L);
        ListNode actual = twoNumberSolution.addTwoNumbers(l1, l2);
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("solutions")
    public void solutionGreaterThanMaxInt(TwoNumberSolution twoNumberSolution, Profiler profiler){
        twoNumberSolution.setProfiler(profiler);
        ListNode l1 = createList(1000000000L);
        ListNode l2 = createList(1000000000L);
        ListNode expected = createList(1000000000L+1000000000L);
        ListNode actual = twoNumberSolution.addTwoNumbers(l1, l2);
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("solutions")
    public void zero(TwoNumberSolution twoNumberSolution, Profiler profiler){
        twoNumberSolution.setProfiler(profiler);
        ListNode l1 = createList(0);
        ListNode l2 = createList(0);
        ListNode expected = createList(0);
        ListNode actual = twoNumberSolution.addTwoNumbers(l1, l2);
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("solutions")
    public void inputGreaterThanMaxInt(TwoNumberSolution twoNumberSolution, Profiler profiler){
        twoNumberSolution.setProfiler(profiler);
        ListNode l1 = createList(9);
        ListNode l2 = createList(9999999991L);
        ListNode expected = createList(10000000000L);
        ListNode actual = twoNumberSolution.addTwoNumbers(l1, l2);
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("solutions")
    public void inputGreaterThanMaxLong(TwoNumberSolution twoNumberSolution, Profiler profiler){
        twoNumberSolution.setProfiler(profiler);
        ListNode l1 = createList("1000000000000000000000000000001");
        ListNode l2 = createList(465L);
        ListNode expected = createList("1000000000000000000000000000466");
        ListNode actual = twoNumberSolution.addTwoNumbers(l1, l2);
        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> solutions() {
        return Stream.of(
                Arguments.of(new BruteForceAddTwoNumbersSolution()),
                Arguments.of(new AcccumulatingTwoNumberSolution()));
    }

    ListNode createList(Long val){
        return createList(val.toString());
    }

    ListNode createList(String val){
        char[] representation = val.toCharArray();
        int[] values = new int[representation.length];
        for(int i = 0; i < representation.length; i++){
            values[i] = Integer.parseInt(Character.toString(representation[i]));
        }
        return createList(values);
    }

    ListNode createList(int... val){
        ListNode next = null;
        ListNode current = null;
        for(int i = 0; i < val.length; i++){
            current = new ListNode(val[i]);
            current.next = next;
            next = current;
        }
        return next;
    }
}
