import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        int left = 1;
        int right = k;

        int answer = 0;
        while(left <= right) {
            int mid = (left + right) / 2;

            int cnt = 0;
            // mid 이하 값의 개수 구하기
            for(int i = 1; i <= n; i++) {
                cnt += Math.min(n, mid / i);
            }

//            System.out.println(mid + "이하의 값의 개수는 = " + cnt);

            if(cnt >= k) {
                right = mid - 1;
                answer = mid;
            } else {
                left = mid + 1;
            }
        }
        System.out.println(answer);
    }
}
