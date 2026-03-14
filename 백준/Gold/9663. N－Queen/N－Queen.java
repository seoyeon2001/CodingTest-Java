import java.io.*;
import java.util.*;

public class Main {
    static int answer;
    static int n;

    static boolean[] col; // 같은 열
    static boolean[] diag1; // ↙ 대각선 (r + c)
    static boolean[] diag2; // ↘ 대각선 (r - c + n)

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        col = new boolean[n];
        diag1 = new boolean[2 * n];
        diag2 = new boolean[2 * n];

        answer = 0;

        // 0행 시작
        calc(0);
        
        System.out.println(answer);
    }

    static void calc(int r) {
        if(r == n) {
            answer++;
            return;
        }

        for(int i = 0; i < n; i++) {
            if(!isAttack(r, i)) { // (r행, i열)에 두어도 공격당하지 않는다면
                col[i] = true;
                diag1[r + i] = true;
                diag2[r - i + n] = true;

                calc(r+1);

                col[i] = false;
                diag1[r + i] = false;
                diag2[r - i + n] = false;

            }
        }
    }

    static boolean isAttack(int r, int c) {
        // 열 체크
        if(col[c]) return true;

        // 대각선 체크
        if(diag1[r + c] || diag2[r - c + n]) return true;
        
        return false;
    }

}
