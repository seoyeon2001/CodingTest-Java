import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq1 = new PriorityQueue<>((a, b) -> b-a);
        PriorityQueue<Integer> pq2 = new PriorityQueue<>();

        int num1 = Integer.parseInt(br.readLine());
        pq1.add(num1);
        sb.append(pq1.peek()).append("\n");


        int num2 = Integer.parseInt(br.readLine());
        if(num1 > num2) {
            pq2.add(pq1.poll());
            pq1.add(num2);
        } else {
            pq2.add(num2);
        }
        sb.append(pq1.peek()).append("\n");


        for(int i = 2; i < n; i++) {
            int num = Integer.parseInt(br.readLine());

            if(pq1.peek() > num) {
                pq1.add(num);
                if(pq1.size() >= pq2.size()+2) pq2.add(pq1.poll());
            }
            else if(pq2.peek() < num) {
                pq2.add(num);
                if(pq1.size()+1 <= pq2.size()) pq1.add(pq2.poll());
            }
            else if(pq1.peek() <= num && num <= pq2.peek()) {
                if(pq1.size() == pq2.size()) pq1.add(num);
                else pq2.add(num);
            }

            sb.append(pq1.peek()).append("\n");

        }
        System.out.println(sb);
    }
}