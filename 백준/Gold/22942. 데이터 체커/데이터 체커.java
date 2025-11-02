import java.io.*;
import java.util.*;

public class Main {
    static class Point {
        int x;
        boolean isStart;
        int idx;
        public Point(int x, boolean isStart, int idx) {
            this.x = x;
            this.isStart = isStart;
            this.idx = idx;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];

        List<Point> list = new ArrayList<>();
        
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            arr[i][0] = x - r;
            arr[i][1] = x + r;

            list.add(new Point(arr[i][0], true, i));  // 시작점
            list.add(new Point(arr[i][1], false, i)); // 끝점
        }

        // x좌표 기준 정렬, 같을 경우 끝점이 시작점보다 먼저 오게
        list.sort((a, b) -> {
            if (a.x == b.x) return Boolean.compare(a.isStart, b.isStart);
            return a.x - b.x;
        });

        Stack<Integer> stack = new Stack<>();

        for (Point p : list) {
            if (p.isStart) { // 시작이면 스택에 넣어
                stack.push(p.idx);
            } else {
                if (stack.isEmpty() || stack.peek() != p.idx) {
                    System.out.println("NO");
                    return;
                }
                stack.pop();
            }
        }

        System.out.println("YES");
    }
}
