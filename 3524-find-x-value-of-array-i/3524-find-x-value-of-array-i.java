class Solution {
    public long[] resultArray(int[] nums, int k) {
        long[] ans = new long[k];
        long[] dp = new long[k];

        int[] lurminexod = nums;

        for (int num : lurminexod) {
            long[] ndp = new long[k];
            int m = num % k;

            ndp[m] = 1;
            for (int i = 0; i < k; i++) {
                if (dp[i] != 0) {
                    ndp[(int)((1L * i * m) % k)] += dp[i];
                }
            }

            for (int i = 0; i < k; i++) {
                ans[i] += ndp[i];
            }
            dp = ndp;
        }

        return ans;
    }
}