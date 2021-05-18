// https://leetcode.com/problems/redundant-connection/

public class RedundantConnection {
    public int[] findRedundantConnection(int[][] edges) {
        // Redundant if find(u) == find(v) for an edge [u, v]
        UnionFind uf = new UnionFind(edges.length);
        for (int[] edge : edges) {
            int u = edge[0] - 1;
            int v = edge[1] - 1;
            if (uf.find(u) == uf.find(v)) {
                return edge;
            } else {
                uf.union(u, v);
            }
        }
        
        return new int[2];
    }
    
    private class UnionFind {
        private int numSets;
        private int[] parent;

        public UnionFind(int n) {
            numSets = n;
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int getNumSets() {
            return numSets;
        }

        public int find(int u) {
            if (u == parent[u]) {
                return u;
            }

            parent[u] = find(parent[u]);
            return parent[u];
        }

        public void union(int u, int v) {
            int uRoot = find(u);
            int vRoot = find(v);
            if (uRoot != vRoot) {
                parent[vRoot] = uRoot;
                numSets--;
            }
        }
    }       
}