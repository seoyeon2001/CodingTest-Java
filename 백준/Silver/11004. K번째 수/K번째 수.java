import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;
    static int k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // quick sorting
        quickSortV2(0, n-1);

        System.out.println(arr[k-1]);
    }

    static void quickSortV2(int left, int right) {
        if(left < right) {
            int pivotIdx = partition(left, right);

            if(pivotIdx == k-1) return;
            else if(k-1 < pivotIdx) {
                quickSortV2(left, pivotIdx-1);
            } else {
                quickSortV2(pivotIdx+1, right);
            }
        }
    }

    static int partition(int left, int right) {
        // 데이터가 2개인 경우 바로 비교
        if(left+1 == right) {
            if(arr[left] > arr[right]) swap(left, right);
            return right;
        }

        int mid = (left + right) / 2;
        swap(left, mid);
        int pivot = arr[left];
        int i = left+1, j = right;
        while(i <= j) {
            while(i <= right && arr[i] < pivot) i++;
            while(j >= left + 1 && arr[j] > pivot) j--;

            if(i <= j) {
                swap(i, j);
                i++;
                j--;
            }
        }

        arr[left] = arr[j];
        arr[j] = pivot;

        return j;
    }

    static void swap(int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
