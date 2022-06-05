class Solution{
    //Time:O(n)
    //Space:O(1)
    public int maxSubArray(int[] nums){
        int subSum = nums[0];
        int maxSum = nums[0];
        
        for(int i=1; i<nums.length; i++){
            subSum = Math.max(nums[i], nums[i] + subSum);
            maxSum = Math.max(subSum, maxSum);
        }
        return maxSum;
    }
}