import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        String t = br.readLine();

        Map<Character, List<Integer>> map = new HashMap<>();

        // t 저장
        for (int i = 0; i < t.length(); i++) {
            Character word = t.charAt(i);

            map.putIfAbsent(word, new ArrayList<>());
            map.get(word).add(i);
        }

        int result = 1;
        int curIdx = -1;
        for(int i = 0; i < s.length(); i++) {
            Character target = s.charAt(i);

            if (!map.containsKey(target)) {
                System.out.println(-1);
                return;
            }

            List<Integer> targetIdx = map.get(target);

            // 이분 탐색으로 curIdx 업데이트
            int left = 0;
            int right = targetIdx.size();
            while(left < right) {
                int mid = (left + right) / 2;
                if(targetIdx.get(mid) > curIdx) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }

            int pos = left;

            if (pos == targetIdx.size()) {
                result++;
                curIdx = targetIdx.get(0);
            } else {
                curIdx = targetIdx.get(pos);
            }
        }

        System.out.println(result);
    }
}
