import java.util.*;
import java.io.*;


public class Main
{
    private static final int A = 0;
    private static final int B = 1;

    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] workTimes = new int[2][N+1];
        int[][] moveTimes = new int[2][N+1];
        for (int i=1; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            workTimes[A][i] = Integer.parseInt(st.nextToken());
            workTimes[B][i] = Integer.parseInt(st.nextToken());
            moveTimes[B][i+1] = Integer.parseInt(st.nextToken());
            moveTimes[A][i+1] = Integer.parseInt(st.nextToken());
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        workTimes[A][N] = Integer.parseInt(st.nextToken());
        workTimes[B][N] = Integer.parseInt(st.nextToken());

        int[][] dp = new int[2][N+1];
        for (int i=1; i<=N; i++) {
            dp[A][i] = Math.min(dp[A][i-1] + workTimes[A][i], dp[B][i-1] + workTimes[A][i] + moveTimes[A][i]);
            dp[B][i] = Math.min(dp[B][i-1] + workTimes[B][i], dp[A][i-1] + workTimes[B][i] + moveTimes[B][i]);
        }

        System.out.println(Math.min(dp[A][N], dp[B][N]));
    }
}
