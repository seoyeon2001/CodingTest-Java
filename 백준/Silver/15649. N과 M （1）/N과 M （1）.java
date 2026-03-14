import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        permutation(n, m, 0, new ArrayList<>(), new boolean[n+1]);
        System.out.println(sb);
    }

    static void permutation(int n, int r, int depth, List<Integer> list, boolean[] visited) {
        if(depth == r) {
            for(int num : list) {
                sb.append(num).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = 1; i <= n; i++) {
            if(!visited[i]) {
                visited[i] = true;
                list.add(i);

                permutation(n, r, depth+1, list, visited);

                visited[i] = false;
                list.remove(list.size()-1);
            }


        }
    }
}
