class Solution {
    public static class Edge
    {
        int src;
        int dest;
        int wt;
        Edge(int src,int dest,int wt)
        {
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }
    public static class Pair implements Comparable<Pair>
    {
        int vertex;
        int dist;
        Pair(int vertex,int dist)
        {
            this.vertex = vertex;
            this.dist = dist;
        }
        @Override
        public int compareTo(Pair p)
        {
            return Integer.compare(this.dist,p.dist);
        }
    }
    public static int dijkstra(ArrayList<Edge> graph[],int k,int n)
    {
        int distance[] = new int[n + 1];
        Arrays.fill(distance,Integer.MAX_VALUE);
        distance[k] = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(k,0));
        boolean visited[] = new boolean[n + 1];
        while(!pq.isEmpty())
        {
            Pair curr = pq.remove();
            if(!visited[curr.vertex])
            {
                visited[curr.vertex] = true;
                for(Edge e : graph[curr.vertex])
                {
                    int u = e.src;
                    int v = e.dest;
                    int wt = e.wt;
                    if(distance[u] != Integer.MAX_VALUE && distance[u] + wt < distance[v])
                    {
                        distance[v] = distance[u] + wt;
                        pq.add(new Pair(v,distance[v]));
                    }
                }
            }
        }
        int max = 0;
        for (int i = 1; i < distance.length; i++)
        {
            if (distance[i] == Integer.MAX_VALUE)
                return -1;
            max = Math.max(max, distance[i]);
        }
        return max;
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<Edge> graph[] = new ArrayList[n + 1];
        for(int i = 0;i<graph.length;i++)
            graph[i] = new ArrayList<>();
        for(int edge[] : times)
        {
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];
            graph[u].add(new Edge(u, v, wt));
        }
        return dijkstra(graph,k,n);
    }
}