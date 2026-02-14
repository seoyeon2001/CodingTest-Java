import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine()); // 1000 이하
        int[] scores = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            scores[i] = Integer.parseInt(st.nextToken());
        }
        br.close();

        // 정렬 후 최대 값 찾기
        Arrays.sort(scores);
        int maxScore = scores[n-1];
//        System.out.println("maxScore = " + maxScore);

        // 새로운 점수의 합
        double newScoreSum = 0;
        for(int i = 0; i < n; i++) {
            double newScore = scores[i] * 100.0 / maxScore;
//            System.out.println("newScore = " + newScore);
            newScoreSum += newScore;
        }
//        System.out.println("newScoreSum = " + newScoreSum);

        // 새로운 점수의 평균
        double answer = newScoreSum / n;

        System.out.println(answer);
    }
}
