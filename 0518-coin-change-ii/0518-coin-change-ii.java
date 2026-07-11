class Solution {
    public int change(int amount, int[] coins) {
        if(coins.length == 1 && amount % coins[0] != 0)
            return 0;
        int n = coins.length;
        int dp[][] = new int[n + 1][amount + 1];
        for(int i = 0;i<n+1;i++)
            dp[i][0] = 1;
        for(int i = 1;i<amount+1;i++)
            dp[n][i] = 0;
        for(int i = n - 1;i>=0;i--)
        {
            for(int j = 1;j <= amount;j++)
            {
                if(coins[i] <= j)
                    dp[i][j] = dp[i][j - coins[i]] + dp[i+1][j];
                else
                    dp[i][j] = dp[i+1][j];
            }
        }
        return dp[0][amount];
    }
}