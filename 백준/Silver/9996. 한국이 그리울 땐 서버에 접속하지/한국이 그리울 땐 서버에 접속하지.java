import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        String pattern = br.readLine();
        String[] arr = pattern.split("\\*");
        
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            if( input.startsWith(arr[0]) && input.endsWith(arr[1]) && input.length() >= arr[0].length() + arr[1].length() ) System.out.println("DA");
            else System.out.println("NE");
        }
    }
}