class Solution {
    public static class Edge
    {
        int src;
        int dest;
        Edge(int src,int dest)
        {
            this.src = src;
            this.dest = dest;
        }
    }
    public static boolean cycleDetect(ArrayList<Edge> graph[])
    {
        boolean visited[] = new boolean[graph.length];
        boolean stack[] = new boolean[graph.length];
        for(int i = 0;i<graph.length;i++)
        {
            if(!visited[i])
            {
                if(cycleDetectUtil(graph,i,visited,stack))
                    return true;
            }
        }
        return false;
    }
    public static boolean cycleDetectUtil(ArrayList<Edge> graph[],int curr,boolean visited[],boolean stack[])
    {
        visited[curr] = true;
        stack[curr] = true;
        for(Edge e : graph[curr])
        {
            if(stack[e.dest])
                return true;
            if(!visited[e.dest])
            {
                if(cycleDetectUtil(graph,e.dest,visited,stack))
                    return true;
            }
        }
        stack[curr] = false;
        return false;
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<Edge> graph[] = new ArrayList[numCourses];
        for(int i = 0;i<graph.length;i++)
            graph[i] = new ArrayList<>();
        for (int[] edge : prerequisites) {
            int course = edge[0];
            int prereq = edge[1];
            graph[prereq].add(new Edge(prereq, course));
        }
        if(cycleDetect(graph))
            return false;
        return true;
    }
}