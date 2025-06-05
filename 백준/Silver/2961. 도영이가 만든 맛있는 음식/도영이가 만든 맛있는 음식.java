import java.io.*;
import java.util.*;

public class Main {
    static List<int[]> flavors;
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st;
        flavors = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken()); // 신맛
            int b = Integer.parseInt(st.nextToken()); // 쓴맛

            flavors.add(new int[]{s, b});
        }

        boolean[] visited = new boolean[n];
        int[] idx = new int[n];
        for (int i = 0; i < n; i++) {
            idx[i] = i;
        }

        // 조합 찾기
        for (int i = 1; i <= n; i++) {
//            System.out.println("\n" + n + " 개 중에서 " + i + " 개 뽑기");
            combination(idx, visited, 0, n, i);
        }

        System.out.println(result);
    }

    // 백트래킹 사용
    static void combination(int[] arr, boolean[] visited, int start, int n, int r) {
        if (r == 0) {
            print(arr, visited, n);
            return;
        }

        for (int i = start; i < n; i++) {
            visited[i] = true;
            combination(arr, visited, i + 1, n, r - 1);
            visited[i] = false;
        }
    }

    // 배열 출력
    static void print(int[] arr, boolean[] visited, int n) {
        List<Integer> idx = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
//                System.out.print(arr[i] + " ");
                idx.add(i);
            }
        }

//        System.out.println(idx);

        int smat = 1;
        int bmat = 0;
        for(int i = 0; i < idx.size(); i++) {
            smat *= flavors.get(idx.get(i))[0];
            bmat += flavors.get(idx.get(i))[1];
        }
        int answer = Math.abs((smat - bmat));
        result = Math.min(result, answer);

//        System.out.println();
    }

}
