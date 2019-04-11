package com.github.macgregor.leetcode;

import java.util.HashMap;
import java.util.Map;

public class TwoPassHashTableSolution extends Solution {

    public TwoPassHashTableSolution(Profiler profiler) {
        super(profiler);
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for(int i = 0; i < nums.length; i++){
            getProfiler().iterate();
            map.put(nums[i], i);
        }
        for(int i = 0; i < nums.length; i++){
            getProfiler().iterate().compare();
            if(map.containsKey(target - nums[i])){
                return new int[]{i, map.get(target - nums[i])};
            }
        }
        return new int[2];
    }
}
