class Solution {
    public int max(int[] nums,int i)
    {   
        int max = Integer.MIN_VALUE;
        for(int j = 0;j<=i;j++)
            max = Math.max(max,nums[j]);
        return max;
    }
    public int min(int[] nums,int i)
    {
        int min = Integer.MAX_VALUE;
        for(int j = i;j<nums.length;j++)
            min = Math.min(min,nums[j]);
        return min;
    }
    public int firstStableIndex(int[] nums, int k) {
        int indx = Integer.MAX_VALUE;
        for(int i = 0;i<nums.length;i++)
        {
            int mx = max(nums,i);
            int mn = min(nums,i);
            int sc = mx - mn;
            if(sc <= k)
                indx = Math.min(indx,i);
        }
        return (indx == Integer.MAX_VALUE)?-1:indx;
    }
}