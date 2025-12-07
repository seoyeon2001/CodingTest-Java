import java.io.*;
import java.util.*;

public class Main {
    static int[][] map = new int[9][9];
    static int[] rowMask = new int[9];
    static int[] colMask = new int[9];
    static int[][] boxMask = new int[3][3];
    static List<int[]> empties = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                int v = Integer.parseInt(st.nextToken());
                map[i][j] = v;
                if (v == 0) {
                    empties.add(new int[] { i, j });
                } else {
                    int bit = 1 << v;
                    rowMask[i] |= bit;
                    colMask[j] |= bit;
                    boxMask[i / 3][j / 3] |= bit;
                }
            }
        }

        dfs(0);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                sb.append(map[i][j]).append(' ');
            }
            sb.append('\n');
        }
        System.out.print(sb.toString());
    }

    static boolean dfs(int idx) {
        if (idx == empties.size()) {
            return true; // solved
        }

        int[] p = empties.get(idx);
        int r = p[0], c = p[1];
        int used = rowMask[r] | colMask[c] | boxMask[r / 3][c / 3];
        int possible = (~used) & 0x3FE; // bits 1..9

        while (possible != 0) {
            int val = Integer.numberOfTrailingZeros(possible); // value to try
            int bit = 1 << val;
            possible &= ~bit; // remove this candidate

            // place
            map[r][c] = val;
            rowMask[r] |= bit;
            colMask[c] |= bit;
            boxMask[r / 3][c / 3] |= bit;

            if (dfs(idx + 1)) return true;

            // undo
            map[r][c] = 0;
            rowMask[r] &= ~bit;
            colMask[c] &= ~bit;
            boxMask[r / 3][c / 3] &= ~bit;
        }

        return false; // backtrack
    }
}
