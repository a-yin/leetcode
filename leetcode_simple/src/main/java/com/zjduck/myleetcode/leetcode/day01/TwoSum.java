package com.zjduck.myleetcode.leetcode.day01;

import java.util.Arrays;

/**
 * 两数之和：给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。
 *
 * Created by ZJDuck on 2018/9/1
 */
public class TwoSum {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 2, 6};
        int target = 7;
        System.out.println(Arrays.toString(twoSum(arr, target)));
        System.out.println(Arrays.toString(twoSum1(arr, target)));
    }

    /**
     * 参考算法
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == target - nums[i]) {
                    return new int[] { i, j };
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    /**
     * 我的算法
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum1(int[] nums, int target) {
        int len = nums.length;
        int first, second, sum = 0;

        for (int i = 0; i < len-1; i++) {
            first = nums[i];
            int j = i + 1;
            for (; j <= len-1; j++) {
                second = nums[j];
                sum = first + second;
                if (target == sum) {
                    return new int[] {i, j};
                }
            }
        }
        return null;
    }













}
