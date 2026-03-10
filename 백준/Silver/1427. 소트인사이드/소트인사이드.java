import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        char[] charArray = br.readLine().toCharArray();
        Integer[] intArray = new Integer[charArray.length];
        for(int i = 0; i < intArray.length; i++) {
            intArray[i] = charArray[i] - '0';
        }
        Arrays.sort(intArray, (a, b) -> b - a);
        for(int i = 0; i < intArray.length; i++) {
            sb.append(intArray[i]);
        }
        System.out.println(sb);
    }
}
