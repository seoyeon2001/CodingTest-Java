import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        char[] charArray = br.readLine().toCharArray();

        int[] numArray = new int[10];
        for(int i = 0; i < charArray.length; i++) {
            numArray[charArray[i] - '0']++;
        }

        for(int i = 9; i >= 0; i--) {
            if(numArray[i] != 0) {
                sb.append(String.valueOf(i).repeat(numArray[i]));
            }
        }

        System.out.println(sb);
    }
}
