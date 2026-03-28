import java.io.*;
import java.util.*;

public class Main {
    static long[] res;
    static List<int[]>[] list;
    static long lcm;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        res = new long[n];
        list = new ArrayList[n];
        for(int i = 0; i < n; i++) {
            list[i] = new ArrayList<>();
        }

        lcm = 1;
        for(int i = 0; i < n-1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());

            list[a].add(new int[] {b, p, q});
            list[b].add(new int[] {a, q, p});

            lcm *= (p * q / gcd(p, q));
        }
//        System.out.println("lcm = " + lcm);

        visited = new boolean[n];
        res[0] = lcm;
        dfs(0);

        long gcd = res[0];
        for(int i = 1; i < n; i++) {
            gcd = gcd(gcd, res[i]);
        }
//        System.out.println("gcd = " + gcd);

        // 출력
        for(int i = 0; i < n; i++) {
            System.out.print(res[i] / gcd + " ");
        }

    }

    static long gcd(long n1, long n2) {
        if(n2 == 0) return n1;
        return gcd(n2, n1 % n2);
    }

    static void dfs(int num) {
        visited[num] = true;

        for(int[] next : list[num]) {
            if(!visited[next[0]]) {
                res[next[0]] = res[num] * next[2] / next[1];
                dfs(next[0]);
            }
        }
    }
}
