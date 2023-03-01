import java.util.*;
import java.io.*;

public class Main
{
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long K = Long.parseLong(st.nextToken());
        long P = Long.parseLong(st.nextToken());
        long N = Long.parseLong(st.nextToken());

        long res = K;
        while (N != 0) {
            if ((N & 1) != 0) res = (res * P) % 1000000007;
            P = (P * P) % 1000000007;
            N >>= 1;
        }

        System.out.println(res);
    }
}
