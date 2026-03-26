import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long min = Long.parseLong(st.nextToken());
        long max = Long.parseLong(st.nextToken());

        boolean[] nums = new boolean[(int) (max - min + 1)];

        for(long i = 2; i <= Math.sqrt(max); i++) {
            long num = i * i;

            for(long j = min / num; j <= max / num ; j++) {
                if(num*j-min < 0) continue;
                nums[(int)(num*j-min)] = true;
            }
        }

        long answer = 0;
        for(int i = 0; i < max - min + 1; i++) {
            if(!nums[i]) answer++;
        }

        System.out.println(answer);
    }
}
