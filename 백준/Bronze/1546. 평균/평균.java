import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine()); // 1000 이하
        int[] scores = new int[n];

        int scoreSum = 0;
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            scores[i] = num;
            scoreSum += num;
        }
        br.close();

        // 정렬 후 최대 값 찾기
        Arrays.sort(scores);
        int maxScore = scores[n-1];
//        System.out.println("maxScore = " + maxScore);

        // 새로운 점수의 평균
        double answer = scoreSum * 100.0 / n / maxScore;

        System.out.println(answer);
    }
}
