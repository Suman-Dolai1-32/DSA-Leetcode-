class Solution {
    public static class Pair 
    {
        int i;
        int j;
        int absDiff;    
        Pair(int i,int j,int absDiff)
        {
            this.i = i;
            this.j = j;
            this.absDiff = absDiff;
        }
    }
    public boolean valid(int i,int j,int n,int m)
    {
        if(i < 0 || i >= n || j < 0 || j >= m)
            return false;
        return true;
    }
    public int dijkstra(int[][] heights,int i,int j,int n,int m)
    {
        //Initialize distance
        int distance[][] = new int[n][m];
        for(int d[] : distance)
            Arrays.fill(d,Integer.MAX_VALUE);
        distance[i][j] = 0;
        //to traverse 2D array
        final int x[] = {1,-1,0,0};
        final int y[] = {0,0,-1,1};
        //Dijkstra
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.absDiff - b.absDiff);
        boolean visited[][] = new boolean[n][m];
        pq.offer(new Pair(0,0,0));
        while(!pq.isEmpty())
        {
            Pair curr = pq.poll();
            if(curr.i == n - 1 && curr.j == m - 1)
                return curr.absDiff;
            if(!visited[curr.i][curr.j])
            {
                visited[curr.i][curr.j] = true;
                for(int k = 0;k<4;k++)
                {
                    int r = curr.i + x[k];
                    int c = curr.j + y[k];
                    if(valid(r,c,n,m) && !visited[r][c])
                    {
                        int absDiff = Math.abs(heights[curr.i][curr.j] - heights[r][c]);
                        int maxAbs = Math.max(curr.absDiff,absDiff);
                        if(maxAbs < distance[r][c])
                        {
                            distance[r][c] = maxAbs;
                            pq.offer(new Pair(r,c,distance[r][c]));
                        }
                    }
                }
            }
        }
        return -1;
    }
    public int minimumEffortPath(int[][] heights) {
        return dijkstra(heights,0,0,heights.length,heights[0].length);
    }
}