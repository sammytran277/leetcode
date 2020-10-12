// https://leetcode.com/problems/find-median-from-data-stream/ 

import java.util.*;

public class FindMedianFromDataStream {
    class MedianFinder {
        boolean isEven;
        Queue<Long> small;
        Queue<Long> large;
        
        public MedianFinder() {
            isEven = true;
            small = new PriorityQueue<>(Collections.reverseOrder());
            large = new PriorityQueue<>();
        }
        
        public void addNum(int num) {
            if (isEven) {
                large.add((long) num);
                small.add(large.poll());
            } else {
                small.add((long) num);
                large.add(small.poll());
            }
            
            isEven = !isEven;
        }
        
        public double findMedian() {
            if (isEven) {
                return (small.peek() + large.peek()) / 2.0;
            } else {
                return small.peek();
            }
        }
    }
}

