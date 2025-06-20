/*
Problem Statement

You are given an array of integers. Your task is to find all unique triplets (i, j, k) such that:
	•	i < j < k
	•	nums[i] + nums[j] + nums[k] == 0

You are given a Java implementation that attempts to solve this problem.
However, there is a subtle bug in the code that leads to incorrect results.

For the input:
    int[] nums = {-1, 0, 1, 2, -4};
The expected output is:
    [-1, 0, 1]
But the program currently prints two triplets:
    [-4, 2, 2]
    [-1, -0, 1]

Your Task
    •	Find and fix the bug in the provided code.
    •	Make as few modifications as possible to achieve correct behavior.
    •	Keep the overall structure and logic of the original code.
*/

import java.util.*;

public class FTask2 {

    public void threeSum(int[] nums) {
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int j = i + 1;
            int k = nums.length - 1;
            while (j <= k) {
                int sum = nums[i] + nums[j] + nums[k];

                if ((sum == 0) && (i != j)  && (j != k)) {
                    System.out.println(Arrays.asList(nums[i], nums[j], nums[k]));

                    while (j < k && nums[j] == nums[j + 1]) j++;

                    while (j < k && nums[k] == nums[k - 1]) k--;

                    j++;
                    k--;
                } else if (sum < 0) {
                    j++;
                } else {
                    k--;
                }
            }
        }
    }

    public static void main(String[] args) {
        FTask2 solution = new FTask2();

        int[] nums = {-1, 0, 1, 2, -4};

        solution.threeSum(nums);
    }
}