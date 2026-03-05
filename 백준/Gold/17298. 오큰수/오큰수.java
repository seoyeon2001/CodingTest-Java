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

        Stack<Integer> stack = new Stack<>();

        stack.push(0);
        for(int i = 1; i < n; i++) {
            while(!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                nges[stack.pop()] = arr[i];
            }
            stack.push(i);
        }

        while(!stack.isEmpty()) {
            nges[stack.pop()] = -1;
        }

        for(int nge : nges) {
            sb.append(nge).append(" ");
        }
        System.out.println(sb);
    }
}
