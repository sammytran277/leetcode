// https://leetcode.com/problems/design-parking-system/

public class DesignParkingSystem {
    private int[] slots;
    
    public DesignParkingSystem(int big, int medium, int small) {
        slots = new int[]{big, medium, small};
    }
    
    public boolean addCar(int carType) {
        if (slots[carType - 1] > 0) {
            slots[carType - 1]--;
            return true;
        } else {
            return false;
        }
    }    
}
