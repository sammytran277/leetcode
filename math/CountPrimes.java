// https://leetcode.com/problems/count-primes/

import java.util.*;

public class CountPrimes {
    public int countPrimes(int n) {
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);
        
        for (int i = 2; i * i < n; i++) {
            if (!isPrime[i]) {
                continue;
            }
            
            for (int j = i * i; j < n; j += i) {
                isPrime[j] = false;
            }
        }
        
        int res = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) {
                res++;
            }
        }
        
        return res;
    }    
}
