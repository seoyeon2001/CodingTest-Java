import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int[][] map = new int[n][n];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = i;
        }

        for(int i = 0; i < n-1; i++) {
            for(int j = i+1; j < n; j++) {
                if(map[i][j] == 0) continue;

                union(i, j);
            }
        }

        st = new StringTokenizer(br.readLine());
        int num = Integer.parseInt(st.nextToken());
        int parent = find(num-1);
        for(int i = 1; i < m; i++) {
            num = Integer.parseInt(st.nextToken());
            if(parent != find(num-1)) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }

    static int find(int num) {
        if(arr[num] == num) return num;
        return arr[num] = find(arr[num]);
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if(a < b) arr[b] = a;
        else arr[a] = b;
    }
}
