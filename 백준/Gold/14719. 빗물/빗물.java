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
        for (int i = 0; i < w; i++) {
            height[i] = Integer.parseInt(st.nextToken());
        }

        int[] leftMax = new int[w];
        int[] rightMax = new int[w];

        // 왼쪽에서의 최대 높이 계산
        leftMax[0] = height[0];
        for (int i = 1; i < w; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }

        // 오른쪽에서의 최대 높이 계산
        rightMax[w - 1] = height[w - 1];
        for (int i = w - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }

        int result = 0;

        // 각 위치의 물 높이 계산
        for (int i = 1; i < w - 1; i++) {
            int minHeight = Math.min(leftMax[i], rightMax[i]);
            if (minHeight > height[i]) {
                result += minHeight - height[i];
            }
        }

        System.out.println(result);
    }
}
