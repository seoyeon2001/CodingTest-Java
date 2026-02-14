import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] arr = br.readLine().split("");
        br.close();

        int answer = 0;
        for(int i = 0; i < n; i++) {
            answer += Integer.parseInt(arr[i]);
        }
        System.out.println(answer);

    }
}
