// https://leetcode.com/problems/number-of-operations-to-make-network-connected/ 

public class NumberOfOperationsToMakeNetworkConnected {
    public int makeConnected(int n, int[][] connections) {
        int numRedundantConnections = 0;
        UnionFind uf = new UnionFind(n);
        
        for (int[] connection : connections) {
            int u = connection[0];
            int v = connection[1];
            if (uf.find(u) == uf.find(v)) {
                numRedundantConnections++;
            } else {
                uf.union(u, v);
            }
        }
        
        if (numRedundantConnections >= uf.getNumSets() - 1) {
            return uf.getNumSets() - 1;
        }
        
        return -1;
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
