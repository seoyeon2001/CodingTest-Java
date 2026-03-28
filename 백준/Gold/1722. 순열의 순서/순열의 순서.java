import java.io.*;
import java.util.*;

public class Main {
    static long[] factorial;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        factorial = new long[n+1];
        factorial[0] = 1;
        for(int i = 1; i <= n; i++) {
            factorial[i] = i * factorial[i-1];
        }

        boolean[] isUsed = new boolean[n+1];
        int[] answer = new int[n+1];

        st = new StringTokenizer(br.readLine());
        int q = Integer.parseInt(st.nextToken());
        if(q == 1) {
            long k = Long.parseLong(st.nextToken());
            for(int i = 1; i <= n; i++) { // 자리에 숫자 채우기
                for(int j = 1, cnt = 1; j <= n; j++) {
                    if(isUsed[j]) continue;

                    if(k <= cnt * factorial[n-i]) {
                        k -= ((cnt-1) * factorial[n-i]);
                        answer[i] = j;
                        isUsed[j] = true;
                        break;
                    }
                    cnt++;
                }
            }
            for(int i = 1; i <= n; i++) {
                System.out.print(answer[i] + " ");
            }
        } else {
            long k = 1;
            for(int i = 1; i <= n; i++) {
                answer[i] = Integer.parseInt(st.nextToken());

                long cnt = 0;
                for(int j = 1; j < answer[i]; j++) {
                    if(!isUsed[j]) cnt++;
                }
                k += cnt * factorial[n-i];
                isUsed[answer[i]] = true;
            }
            System.out.println(k);
        }


    }
}
