class Solution {
    public static class Pair
    {
        int i;
        int j;
        Pair(int i,int j)
        {
            this.i = i;
            this.j = j;
        }
    }
    public boolean valid(int i,int j,int n,int m)
    {
        if(i < 0 || i >= n || j < 0 || j >= m)
            return false;
        return true;
    }
    public boolean BFS(int grid[][],int currTime)
    {
        final int x[] = {-1,1,0,0};
        final int y[] = {0,0,-1,1};
        boolean visited[][] = new boolean[grid.length][grid[0].length];
        Queue<Pair> pq = new LinkedList<>();
        pq.add(new Pair(0,0));
        while(!pq.isEmpty())
        {
            Pair curr = pq.remove();
            if(curr.i == grid.length - 1 && curr.j == grid[0].length - 1)
                return true;
            if(!visited[curr.i][curr.j])
            {
                visited[curr.i][curr.j] = true;
                for(int k = 0;k<4;k++)
                {
                    int r = curr.i + x[k];
                    int c = curr.j + y[k];
                    if(valid(r, c, grid.length, grid[0].length) && !visited[r][c] && currTime >= grid[r][c])
                        pq.add(new Pair(r, c));
                }
            }
        }
        return false;
    }
    public int swimInWater(int[][] grid) {
        int low = grid[0][0];
        int high = Integer.MIN_VALUE;
        for(int i = 0;i<grid.length;i++)
        {
            for(int j = 0;j<grid[0].length;j++)
                high = Math.max(high, grid[i][j]);
        }
        int ans = 0;
        while(low <= high)
        {
            int mid = (low + high)/2;
            if(!BFS(grid, mid))
                low = mid + 1;
            else
            {
                ans = mid;
                high = mid - 1;
            }
        }
        return ans;
    }
}