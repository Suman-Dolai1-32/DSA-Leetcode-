class Solution 
{
    public int pivotIndex(int[] nums) 
    {
        int ls = 0,ts = 0;
        for(int i : nums)
            ts += i;
        for(int i = 0;i < nums.length;i++)
        {
            if(ls == ts - ls - nums[i])
                return i;
            ls += nums[i];
        }
        return -1;
    }
}