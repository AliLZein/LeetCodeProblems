class Solution 
{
    public int[] findRedundantConnection(int[][] edges) 
    {
        int n = edges.length;
        UnionFind uf = new UnionFind(n + 1);

        for (int[] edge : edges) 
        {
            int u = edge[0];
            int v = edge[1];

            if (!uf.union(u, v)) 
            {
                return edge;
            }
        }

        return new int[0];
    }

    private class UnionFind 
    {
        private int[] parent;

        public UnionFind(int size) 
        {
            parent = new int[size];
            for (int i = 0; i < size; i++) 
            {
                parent[i] = i;
            }
        }

        public int find(int node) 
        {
            if (parent[node] != node) 
            {
                parent[node] = find(parent[node]);
            }
            return parent[node];
        }

        public boolean union(int u, int v) 
        {
            int rootU = find(u);
            int rootV = find(v);

            if (rootU == rootV)
            {
                return false; 
            }

            parent[rootU] = rootV;
            return true;
        }
    }
}