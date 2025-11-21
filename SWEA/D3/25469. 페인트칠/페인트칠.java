import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int H = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());

            boolean[] fullRow = new boolean[H];
            boolean[] fullCol = new boolean[W];
            Arrays.fill(fullRow, true);
            Arrays.fill(fullCol, true);

            for (int i = 0; i < H; i++) {
                String line = br.readLine();
                for (int j = 0; j < W; j++) {
                    if (line.charAt(j) == '.') {
                        fullRow[i] = false;
                        fullCol[j] = false;
                    }
                }
            }

            int rowCount = 0, colCount = 0;
            for (boolean b : fullRow) if (b) rowCount++;
            for (boolean b : fullCol) if (b) colCount++;

            // 모든 행과 열이 모두 #이면 마지막 연산 겹침
            int result = (Math.min(H, W) == Math.min(rowCount, colCount)) ? Math.min(rowCount, colCount) : rowCount + colCount;

            System.out.println(result);
        }

        br.close();
    }
}
