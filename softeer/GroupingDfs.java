import java.util.*;
import java.io.*;

public class Main
{
    private static final char VISITED = 'v';

    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        char[][] map = new char[N][N];

        for (int r=0; r<N; r++) {
            String row = br.readLine();
            for (int c=0; c<N; c++) {
                map[r][c] = row.charAt(c);
            }
        }

        List<Integer> blockSizes = new ArrayList<>();

        for (int r=0; r<N; r++) {
            for (int c=0; c<N; c++) {
                if (map[r][c] == VISITED || map[r][c] == '0') continue;
                blockSizes.add(dfs(map, r, c, 0));
            }
        }

        blockSizes.sort(null);
        int numOfBlocks = blockSizes.size();

        StringBuilder sb = new StringBuilder();
        sb.append(numOfBlocks).append("\n");
        for (int i=0; i<blockSizes.size(); i++) {
            sb.append(blockSizes.get(i)).append("\n");
        }
        
        System.out.println(sb.toString());
    }

    static int dfs(char[][] map, int r, int c, int size) {
        int N = map.length;
        if (r >= N || r < 0 || c >= N || c < 0) return size;
        if (map[r][c] == VISITED || map[r][c] == '0') return size;

        map[r][c] = VISITED;

        int mSize = size;
        
        mSize += dfs(map, r+1, c, size);
        mSize += dfs(map, r-1, c, size);
        mSize += dfs(map, r, c+1, size);
        mSize += dfs(map, r, c-1, size);

        return mSize + 1;
    }
}
