// https://leetcode.com/problems/number-of-provinces/

public class NumberOfProvinces {
    public int findCircleNum(int[][] isConnected) {
        int numNodes = isConnected.length;
        UnionFind uf = new UnionFind(numNodes);
        
        for (int i = 0; i < numNodes; i++) {
            for (int j = 0; j < numNodes; j++) {
                if (isConnected[i][j] == 1) {
                    uf.union(i, j);
                }
            }
        }

        return uf.getNumSets();
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