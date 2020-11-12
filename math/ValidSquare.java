// 

import java.util.*;

public class ValidSquare {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        Set<Integer> s = new HashSet<>();
        s.add(dist(p1, p2));
        s.add(dist(p1, p3));
        s.add(dist(p1, p4));
        s.add(dist(p2, p3));
        s.add(dist(p2, p4));
        s.add(dist(p3, p4));
        
        return s.size() == 2 && !s.contains(0);
    }
    
    public int dist(int[] a, int[] b) {
        return (a[0] - b[0]) * (a[0] - b[0]) + (a[1] - b[1]) * (a[1] - b[1]);
    }
}