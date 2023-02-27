import java.util.*;
import java.io.*;


public class Main
{
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int max = Integer.parseInt(st.nextToken());
        int numOfJewerly = Integer.parseInt(st.nextToken());

        int[][] jewerlies = new int[numOfJewerly][2];

        for (int i=0; i<numOfJewerly; i++) {
            st = new StringTokenizer(br.readLine());
            jewerlies[i][0] = Integer.parseInt(st.nextToken());
            jewerlies[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(jewerlies, (x, y) -> y[1] - x[1]);

        int result = 0;
        for (int i=0; i<numOfJewerly; i++) {
            if (max >= jewerlies[i][0]) {
                result += jewerlies[i][1] * jewerlies[i][0];
                max -= jewerlies[i][0];
            } else {
                result += jewerlies[i][1] * max;
                break;
            }
        }

        System.out.println(result);
    }
}
