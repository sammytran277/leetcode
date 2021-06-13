// https://leetcode.com/problems/find-the-student-that-will-replace-the-chalk/

public class FindTheStudentThatWillReplaceTheChalk {
    public int chalkReplacer(int[] chalk, int k) {
        long sum = 0;
        for (int n : chalk) {
            sum += n;
        }
        
        k %= sum;
        
        int i = 0;
        while (k >= chalk[i]) {
            k -= chalk[i];
            i = (i + 1) % chalk.length;
        }
        
        return i;
    }    
}
