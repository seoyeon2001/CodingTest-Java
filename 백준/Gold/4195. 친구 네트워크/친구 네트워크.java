import java.io.*;
import java.util.*;

public class Main {
    static HashMap<String, Integer> map = new HashMap<>();
    static int[] parents;
    static int[] dp;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        for(int i = 0; i < t; i++) { // 테스트

            // 시작
            int n = Integer.parseInt(br.readLine());
            parents = new int[2*n];
            for(int j = 0; j < 2*n; j++) {
                parents[j] = j;
            }

            dp = new int[2*n];
            Arrays.fill(dp, 1);
            
            int num = 0;
            for(int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());

                String first = st.nextToken();
                String second = st.nextToken();

                if(!map.containsKey(first)) {
                    map.put(first, num++);
                }

                if(!map.containsKey(second)) {
                    map.put(second, num++);
                }

                int result = union(map.get(first), map.get(second));
                sb.append(result).append("\n");
            }
            // 끝
        }
        System.out.println(sb);

    }

    static int find(int x) {
        if(x == parents[x]) return x;
        else return find(parents[x]);
    }

    static int union(int x, int y) {
        x = find(x);
        y = find(y);

        if(x == y) return dp[x];
        else {
            parents[y] = x;
            dp[x] += dp[y];
            return dp[x];
        }
    }
}
