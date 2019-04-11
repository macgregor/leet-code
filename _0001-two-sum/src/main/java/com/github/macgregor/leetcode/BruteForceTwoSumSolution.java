package com.github.macgregor.leetcode;

/**
 * Difficulty: [ Easy ]
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * Example:
 *
 * Given nums = [2, 7, 11, 15], target = 9,
 *
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 */
public class BruteForceTwoSumSolution extends Solution {

    public BruteForceTwoSumSolution(Profiler profiler) {
        super(profiler);
    }

    public int[] twoSum(int[] nums, int target) {
        int[] indices = new int[2];
        for(int i = 0; i < nums.length; i++){
            getProfiler().iterate();
            for(int j = i+1; j < nums.length; j++){
                getProfiler().iterate().compare();
                if(nums[i] + nums[j] == target){
                    indices[0] = i;
                    indices[1] = j;
                    break;
                }
            }
        }
        return indices;
    }
}
