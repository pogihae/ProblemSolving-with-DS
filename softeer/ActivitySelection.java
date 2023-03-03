public class Main
{
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] lectures = new int[N][2];
        for (int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            lectures[i][0] = Integer.parseInt(st.nextToken());
            lectures[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(lectures, (x, y) -> x[1] - y[1]);

        int result = 0;
        int lastEndTime = 0;
        for (int i=0; i<N; i++) {
            if (lectures[i][0] >= lastEndTime) {
                result += 1;
                lastEndTime = lectures[i][1];
            }
        }

        System.out.println(result);
    }
}
