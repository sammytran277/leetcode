// https://leetcode.com/problems/number-of-students-unable-to-eat-lunch/

import java.util.*;

public class NumberOfStudentsUnableToEatLunch {
    public int countStudents(int[] students, int[] sandwiches) {
        Deque<Integer> studentChoices = new LinkedList<Integer>();
        int stackPtr = 0;
        for (int student : students) {
            studentChoices.add(student);
        }
        
        int numUnable = 0;
        while (!studentChoices.isEmpty() && numUnable != students.length - stackPtr) {
            if (studentChoices.peekFirst() == sandwiches[stackPtr]) {
                studentChoices.pollFirst();
                stackPtr++;
                numUnable = 0;
            } else {
                studentChoices.addLast(studentChoices.pollFirst());
                numUnable++;
            }
        }
        
        return students.length - stackPtr;
    }
}