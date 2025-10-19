import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine();
        String[] T = br.readLine().split("");

        Deque<String> q = new ArrayDeque<>();
        for(int i = 0; i < T.length; i++) {
            q.add(T[i]);
        }

        Deque<String> newQ;

        while (q.size() != S.length()) {

            if (q.peekLast().equals("A")) {
                q.pollLast();
            } else {
                q.pollLast();
                newQ = new ArrayDeque<>();
                while (!q.isEmpty()) {
                    newQ.add(q.pollLast());
                }
                q = newQ;
            }
        }

        String rest = "";
        while (!q.isEmpty()) {
            rest += q.poll();
        }
        if (rest.equals(S)) {
            System.out.println("1");
        } else {
            System.out.println("0");
        }


    }
}
