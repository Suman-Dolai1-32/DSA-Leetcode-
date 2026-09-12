import java.util.*;

class Solution {
    static class Interval {
        int l, r, w, idx;
        Interval(int l, int r, int w, int idx) {
            this.l = l;
            this.r = r;
            this.w = w;
            this.idx = idx;
        }
    }

    static class T {
        long weight;
        List<Integer> selected;
        T(long weight, List<Integer> selected) {
            this.weight = weight;
            this.selected = selected;
        }
    }

    public int[] maximumWeight(List<List<Integer>> intervals) {
        int n = intervals.size();
        Interval[] arr = new Interval[n];
        for (int i = 0; i < n; i++) {
            List<Integer> x = intervals.get(i);
            arr[i] = new Interval(x.get(0), x.get(1), x.get(2), i);
        }
        Arrays.sort(arr, (a, b) -> a.l != b.l ? Integer.compare(a.l, b.l) : Integer.compare(a.r, b.r));

        T[][] memo = new T[n + 1][5];
        return dp(arr, memo, 0, 4).selected.stream().mapToInt(Integer::intValue).toArray();
    }

    private T dp(Interval[] arr, T[][] memo, int i, int quota) {
        if (i == arr.length || quota == 0) return new T(0, new ArrayList<>());
        if (memo[i][quota] != null) return memo[i][quota];

        T skip = dp(arr, memo, i + 1, quota);

        int j = firstGreater(arr, i + 1, arr[i].r);
        T next = dp(arr, memo, j, quota - 1);

        ArrayList<Integer> pickSel = new ArrayList<>(next.selected);
        pickSel.add(arr[i].idx);
        Collections.sort(pickSel);
        T pick = new T(next.weight + arr[i].w, pickSel);

        memo[i][quota] = better(pick, skip) ? pick : skip;
        return memo[i][quota];
    }

    private boolean better(T a, T b) {
        if (a.weight != b.weight) return a.weight > b.weight;
        int n = Math.min(a.selected.size(), b.selected.size());
        for (int i = 0; i < n; i++) {
            int x = a.selected.get(i), y = b.selected.get(i);
            if (x != y) return x < y;
        }
        return a.selected.size() < b.selected.size();
    }

    private int firstGreater(Interval[] arr, int lo, int rightBoundary) {
        int l = lo, r = arr.length;
        while (l < r) {
            int m = (l + r) >>> 1;
            if (arr[m].l > rightBoundary) r = m;
            else l = m + 1;
        }
        return l;
    }
}