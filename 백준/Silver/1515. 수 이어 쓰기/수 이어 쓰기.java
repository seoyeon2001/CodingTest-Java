import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        int num = 1;
        int idx = 0;
        while(idx < input.length()) {
            String strNum = String.valueOf(num);

            for(int i = 0; i < strNum.length(); i++) {
                if(input.charAt(idx) == strNum.charAt(i)) {
                    idx++;
                    if(idx >= input.length()) break;
                }
            }

            num++;
        }
        System.out.println(num-1);
    }
}
