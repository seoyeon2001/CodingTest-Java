import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] charArray = br.readLine().toCharArray();
        Arrays.sort(charArray);

        for(int i = charArray.length - 1; i >= 0; i--)
            System.out.print(charArray[i]);
    }
}
