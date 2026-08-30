class Solution {
    public int minimumDeletions(int[] nums) {
        if(nums.length == 1)
            return 1;
        if(nums.length == 2)
            return 2;
        int n = nums.length;
        int minIndex = 0;
        int maxIndex = 0;
        for (int i = 1; i < n; i++) 
        {
            if (nums[i] < nums[minIndex]) 
                minIndex = i;
            if (nums[i] > nums[maxIndex])
                maxIndex = i;
        }
        int left = Math.min(minIndex, maxIndex);
        int right = Math.max(minIndex, maxIndex);
        int case1 = right + 1;
        int case2 = n - left;
        int case3 = (left + 1) + (n - right);
        return Math.min(case1, Math.min(case2, case3));
    }
}