import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        char[] colors = new char[5];
        int[] numbers = new int[5];
        
        Map<Character, Integer> colorCount = new HashMap<>();
        Map<Integer, Integer> numCount = new HashMap<>();
        
        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            colors[i] = st.nextToken().charAt(0);
            numbers[i] = Integer.parseInt(st.nextToken());
            
            colorCount.put(colors[i], colorCount.getOrDefault(colors[i], 0) + 1);
            numCount.put(numbers[i], numCount.getOrDefault(numbers[i], 0) + 1);
        }
        
        Arrays.sort(numbers);
        boolean sameColor = (colorCount.size() == 1);
        boolean straight = true;
        for (int i = 1; i < 5; i++) {
            if (numbers[i] != numbers[i - 1] + 1) {
                straight = false;
                break;
            }
        }
        
        int maxScore = 0;
        int maxNum = numbers[4]; // 가장 큰 숫자
        
        if (sameColor && straight) {
            maxScore = Math.max(maxScore, maxNum + 900);
        }
        
        for (int num : numCount.keySet()) {
            if (numCount.get(num) == 4) {
                maxScore = Math.max(maxScore, num + 800);
            }
        }
        
        int three = -1, two = -1;
        for (int num : numCount.keySet()) {
            if (numCount.get(num) == 3) three = num;
            else if (numCount.get(num) == 2) two = num;
        }
        if (three != -1 && two != -1) {
            maxScore = Math.max(maxScore, three * 10 + two + 700);
        }
        
        if (sameColor) {
            maxScore = Math.max(maxScore, maxNum + 600);
        }
        
        if (straight) {
            maxScore = Math.max(maxScore, maxNum + 500);
        }
        
        for (int num : numCount.keySet()) {
            if (numCount.get(num) == 3) {
                maxScore = Math.max(maxScore, num + 400);
            }
        }
        
        List<Integer> pairs = new ArrayList<>();
        for (int num : numCount.keySet()) {
            if (numCount.get(num) == 2) {
                pairs.add(num);
            }
        }
        if (pairs.size() == 2) {
            Collections.sort(pairs);
            int big = pairs.get(1), small = pairs.get(0);
            maxScore = Math.max(maxScore, big * 10 + small + 300);
        }
        
        if (pairs.size() == 1) {
            maxScore = Math.max(maxScore, pairs.get(0) + 200);
        }
        
        maxScore = Math.max(maxScore, maxNum + 100);
        
        System.out.println(maxScore);
    }
}