import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        char[] arr = br.readLine().toCharArray();
        boolean[] eaten = new boolean[n];

        int answer = 0;

        for(int i = 0; i < n; i++) {
            if(arr[i] == 'P') {

                int left = Math.max(0, i - k);
                int right = Math.min(n - 1, i + k);

                for(int j = left; j <= right; j++) {
                    if(arr[j] == 'H' && !eaten[j]) {
                        eaten[j] = true;
                        answer++;
                        break;
                    }
                }

            }
        }

        System.out.println(answer);
    }
}