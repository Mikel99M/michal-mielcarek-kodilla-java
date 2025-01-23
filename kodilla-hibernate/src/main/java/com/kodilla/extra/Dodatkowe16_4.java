package com.kodilla.extra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Dodatkowe16_4 {

    public int findSecondMin (int[] nums) {
        if (nums == null || nums.length < 2) {
            throw new IllegalArgumentException("You need at least 2 numbers");
        }

        Arrays.sort(nums);

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (!list.contains(nums[i])) {
                list.add(nums[i]);
            }
        }
        return list.get(1);
    }

    public int findSecondMax (int[] nums) {
        if (nums == null || nums.length < 2) {
            throw new IllegalArgumentException("You need at least 2 numbers");
        }

        Arrays.sort(nums);

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (!list.contains(nums[i])) {
                list.add(nums[i]);
            }
        }
        return list.get(list.size()-2);
    }
}