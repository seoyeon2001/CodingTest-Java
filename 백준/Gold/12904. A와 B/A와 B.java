import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine();
        String T = br.readLine();

        while (S.length() != T.length()) {
            char lastAlpa = T.charAt(T.length() - 1);

            if (lastAlpa == 'A') {
                T = T.substring(0, T.length() - 1);
            } else if (lastAlpa == 'B') {
                T = T.substring(0, T.length() - 1);
                StringBuffer sb = new StringBuffer(T);
                T = sb.reverse().toString();
            }
        }

        System.out.println(T.equals(S) ? 1 : 0);
    }
}
