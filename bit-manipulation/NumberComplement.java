// https://leetcode.com/problems/number-complement/

public class NumberComplement {
    public int findComplement(int num) {
        int i = 31;

        // Ignore leading zeroes
        while (i > 0 && (num & 1 << i) == 0)
            i--;
        
        // Flip each bit using XOR
        while (i >= 0)
            num ^= 1 << i--;
        
        return num;
    }
}