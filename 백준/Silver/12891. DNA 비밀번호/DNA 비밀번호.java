import java.io.*;
import java.util.*;

public class Main {
    static final int A = 0;
    static final int C = 1;
    static final int G = 2;
    static final int T = 3;
    
    static int[] cnt;
    static int[] counting;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int s = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        char[] arr = br.readLine().toCharArray();

        cnt = new int[4];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 4; i++) {
            cnt[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;

        counting = new int[4];
        for(int i = 0; i < p; i++) {
            counting[toIndex(arr[i])]++;
        }
        // System.out.println(Arrays.toString(counting));

        if(canMake()) answer++;

        int frontIdx = 0;
        int endIdx = p;
        while(endIdx != s) {
            counting[toIndex(arr[frontIdx])]--;
            counting[toIndex(arr[endIdx])]++;

            if(canMake()) answer++;

            frontIdx++;
            endIdx++;
        }

        System.out.println(answer);
    }

    static int toIndex(char c) {
        if (c == 'A') return A;
        else if (c == 'C') return C;
        else if (c == 'G') return G;
        else return T;
    }

    static boolean canMake() {
        for(int i = 0; i < 4; i++) {
            if(cnt[i] > counting[i]) return false;
        }
        return true;
    }
}
