// https://leetcode.com/problems/destination-city/

import java.util.*;

public class DestinationCity {
    public String destCity(List<List<String>> paths) {
        Set<String> fromCity = new HashSet<String>();
        Set<String> toCity = new HashSet<String>();
        
        for (List<String> path: paths) {
            fromCity.add(path.get(0));
            toCity.add(path.get(1));
        }
        
        for (String city : toCity) {
            if (!fromCity.contains(city)) {
                return city;
            }
        }
        
        return "";
    }
}