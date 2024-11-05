class Solution {
    public int solution(String myString, String pat) {
        myString = myString.replace("A", "D").replace("B", "A").replace("D", "B");
        return myString.contains(pat) ? 1 : 0;
    }
}