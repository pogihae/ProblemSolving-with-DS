import java.util.Arrays;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int ansCnt = 0;
        
        for(int[] cm : commands){
            int[] tmp = Arrays.copyOfRange(array, cm[0] - 1, cm[1]);
            Arrays.sort(tmp);
            answer[ansCnt++] = tmp[cm[2] - 1];
        }
        
        return answer;
    }
}