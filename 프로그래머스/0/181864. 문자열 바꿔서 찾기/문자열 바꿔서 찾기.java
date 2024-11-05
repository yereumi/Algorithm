class Solution {
    public int solution(String myString, String pat) {
        myString = myString.replace("A", "D");
        myString = myString.replace("B", "A");
        myString = myString.replace("D", "B");
        
        return myString.contains(pat) ? 1 : 0;
    }
}