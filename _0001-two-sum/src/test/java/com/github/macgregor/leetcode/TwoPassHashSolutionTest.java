package com.github.macgregor.leetcode;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SolutionProfilerExtension.class)
public class TwoPassHashSolutionTest {

    @Test
    public void basicTest(Profiler profiler){
        int[] input = new int[]{2, 7, 11, 15};
        int target = 9;
        int[] expected = new int[]{0, 1};

        Solution solution = new TwoPassHashTableSolution(profiler);
        int[] actual = ((TwoPassHashTableSolution) solution).twoSum(input, target);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void notFoundTest(Profiler profiler){
        int[] input = new int[]{2, 7, 11, 15};
        int target = -1;
        int[] expected = new int[2];

        Solution solution = new TwoPassHashTableSolution(profiler);
        int[] actual = ((TwoPassHashTableSolution) solution).twoSum(input, target);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void emptyInputTest(Profiler profiler){
        int[] input = new int[]{};
        int target = -1;
        int[] expected = new int[2];

        Solution solution = new TwoPassHashTableSolution(profiler);
        int[] actual = ((TwoPassHashTableSolution) solution).twoSum(input, target);
        assertThat(actual).isEqualTo(expected);
    }
}
