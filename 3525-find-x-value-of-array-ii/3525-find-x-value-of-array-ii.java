class Solution {
    private static final int MAXK = 5;

    private int n, size, k;
    private int[] prod;
    private int[][] cnt;

    public int[] resultArray(int[] nums, int k, int[][] queries) {
        this.n = nums.length;
        this.k = k;

        for (int i = 0; i < n; i++) nums[i] %= k;
        for (int[] q : queries) q[1] %= k;

        size = 1;
        while (size < n) size <<= 1;

        prod = new int[size << 1];
        cnt = new int[MAXK][size << 1];

        for (int i = 0; i < n; i++) {
            int p = size + i;
            prod[p] = nums[i];
            cnt[nums[i]][p] = 1;
        }

        for (int i = size - 1; i >= 1; i--) pull(i);

        int[] ans = new int[queries.length];
        for (int qi = 0; qi < queries.length; qi++) {
            int idx = queries[qi][0];
            int val = queries[qi][1];
            int start = queries[qi][2];
            int x = queries[qi][3];

            update(idx, val);
            ans[qi] = query(start, n - 1, x);
        }
        return ans;
    }

    private void update(int idx, int val) {
        int p = size + idx;
        for (int r = 0; r < k; r++) cnt[r][p] = 0;
        cnt[val][p] = 1;
        prod[p] = val;

        for (p >>= 1; p >= 1; p >>= 1) pull(p);
    }

    private void pull(int i) {
        int l = i << 1, r = l | 1;
        prod[i] = (prod[l] * prod[r]) % k;

        for (int x = 0; x < k; x++) cnt[x][i] = cnt[x][l];
        for (int x = 0; x < k; x++) cnt[(x * prod[l]) % k][i] += cnt[x][r];
    }

    private int query(int l, int r, int target) {
        int[] leftCnt = new int[MAXK];
        int[] rightCnt = new int[MAXK];
        int[] tmp = new int[MAXK];
        int leftProd = 1, rightProd = 1;

        l += size;
        r += size;

        while (l <= r) {
            if ((l & 1) == 1) {
                for (int i = 0; i < MAXK; i++) tmp[i] = 0;
                for (int i = 0; i < k; i++) tmp[i] = leftCnt[i];
                for (int i = 0; i < k; i++) tmp[(leftProd * i) % k] += cnt[i][l];
                leftProd = (leftProd * prod[l]) % k;
                for (int i = 0; i < k; i++) leftCnt[i] = tmp[i];
                l++;
            }
            if ((r & 1) == 0) {
                for (int i = 0; i < MAXK; i++) tmp[i] = 0;
                for (int i = 0; i < k; i++) tmp[i] = cnt[i][r];
                for (int i = 0; i < k; i++) tmp[(prod[r] * i) % k] += rightCnt[i];
                rightProd = (prod[r] * rightProd) % k;
                for (int i = 0; i < k; i++) rightCnt[i] = tmp[i];
                r--;
            }
            l >>= 1;
            r >>= 1;
        }

        for (int i = 0; i < MAXK; i++) tmp[i] = 0;
        for (int i = 0; i < k; i++) tmp[i] = leftCnt[i];
        for (int i = 0; i < k; i++) tmp[(leftProd * i) % k] += rightCnt[i];

        return tmp[target];
    }
}