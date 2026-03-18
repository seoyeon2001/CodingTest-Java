import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr); // 1 2 3 4 5

        int m = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++) {
            int target = Integer.parseInt(st.nextToken());
            boolean find = false;

            int left = 0, right = n-1;

            while(left <= right) {
                int mid = (left + right) / 2;

                if(arr[mid] < target) {
                    left = mid+1;
                } else if(arr[mid] > target) {
                    right = mid-1;
                } else {
                    find = true;
                    break;
                }
            }

            System.out.println(find ? 1 : 0);
        }
    }
}
