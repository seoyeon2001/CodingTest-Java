import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        while(t-- > 0) {
            char[] arr = br.readLine().toCharArray();
            int k = Integer.parseInt(br.readLine());

            List<Integer>[] pos = new ArrayList[26];
            for (int i = 0; i < 26; i++) {
                pos[i] = new ArrayList<>();
            }

            int minLen = Integer.MAX_VALUE;
            int maxLen = Integer.MIN_VALUE;

            for (int i = 0; i < arr.length; i++) {
                int idx = arr[i] - 'a';
                pos[idx].add(i);

                int size = pos[idx].size();
                if (size >= k) {
                    int len = pos[idx].get(size - 1) - pos[idx].get(size - k) + 1;
                    minLen = Math.min(minLen, len);
                    maxLen = Math.max(maxLen, len);
                }
            }

            if (minLen == Integer.MAX_VALUE) {
                sb.append(-1).append('\n');
            } else {
                sb.append(minLen).append(' ').append(maxLen).append('\n');
            }
        }
        System.out.println(sb);
    }
}