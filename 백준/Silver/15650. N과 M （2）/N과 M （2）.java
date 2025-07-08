import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<List<Integer>> answer = new ArrayList<>();
        backtracking(n, m, answer, new ArrayList<>(), 1);

        for(List<Integer> list : answer) {
            for(int i : list) {
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }

    static void backtracking(int n, int m, List<List<Integer>> answer, List<Integer> cur, int start) {

        if (cur.size() == m) {
            answer.add(new ArrayList<>(cur));
//            System.out.println(answer);
            return;
        }

        for (int i = start; i <= n; i++) {
            cur.add(i);
            backtracking(n, m, answer, cur, i + 1);
            cur.remove(cur.size()-1);
        }
    }
}
