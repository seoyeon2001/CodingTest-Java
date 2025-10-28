import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        int[] wArr = new int[w];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < w; i++) {
            wArr[i] = Integer.parseInt(st.nextToken());
        }

        int result = 0;

        for(int i = 1; i < w-1; i++) {
            int leftMax = Integer.MIN_VALUE;
            int rightMax = Integer.MIN_VALUE;

            // 왼쪽
            for(int j = 0; j < i; j++) {
                leftMax = Math.max(leftMax, wArr[j]);
            }

            // 오른쪽
            for(int j = i+1; j < w; j++) {
                rightMax = Math.max(rightMax, wArr[j]);
            }

//            System.out.println("leftMax = " + leftMax + " rightMax = " + rightMax);

            int height = Math.min(leftMax, rightMax);

            int water = height - wArr[i];
            if(water > 0) result += water;
        }
        System.out.println(result);

    }
}
