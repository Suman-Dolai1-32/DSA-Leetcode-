class Solution {
    public int maxPalindromes(String s, int k) {
        int n = s.length();
        int[] dp = new int[n + 1];

        for (int i = 0; i < n; i++) {
            dp[i + 1] = Math.max(dp[i + 1], dp[i]);

            for (int len = k; i + len <= n && len <= k + 1; len++) {
                if (isPal(s, i, i + len - 1)) {
                    dp[i + len] = Math.max(dp[i + len], dp[i] + 1);
                }
            }
        }

        return dp[n];
    }

    private boolean isPal(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l++) != s.charAt(r--)) return false;
        }
        return true;
    }
}