package com.pyr.string.slidingWindow;

public class MinSubArrayLen {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int right = 0;
        int minLength = Integer.MAX_VALUE;
        int curSum = 0;

        int sLength = nums.length;
        if (sLength == 0) {
            return 0;
        }
        while (right < sLength) {
            curSum += nums[right];
            while (curSum >= target) {
                minLength = Math.min(minLength, right - left + 1);
                curSum -= nums[left];
                left++;
            }
            right++;
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}
