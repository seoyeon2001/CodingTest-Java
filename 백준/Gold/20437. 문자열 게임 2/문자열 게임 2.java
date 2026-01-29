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

            Map<Character, List<Integer>> map = new HashMap<>();

            List<Integer> answer = new ArrayList<>();
            for(int i = 0; i < arr.length; i++) {
                map.putIfAbsent(arr[i], new ArrayList<>());
                map.get(arr[i]).add(i);

                if(map.get(arr[i]).size() >= k) {
                    int size = map.get(arr[i]).size();
                    List<Integer> idx = map.get(arr[i]);
                    answer.add(idx.get(size-1) - idx.get(size-k) + 1);
                }
            }
            Collections.sort(answer);
//            System.out.println("answer = " + answer);

            if(answer.size() >= 1) {
                sb.append(String.format("%d %d\n", answer.get(0), answer.get(answer.size()-1)));
            } else {
                sb.append(-1).append("\n");
            }
        }
        System.out.println(sb);
    }
}

