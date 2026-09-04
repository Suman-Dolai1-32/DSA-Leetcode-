class Solution {
    public int[] productExceptSelf(int[] nums) {
        int p[] = new int[nums.length];
        p[0] = 1;
        for(int i = 1;i<nums.length;i++)
            p[i] = nums[i - 1] * p[i - 1];
        int s[] = new int[nums.length];
        s[nums.length - 1] = 1;
        for(int i = nums.length - 2;i >= 0;i--)
            s[i] = nums[i + 1] * s[i + 1];
        int ans[] = new int[nums.length];
        for(int i = 0;i<nums.length;i++)
            ans[i] = p[i] * s[i];
        return ans;
    }
}