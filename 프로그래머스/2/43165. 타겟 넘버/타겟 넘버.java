import java.util.*;

class Solution {
    
    static int size;
    static int cnt;
    
    public static int calculate(int[] numbers, char[] operator) {
        int result = 0;
        for (int i = 0; i < size; i++) {
            if (operator[i] == '+') {
                result += numbers[i];
            } else if (operator[i] == '-') {
                result += numbers[i] * (-1);
            }
        }
        return result;
    }
    
    public static void backtracking(int depth, int[] numbers, char[] operator, int target) {
        if (depth == size) {
            if (calculate(numbers, operator) == target) cnt++;
            return;   
        }
        
        for (int i = 0; i < 2; i++) {
            if (i == 0) {
                operator[depth] = '+';
                backtracking(depth + 1, numbers, operator, target);
            } else {
                operator[depth] = '-';
                backtracking(depth + 1, numbers, operator, target);
            }
        }
    }
    
    public static int solution(int[] numbers, int target) {
        size = numbers.length;
        char[] operator = new char[size];
        backtracking(0, numbers, operator, target);
        return cnt;
    }
}