import java.io.*;
import java.util.*;

public class Main {
    static int answer;
    static int n;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n];

        answer = 0;
        for(int c = 0; c < n; c++) { // 0행 c열

            arr[0] = c;
            calc(0, c, 1); // 시작점
        }

        System.out.println(answer);
    }

    static void calc(int r, int c, int cnt) {
        if(cnt == n) {
            answer++;
            return;
        }

        for(int i = 0; i < n; i++) {
            if(!isAttack(r+1, i)) { // (r+1행, i열)에 두어도 공격당하지 않는다면
                arr[r+1] = i;
                calc(r+1, i, cnt+1);
            }
        }
    }

    static boolean isAttack(int r, int c) {
        for(int i = 0; i < r; i++) { // 행
            // 열 체크
            if(arr[i] == c) return true;

            // 대각선 체크
            if(r-i == Math.abs(c - arr[i])) return true;
        }
        return false;
    }

}
