import java.io.*;

public class Main {
    static int n;
    static int[] arr;
    static int[] temp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());

        // 방법 1 - 내장 함수 사용
        /*
        arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        // 출력
        for(int i = 0; i < n; i++) {
            sb.append(arr[i]).append("\n");
        }
         */

        // 방법 2 - 계수 정렬
        /*
        int[] cnt = new int[2000001];
        for(int i = 0; i < n; i++) {
            cnt[Integer.parseInt(br.readLine()) + 1000000]++;
        }

        for(int i = 0; i < cnt.length; i++) {
            if(cnt[i] != 0) {
                sb.append(String.valueOf(i - 1000000).repeat(cnt[i])).append('\n');
            }
        }
        System.out.println(sb);
         */

        // 방법 3 - 병합 정렬
        arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        temp = new int[n];
        mergeSort(0, n-1);

        // 출력
        for(int i = 0; i < n; i++) {
            sb.append(arr[i]).append("\n");
        }
        System.out.println(sb);
    }

    static void mergeSort(int left, int right) {
        if(left >= right) return;

        int mid = (left + right) / 2;

        mergeSort(left, mid);
        mergeSort(mid+1, right);

        for(int i = left; i <= right; i++) {
            temp[i] = arr[i];
        }

        int k = left;
        int idx1 = left;
        int idx2 = mid+1;

        // 병합
        while(idx1 <= mid && idx2 <= right) {
            if(temp[idx1] > temp[idx2]) {
                arr[k] = temp[idx2];
                k++;
                idx2++;
            } else {
                arr[k] = temp[idx1];
                k++;
                idx1++;
            }
        }

        while (idx1 <= mid) {
            arr[k] = temp[idx1];
            k++;
            idx1++;
        }

        while(idx2 <= right) {
            arr[k] = temp[idx2];
            k++;
            idx2++;
        }
    }
}
