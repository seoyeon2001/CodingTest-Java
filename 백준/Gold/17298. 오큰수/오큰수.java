import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] nges = new int[n];

        Stack<int[]> stack = new Stack<>();

        nges[n-1] = -1;
        stack.push(new int[] {n-1, arr[n-1]});

        for(int i = n-2; i >= 0; i--) {
            int[] now = new int[] {i, arr[i]};

            while(!stack.isEmpty() && stack.peek()[1] <= now[1]) {
                stack.pop();
            }

            nges[i] = stack.isEmpty() ? -1 : stack.peek()[1];

            stack.push(now);
        }

        for(int nge : nges) {
            sb.append(nge).append(" ");
        }
        System.out.println(sb);
    }
}
