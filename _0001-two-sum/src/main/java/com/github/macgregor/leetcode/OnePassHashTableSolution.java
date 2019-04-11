package com.github.macgregor.leetcode;

import java.util.HashMap;
import java.util.Map;

public class OnePassHashTableSolution extends Solution {
    public OnePassHashTableSolution(Profiler profiler) {
        super(profiler);
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for(int i = 0; i < nums.length; i++){
            getProfiler().iterate().compare();
            if(map.containsKey(target - nums[i])){
                return new int[]{map.get(target - nums[i]), i};
            } else{
                map.put(nums[i], i);
            }
        }
        return new int[2];
    }
}
