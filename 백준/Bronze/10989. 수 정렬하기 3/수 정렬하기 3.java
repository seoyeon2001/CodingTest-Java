import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        // 방법 1 - 내장 함수 사용
//        Arrays.sort(arr);

        // 방법 2 - 기수 정렬
        radixSort(arr, 5);

        // 출력
        for(int i = 0; i < n; i++) {
            sb.append(arr[i]).append("\n");
        }
        System.out.println(sb);

        /*
        // 방법 3 - 카운팅
        int[] cnt = new int[10001];
        for(int i = 0; i < n; i++) {
            cnt[Integer.parseInt(br.readLine())]++;
        }

        // 출력
        for(int i = 1; i < 10001; i++) {
            if(cnt[i] != 0) {
                while(cnt[i] > 0) {
                    sb.append(i).append("\n");
                    cnt[i]--;
                }
            }
        }
        System.out.println(sb);
         */
    }

    static void radixSort(int[] arr, int maxSize) {
        int[] output = new int[n];
        int digit = 1;

        for(int t = 0; t < maxSize; t++) {
            int[] bucket = new int[10];

            // 해당 자리값에 몇 개의 데이터가 있는지 저장
            for(int i = 0; i < n; i++) {
                bucket[(arr[i] / digit) % 10]++;
            }

            // 해당 자리값이 0 ~ i까지 몇 개의 데이터가 있는지 저장 - 누적합
            for(int i = 1; i < 10; i++) {
                bucket[i] += bucket[i-1];
            }

            // 정렬
            for(int i = n-1; i >= 0; i--) {
                output[bucket[(arr[i] / digit) % 10]-1] = arr[i];
                bucket[(arr[i] / digit) % 10]--;
            }

            // 복사
            for(int i = 0; i < n; i++) {
                arr[i] = output[i];
            }

            digit *= 10;
        }
    }
}
