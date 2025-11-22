import java.util.*;
import java.io.*;

class Solution {
    static long max;
    static int time;
    static Set<String> visited;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            time = Integer.parseInt(st.nextToken());

            int[] nums = new int[str.length()];
            for(int i = 0; i < str.length(); i++) {
                nums[i] = str.charAt(i) - '0';
            }

            max = 0;
            visited = new HashSet<>();
            dfs(nums, 0);

            System.out.println("#" + test_case + " " + max);
        }
    }

    static void dfs(int[] nums, int cnt) {
        String key = Arrays.toString(nums) + cnt;
        if(visited.contains(key)) return;
        visited.add(key);

        if(cnt == time) {
            int val = 0;
            for(int n : nums) {
                val = val * 10 + n;
            }
            max = Math.max(max, val);
            return;
        }

        for(int i = 0; i < nums.length - 1; i++) {
            for(int j = i + 1; j < nums.length; j++) {
                // swap
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;

                dfs(nums, cnt + 1);

                // swap 복원
                nums[j] = nums[i];
                nums[i] = tmp;
            }
        }
    }
}
