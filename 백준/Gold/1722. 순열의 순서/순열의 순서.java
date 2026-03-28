import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        long[] factorial = new long[n+1];
        factorial[0] = 1;
        for(int i = 1; i <= n; i++) {
            factorial[i] = i * factorial[i-1];
        }

        List<Integer> numbers = new ArrayList<>();
        for(int i = 1; i <= n; i++) {
            numbers.add(i);
        }

        st = new StringTokenizer(br.readLine());
        int q = Integer.parseInt(st.nextToken());
        if(q == 1) {
            long k = Long.parseLong(st.nextToken()) - 1;

            for(int i = n; i >= 1; i--) {
                int index = (int) (k / factorial[i-1]);

                System.out.print(numbers.get(index) + " ");

                numbers.remove(index);
                k %= factorial[i-1];
            }
        } else {
            int[] perm = new int[n];
            for(int i = 0; i < n; i++) {
                perm[i] = Integer.parseInt(st.nextToken());
            }

            long order = 1;
            for(int i = 0; i < n; i++){
                int index = numbers.indexOf(perm[i]);

                order += index * factorial[n-i-1];
                numbers.remove(index);
            }

            System.out.println(order);
        }
    }
}
