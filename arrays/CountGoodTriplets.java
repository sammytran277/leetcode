// https://leetcode.com/problems/count-good-triplets/

public class CountGoodTriplets {
    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                for (int k = j + 1; k < arr.length; k++) {
                    boolean c1 = Math.abs(arr[i] - arr[j]) <= a;
                    boolean c2 = Math.abs(arr[j] - arr[k]) <= b;
                    boolean c3 = Math.abs(arr[i] - arr[k]) <= c;
                    if (c1 && c2 && c3) {
                        res++;
                    }
                }
            }
        }
        
        return res;
    }    
}
