import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        bubble();
        
        for(int i = 0; i < n; i++) {
            System.out.println(arr[i]);
        }

    }

    // 버블 정렬
    static void bubble() {
        for(int end = n-1; end >= 1; end--) {
            for(int i = 0; i < end; i++) {
                if(arr[i] > arr[i+1]) {
                    int temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                }
            }
        }

    }
}
