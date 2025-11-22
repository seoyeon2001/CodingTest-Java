import java.util.*;
import java.io.*;

class Solution {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
        
		for(int test_case = 1; test_case <= 10; test_case++) {
			int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
           
			// System.out.println(Arrays.toString(arr));
            int res = 0;
            for(int i = 2; i < n-2; i++ ) {
                // 양 옆에 크거나 같은 빌딩이 있는 경우 패스
                if(arr[i] <= arr[i-1] || arr[i] <= arr[i+1]) continue;
                
                // 두 칸 떨어져서 크거나 같은 빌딩이 있는 경우 패스
                if(arr[i] <= arr[i-2] || arr[i] <= arr[i+2]) continue;
                
                int height = Math.max(Math.max(arr[i-2], arr[i-1]), Math.max(arr[i+2], arr[i+1]));
                res += (arr[i]-height);
            }

            System.out.println(String.format("#%d %d", test_case, res));
		}
	}
}