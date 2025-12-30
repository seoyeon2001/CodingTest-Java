import java.io.*;
import java.util.*;

public class Main {

    static int[] nums;
    static boolean[] visited;
    static List<Integer> answer = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        nums = new int[n+1];
        for(int i = 1; i <= n; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }

        visited = new boolean[n+1];

        for(int i = 1; i <= n; i++) {
            visited[i] = true;
            check(i, i);
            visited[i] = false;
        }

        Collections.sort(answer);

        sb.append(answer.size() + "\n");
        for(int i = 0; i < answer.size(); i++) {
            sb.append(answer.get(i) + "\n");
        }

        System.out.println(sb);
    }

    static void check(int currentNum, int targetNum) {
        int nextNum = nums[currentNum];

        if(!visited[nextNum]) {
            visited[nextNum] = true;
            check(nextNum, targetNum);
            visited[nextNum] = false;
        }

        // 사이클이 시작점으로 돌아온 경우
        if(nextNum == targetNum) answer.add(targetNum);
    }
}
