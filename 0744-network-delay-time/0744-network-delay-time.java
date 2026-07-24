class Solution 
{
    public int networkDelayTime(int[][] times, int n, int k) 
    {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int i = 1; i <= n; i++) 
        {
            graph.put(i, new ArrayList<>());
        }
        for (int[] time : times) 
        {
            int u = time[0];
            int v = time[1];
            int w = time[2];
            graph.get(u).add(new int[]{v, w});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[k] = 0;
        pq.add(new int[]{0, k});

        while (!pq.isEmpty()) 
        {
            int[] current = pq.poll();
            int time = current[0];
            int u = current[1];

            if (time > dist[u]) continue;

            for (int[] edge : graph.get(u)) 
            {
                int v = edge[0];
                int weight = edge[1];

                if (dist[u] + weight < dist[v]) 
                {
                    dist[v] = dist[u] + weight;
                    pq.add(new int[]{dist[v], v});
                }
            }
        }

        int maxTime = 0;
        for (int i = 1; i <= n; i++) 
        {
            if (dist[i] == Integer.MAX_VALUE) 
            {
                return -1; 
            }
            maxTime = Math.max(maxTime, dist[i]);
        }

        return maxTime;
    }
}