import java.io.*;
import java.util.*;

public class Main {
    static final int A = 0;
    static final int C = 1;
    static final int G = 2;
    static final int T = 3;
    
    static int[] cnt = new int[4];
    static int[] counting = new int[4];
    static int satisfied = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int s = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        char[] arr = br.readLine().toCharArray();

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 4; i++) {
            cnt[i] = Integer.parseInt(st.nextToken());
            if (cnt[i] == 0) satisfied++; // 0이면 이미 만족
        }

        int answer = 0;

        for(int i = 0; i < p; i++) {
            add(arr[i]);
        }

        if (satisfied == 4) answer++;

        int frontIdx = 0;
        int endIdx = p;
        while(endIdx != s) {
            remove(arr[frontIdx]);
            add(arr[endIdx]);

            if (satisfied == 4) answer++;

            frontIdx++;
            endIdx++;
        }

        System.out.println(answer);
    }

    static void add(char c) {
        int idx = toIndex(c);
        counting[idx]++;
        if (counting[idx] == cnt[idx]) {
            satisfied++;
        }
    }

    static void remove(char c) {
        int idx = toIndex(c);
        if (counting[idx] == cnt[idx]) {
            satisfied--;
        }
        counting[idx]--;
    }

    static int toIndex(char c) {
        if (c == 'A') return A;
        else if (c == 'C') return C;
        else if (c == 'G') return G;
        else return T;
    }
}
