import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int[] aArr = new int[2*a]; int[] bArr = new int[2*b];

        for(int i = 0; i < a; i++) aArr[i] = Integer.parseInt(br.readLine());
        for(int i = 0; i < b; i++) bArr[i] = Integer.parseInt(br.readLine());

        for(int i = 0; i < a; i++) aArr[a+i] = aArr[i];
        for(int i = 0; i < b; i++) bArr[b+i] = bArr[i];

        int[] aSum = new int[n+1];
        aSum[0] = 1;

        int aTotal = 0;
        for(int i = 0; i < a; i++) aTotal += aArr[i];
        if(aTotal <= n) aSum[aTotal]++;

        for(int i = 0; i < a; i++) {
            int sum = 0;
            // 길이 1 ~ a-1 까지만
            for(int len = 1; len < a; len++) {
                sum += aArr[i + len - 1];
                if(sum <= n) aSum[sum]++;
                else break;
            }
        }

        int[] bSum = new int[n+1];
        bSum[0] = 1;

        int bTotal = 0;
        for(int i = 0; i < b; i++) bTotal += bArr[i];
        if(bTotal <= n) bSum[bTotal]++;

        for(int i = 0; i < b; i++) {
            int sum = 0;
            // 길이 1 ~ b-1 까지만
            for(int len = 1; len < b; len++) {
                sum += bArr[i + len - 1];
                if(sum <= n) bSum[sum]++;
                else break;
            }
        }

//        System.out.println("aSum = " + Arrays.toString(aSum));
//        System.out.println("bSum = " + Arrays.toString(bSum));

        int res = 0;
        for(int i = 0; i <= n; i++) {
            res += aSum[i] * bSum[n-i];
//            System.out.printf("a = %d b = %d res = %d\n", i, n-i, res);
        }
        System.out.println(res);

    }
}
