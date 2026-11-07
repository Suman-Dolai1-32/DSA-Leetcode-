class Solution {
    public int[] productExceptSelf(int[] nums) {
        int ans[] = new int[nums.length];
        int c = 0;
        for(int i = 0;i<nums.length;i++)
        {
            if(nums[i] == 0)
                c++;
        }
        if(c > 1)
            return ans;
        if(c == 1)
        {
            int tm = 1;
            for(int i : nums)
            {
                if(i != 0)
                    tm *= i;
            }
            for(int i = 0;i<nums.length;i++)
            {
                if(nums[i] == 0)
                    ans[i] = tm;
            }
        }
        else
        {
            int tm = 1;
            for(int i : nums)
                tm *= i;
            for(int i = 0;i<nums.length;i++)
                ans[i] = tm/nums[i];
        }
        return ans;
    }
}