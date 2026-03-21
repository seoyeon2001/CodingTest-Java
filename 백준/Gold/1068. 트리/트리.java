import java.io.*;
import java.util.*;

public class Main {

    static List<Integer>[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        list = new ArrayList[n];
        for(int i = 0; i < n; i++) {
            list[i] = new ArrayList<>();
        }

        int[] parent = new int[n];
        int rootNode = -1;

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            parent[i] = Integer.parseInt(st.nextToken());

            if(parent[i] == -1) {
                rootNode = i;
            } else {
                list[parent[i]].add(i);
            }
        }

        int removeNode = Integer.parseInt(br.readLine());
        if(removeNode == rootNode) {
            System.out.println(0);
            return;
        }

        int p = parent[removeNode];
        list[p].remove(Integer.valueOf(removeNode));
        
        int answer = dfs(rootNode);
        System.out.println(answer);
    }

    static int dfs(int node) {
        if(list[node].isEmpty()) return 1;

        int cnt = 0;
        for(int next : list[node]) {
            cnt += dfs(next);
        }
        
        return cnt;
    }
}
