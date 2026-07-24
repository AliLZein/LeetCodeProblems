class Solution 
{
    public boolean canFinish(int numCourses, int[][] prerequisites) 
    {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) 
        {
            graph.add(new ArrayList<>());
        }

        for (int[] req : prerequisites) 
        {
            int course = req[0];
            int prereq = req[1];
            graph.get(prereq).add(course);
        }

        int[] state = new int[numCourses];

        for (int i = 0; i < numCourses; i++) 
        {
            if (state[i] == 0) 
            {
                if (hasCycle(i, graph, state)) 
                {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean hasCycle(int node, List<List<Integer>> graph, int[] state) 
    {
        if (state[node] == 1) return true;
        
        if (state[node] == 2) return false;

        state[node] = 1;

        for (int neighbor : graph.get(node)) 
        {
            if (hasCycle(neighbor, graph, state)) 
            {
                return true;
            }
        }

        state[node] = 2;
        return false;
    }
}