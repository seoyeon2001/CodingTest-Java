import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int s = 0, e = arr.length-1;

        int sum = 0;
        int result = 0;
        while(s < e) {
            sum = arr[s] + arr[e];

            if(sum < m) s++;
            else if (sum > m) e--;
            else if(sum == m) {
                s++;
                e--;
                result++;
            }
        }

        System.out.println(result);

    }
}
