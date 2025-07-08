import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static List<List<Integer>> answer;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        answer = new ArrayList<>();
        backtracking(new ArrayList<>(), 1);

//        for (List<Integer> list : answer) {
//            for (int i : list) {
//                System.out.print(i + " ");
//            }
//            System.out.println();
//        }
        System.out.print(sb);
    }

    static void backtracking(List<Integer> cur, int start) {

        if (cur.size() == m) {
            for (int num : cur) {
                sb.append(num).append(" ");
            }
            sb.append("\n");
//            answer.add(new ArrayList<>(cur));
//            System.out.println(answer);
            return;
        }

        for (int i = start; i <= n; i++) {
            cur.add(i);
            backtracking(cur, i + 1);
            cur.remove(cur.size() - 1);
        }
    }
}
