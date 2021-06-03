// https://leetcode.com/problems/find-the-winner-of-the-circular-game/

import java.util.*;

public class FindTheWinnerOfTheCircularGame {
    public int findTheWinner(int n, int k) {
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            deque.addLast(i);
        }
        
        while (deque.size() > 1) {
            int currFriend;
            for (int i = 0; i < k; i++) {
                currFriend = deque.pollFirst();
                if (i != k - 1) {
                    deque.addLast(currFriend);
                }
            }
        }
        
        return deque.pollFirst();
    }    
}
