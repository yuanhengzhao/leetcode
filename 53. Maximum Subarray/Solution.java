class Solution {
    public int maxSubArray(int[] nums) {
        /*
        https://leetcode.com/problems/maximum-subarray/description/
        To get the max subarray, negative or positive number is the key. Think about if A[i..j] is the max subarray, A[i] and A[j] must be positive number. 
        Otherwise A[i-1..j] or A[i..j-1].sum should be bigger than A[i..j]. So our job should be find the first positive number and then start the algorithm.
        To be noticed, if all the number is negative, the result should be the biggest negative number in the array.
        So in the algorithm, I try to find the first positive number and assign it to curSum, if the curSum is positive, it could be part of the Sum.
        Keep adding numbers into curSum, if the curSum is smaller than 0, it can not be part of the maxSum. So drop it.
        Everytime compare the curSum with maxSum, if maxSum smaller than curSum, so replace it. 
        对于这道题，考虑数字的正负是关键。子数列的首尾一定是正的。所以我们先找到正数，然后开始累加。如果整个数列都是负数，那么挑出最大的即可。
        那么首先就是找正数，我设定了curSum这个参数，先找到第一个正数，把值付给它。然后从curSum为正开始，把后续的数累加在curSum上。在累加的过程中，如果curSum小于0，那么它继续累加
        就没有意义了。所以不再进行累加，找下一个正数以便开始累加。
        然后在累加的过程中不停的选择maxSum和curSum的最大值，赋给maxSum。最后返回结果。
        */
        int maxSum = Integer.MIN_VALUE;
        int curSum = 0;
        for (int i=0; i < nums.length; i++) {
            if (curSum > 0){
                curSum += nums[i];
            }else{
                curSum = nums[i];
            }
            if (curSum > maxSum){
                maxSum = curSum;
            }
        }
        return maxSum;
    }
}