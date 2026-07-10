class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int sum = 0;
        for(int i : nums)
            sum += i;
        if (Math.abs(target) > sum)
            return 0;
        if((target + sum)%2 != 0)
            return 0;
        int t = (target + sum)/2;
        int dp[][] = new int[n + 1][t + 1];
        for(int i = 0;i<n + 1;i++)
            dp[i][0] = 1;
        for(int i = 1;i<target + 1;i++)
            dp[n][i] = 0;
        for(int i = n - 1;i>=0;i--)
        {
            for(int j = 0;j<t + 1;j++)
            {
                if(nums[i] <= j)
                    dp[i][j] = (dp[i + 1][j - nums[i]] + dp[i + 1][j]);
                else
                    dp[i][j] = dp[i + 1][j];
            }
        }
        return dp[0][t];
    }
}