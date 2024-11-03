class Solution {
    public int solution(int hp) {
        int gAnt = hp / 5, mAnt = (hp % 5) / 3, nAnt = hp - gAnt * 5 - mAnt * 3;
        return gAnt + mAnt + nAnt;
    }
}