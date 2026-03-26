import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        boolean[] isPrime = new boolean[1003002];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for(int i = 2; i <= Math.sqrt(1003002); i++) {
            if(!isPrime[i]) continue;

            for(int j = i*i; j < 1003002; j+=i) {
                isPrime[j] = false;
            }
        }

        for(int i = n; i <= 1003001; i++) {
            if(isPrime[i]) {
//                System.out.println("소수 = " + i);
                if(check(i)) {
                    System.out.println(i);
                    break;
                }
            }
        }
    }

    static boolean check(int num) {
        String number = String.valueOf(num);

        int length = number.length();

        if(length % 2 == 0) {
            for(int i = 0; i < length / 2; i++) {
                if(number.charAt(i) != number.charAt(length-i-1)) return false;
            }
        } else {
            for(int i = 0; i < length / 2 + 1; i++) {
                if(number.charAt(i) != number.charAt(length-i-1)) return false;
            }
        }

        return true;
    }
}
