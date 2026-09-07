class Solution {
    public int distinctSubseqII(String s) {
        final int MOD = 1_000_000_007;

        long[] dp = new long[26];

        for (char ch : s.toCharArray()) {
            int idx = ch - 'a';

            long sum = 1; // current character alone

            for (long x : dp) {
                sum = (sum + x) % MOD;
            }

            dp[idx] = sum;
        }

        long ans = 0;

        for (long x : dp) {
            ans = (ans + x) % MOD;
        }

        return (int) ans;
    }
}