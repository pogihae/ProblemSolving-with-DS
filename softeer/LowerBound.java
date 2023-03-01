import java.util.*;
import java.io.*;


public class Main
{
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] guides = new int[N][2];
        int prevHeight = 0;
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            guides[i][0] = Integer.parseInt(st.nextToken()) + prevHeight;
            guides[i][1] = Integer.parseInt(st.nextToken());
            prevHeight = guides[i][0];
        }

        int[][] tests = new int[M][2];
        prevHeight = 0;
        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            tests[i][0] = Integer.parseInt(st.nextToken()) + prevHeight;
            tests[i][1] = Integer.parseInt(st.nextToken());
            prevHeight = tests[i][0];
        }

        int max = 0;

        int startGuideIdx = 0;
        for (int i=0; i<M; i++) {
            int[] test = tests[i];
            int endGuideIdx = lowerBound(guides, test[0]);

            int tmpIdx = startGuideIdx;
            while (tmpIdx < N && tmpIdx <= endGuideIdx) {
                max = Math.max(max, test[1] - guides[tmpIdx][1]);
                tmpIdx += 1;
            }
            startGuideIdx = endGuideIdx;
            if (guides[startGuideIdx][0] == test[0]) startGuideIdx += 1;
        }

        System.out.println(max);
    }

    private static int lowerBound(int[][] guides, int target) {
        int low = 0;
        int high = guides.length - 1;

        while (low < high) {
            int mid = (low + high) / 2;
            if (guides[mid][0] < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return high;
    }
}
