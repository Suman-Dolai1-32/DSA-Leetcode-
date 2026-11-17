class Solution {
    public int rec(int[] nums,int i,int free,int dp[][])
    {
        if(i == nums.length)
            return 0;
        if(dp[i][free] != -1)
            return dp[i][free];
        if(free == 1)
        {
            int c1 = nums[i] + rec(nums,i+1,0,dp);
            int c2 = rec(nums,i+1,1,dp);
            dp[i][free] = Math.max(c1,c2);
            return dp[i][free];
        }
        dp[i][free] = rec(nums,i + 1,1,dp);
        return dp[i][free];
    } 
    public int rob(int[] nums) {
        int n = nums.length;
        int dp[][] = new int[n][2];
        for(int i = 0;i<n;i++)
            Arrays.fill(dp[i],-1);
        return rec(nums,0,1,dp);

    }
}