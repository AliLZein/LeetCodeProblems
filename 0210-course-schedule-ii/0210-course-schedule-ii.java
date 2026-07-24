class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) 
    {
        List<List<Integer>> graph = new ArrayList<>();
        int[] inDegree = new int[numCourses];

        for (int i = 0; i < numCourses; i++) 
        {
            graph.add(new ArrayList<>());
        }

        for (int[] req : prerequisites) 
        {
            int course = req[0];
            int prereq = req[1];
            graph.get(prereq).add(course);
            inDegree[course]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) 
        {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        int[] result = new int[numCourses];
        int index = 0;

        while (!queue.isEmpty()) 
        {
            int current = queue.poll();
            result[index++] = current;

            for (int neighbor : graph.get(current)) 
            {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) 
                {
                    queue.add(neighbor);
                }
            }
        }

        if (index == numCourses) 
        {
            return result;
        } 
        else 
        {
            return new int[0];
        }
    }
}