public class Main
{
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        boolean isAscending = true;
        boolean isDescending = true;

        for (int i=1; i<=8; i++) {
            if (isAscending == false && isDesceding == false) break;
            int gear = Integer.parseInt(st.nextToken());
            if (gear != i) {
                isAscending = false;
            }
            if (gear != 9 - i) {
                isDescending = false;
            }
        }

        if (isAscending) {
            System.out.println("ascending");
        } else if (isDescending) {
            System.out.println("descending");
        } else {
            System.out.println("mixed");
        }
    }
}
