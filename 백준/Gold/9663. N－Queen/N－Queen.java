import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int answer;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        answer = 0;

        calc(0, 0, 0, 0);

        System.out.println(answer);
    }

    // 비트 연산
    static void calc(int row, int col, int diag1, int diag2) {
        if(row == n) {
            answer++;
            return;
        }

        // 공격 받는 위치를 1로 표현
        int attackPlace = (col | diag1 | diag2);

        // 놓을 수 있는 자리를 1로 표현
        // ((1 << n) - 1): 11...11 (1 n개)
        int available = ((1 << n) - 1) & ~attackPlace;

        while (available != 0) {
            int bit = available & -available; // 가능한 자리 중 오른쪽부터 뽑음
            available -= bit; // 확인해본 거는 제거

            // 대각선 이동
            /**
             * diag1: 왼쪽 대각선 ↘
             * 아래로 내려가면 공격 위치가 오른쪽으로 한 칸 이동함
             * diag2: 오른쪽 대각선 ↙
             * 아래로 내려가면 공격 위치가 왼쪽으로 한 칸 이동함
             */
            calc(row+1, col | bit, (diag1 | bit) << 1, (diag2 | bit) >> 1);
        }
    }
}