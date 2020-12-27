// https://leetcode.com/problems/can-place-flowers/

public class CanPlaceFlowers {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {        
        if (n > flowerbed.length) {
            return false;
        }
        
        int numPlaced = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            if (canPlaceAt(flowerbed, i)) {
                flowerbed[i] = 1;
                numPlaced++;
            }
        }
        
        return n <= numPlaced;
    }
    
    public boolean canPlaceAt(int[] A, int i) {
        if (A.length == 1) {
            return A[0] == 0;
        } else if (i == 0) {
            return A[i] + A[i + 1] == 0;
        } else if (i == A.length - 1) {
            return A[i] + A[i - 1] == 0;
        }
        
        return A[i - 1] + A[i] + A[i + 1] == 0;
    }
}