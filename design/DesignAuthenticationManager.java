// https://leetcode.com/problems/design-authentication-manager/

import java.util.*;

public class DesignAuthenticationManager {
    private Map<String, Integer> map;
    private int timeToLive;
    
    public DesignAuthenticationManager(int timeToLive) {
        this.map = new HashMap<>();
        this.timeToLive = timeToLive;
    }
    
    public void generate(String tokenId, int currentTime) {
        map.put(tokenId, currentTime + timeToLive);
    }
    
    public void renew(String tokenId, int currentTime) {
        if (map.containsKey(tokenId) && map.get(tokenId) > currentTime) {
            map.put(tokenId, currentTime + timeToLive);
        }
    }
    
    public int countUnexpiredTokens(int currentTime) {
        int res = 0;
        for (int value : map.values()) {
            if (value > currentTime) {
                res++;
            }
        }
        
        return res;
    }
}