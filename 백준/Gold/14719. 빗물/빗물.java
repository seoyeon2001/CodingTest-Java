import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        int[] height = new int[w];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < w; i++) {
            height[i] = Integer.parseInt(st.nextToken());
        }

        int result = method2(w, height);

        System.out.println(result);
    }
    
    static int method2(int w, int[] height) {
        int result = 0;

        int[] leftMax = new int[w];
        int[] rightMax = new int[w];

        // 왼쪽 최대 높이 계산
        leftMax[0] = 0;
        for (int i = 1; i < w-1; i++) {
            leftMax[i] = Math.max(leftMax[i-1], height[i-1]);
        }

        // 오른쪽 최대 높이 계산
        rightMax[w-1] = 0;
        for (int i = w-2; i > 0; i--) {
            rightMax[i] = Math.max(rightMax[i+1], height[i+1]);
        }

        // 각 위치의 물 높이 계산
        for (int i = 1; i < w-1; i++) {
            int minHeight = Math.min(leftMax[i], rightMax[i]);
            if (minHeight > height[i]) result += minHeight - height[i];
        }

        return result;
    }
}
