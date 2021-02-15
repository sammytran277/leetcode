// https://leetcode.com/problems/the-k-weakest-rows-in-a-matrix/

import java.util.*;

public class TheKWeakestRowsInAMatrix {
    public int[] kWeakestRows(int[][] mat, int k) {
        int rows = mat.length;
        int cols = mat[0].length;
        Pair[] soldiers = new Pair[rows];
        for (int i = 0; i < rows; i++) {
            int numSoldiers = 0;
            for (int j = 0; j < cols; j++) {
                if (mat[i][j] == 1) {
                    numSoldiers++;
                } else {
                    break;
                }
            }
            
            soldiers[i] = new Pair(i, numSoldiers);
        }
        
        Arrays.sort(soldiers);
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = soldiers[i].idx;
        }
        
        return res;
    }
    
    class Pair implements Comparable<Pair> {
        int idx;
        int soldiers;
        
        public Pair(int idx, int soldiers) {
            this.idx = idx;
            this.soldiers = soldiers;
        }
        
        public int compareTo(Pair p) {
            if (soldiers == p.soldiers) {
                return Integer.compare(idx, p.idx);
            }
            
            return Integer.compare(soldiers, p.soldiers);
        }
    }
}