import java.util.*;

class Solution {
    public int minCost(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int maxV = 0;
        for (int[] row : grid) {
            for (int x : row) maxV = Math.max(maxV, x);
        }

        int mx = 1;
        while (mx <= maxV) mx <<= 1;

        boolean[][] prev = new boolean[n][mx];
        boolean[][] curr = new boolean[n][mx];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(curr[j], false);
                int x = grid[i][j];

                if (i == 0 && j == 0) {
                    curr[j][x] = true;
                    continue;
                }

                if (i > 0) {
                    boolean[] up = prev[j];
                    for (int k = 0; k < mx; k++) {
                        if (up[k ^ x]) curr[j][k] = true;
                    }
                }

                if (j > 0) {
                    boolean[] left = curr[j - 1];
                    for (int k = 0; k < mx; k++) {
                        if (left[k ^ x]) curr[j][k] = true;
                    }
                }
            }

            boolean[][] tmp = prev;
            prev = curr;
            curr = tmp;
        }

        for (int k = 0; k < mx; k++) {
            if (prev[n - 1][k]) return k;
        }
        return -1;
    }
}