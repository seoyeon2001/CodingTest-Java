import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long min = Long.parseLong(st.nextToken());
        long max = Long.parseLong(st.nextToken());

        Set<Long> set = new HashSet<>();
        for(long i = 2; i <= Math.sqrt(max); i++) {
//            System.out.println("i = " + i);

            long wprhqtn = i*i;
            for(long j = min / wprhqtn; j <= max / wprhqtn; j++) {
//                if(wprhqtn * j == 0) System.out.println("i = " + i + " j = " + j);
                if(wprhqtn*j < min) continue;
                set.add(wprhqtn*j);
            }
        }
//        System.out.println("set = " + set);
//        System.out.println("size = " + set.size());
        System.out.println(max-min+1-set.size());

    }
}
