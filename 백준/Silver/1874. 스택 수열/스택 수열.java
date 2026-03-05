import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder("");

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Stack<Integer> stack = new Stack<>();
        int curIdx = 0;
        int number = 1;
        while(curIdx < n) {
            while(arr[curIdx] >= number) {
                stack.push(number);
                sb.append("+").append("\n");
                number++;
            }

            while(!stack.isEmpty()) {
                if(stack.peek() == arr[curIdx]) {
                    int num = stack.pop();
                    sb.append("-").append("\n");
                    curIdx++;
                } else if(stack.peek() > arr[curIdx]) {
                    System.out.println("NO");
                    return;
                } else if(stack.peek() < arr[curIdx]) {
                    break;
                }
            }
        }

        System.out.println(sb);
    }
}
