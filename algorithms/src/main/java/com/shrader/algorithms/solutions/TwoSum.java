package com.shrader.algorithms.solutions;

/*
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
You may assume that each input would have exactly one solution, and you may not use the same element twice
You can return the answer in any order.
*/
public class TwoSum {
    public TwoSum() {
        int[] nums;
        int target;

        nums = new int[]{ 2, 7, 11, 15 };
        target = 9;
        int[] result = twoSum( nums, target );
        System.out.printf( "Result: (%d,%d)%n", result[0], result[1] );

        nums = new int[]{ 3, 2, 4 };
        target = 6;
        result = twoSum( nums, target );
        System.out.printf( "Result: (%d,%d)%n", result[0], result[1] );

        nums = new int[]{ 3, 3 };
        target = 6;
        result = twoSum( nums, target );
        System.out.printf( "Result: (%d,%d)%n", result[0], result[1] );
    }

    private int[] twoSum(int[] nums, int target) {
        // brute force it
        for( int i = 0; i < nums.length; i++ ) {
            for( int j = i+1; j < nums.length; j++ ) {
                int sum = nums[i] + nums[j];
                if( sum == target ) {
                    return new int[]{ i, j };
                }
            }
        }

        return new int[]{ 0, 0 };
    }
}
