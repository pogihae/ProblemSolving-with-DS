import java.util.*;
import java.io.*;


public class Main
{
    private static int min = Integer.MAX_VALUE;

    private static int N;
    private static int M;
    private static int K;

    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int[] rails = new int[N];
        for (int i=0; i<N; i++) {
            rails[i] = Integer.parseInt(st.nextToken());
        }

        simulate(rails, new boolean[N], new ArrayList<Integer>(N));

        System.out.println(min);
    }

    static void simulate(int[] rails, boolean[] used, List<Integer> res) {
        if (res.size() == N) {
            min = Math.min(min, simulateWith(res));
            return;
        }

        for (int i=0; i<N; i++) {
            if (used[i]) continue;

            res.add(rails[i]);
            used[i] = true;

            simulate(rails, used, res);

            res.remove(res.size()-1);
            used[i] = false;
        }
    }

    static int simulateWith(List<Integer> rails) {
        int res = 0;
        int n = 0;

        for (int k=0; k<K; k++) {
            if (res >= min) break;

            int bucket = 0;
            while (bucket <= M) {
                bucket += rails.get(n);
                n = (n + 1) % N;
            }

            if (n == 0) {
                n = N - 1;
            } else {
                n -= 1;
            }

            bucket -= rails.get(n);
            res += bucket;
        }

        return res;
    }
}
