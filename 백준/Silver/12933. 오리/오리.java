import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] words = br.readLine().toCharArray();

        int answer = 0;

        List<Stack<Character>> stackList = new ArrayList<>();
        for(Character word : words) {
            boolean chk = false;

            for(Stack<Character> stack : stackList) {
                if(!stack.isEmpty()) {
                    if(stack.peek() == 'k' && word == 'q') {
                        stack.add(word);
                        chk = true;
                        break;
                    } else if(stack.peek() == 'q' && word == 'u') {
                        stack.add(word);
                        chk = true;
                        break;
                    } else if(stack.peek() == 'u' && word == 'a') {
                        stack.add(word);
                        chk = true;
                        break;
                    } else if(stack.peek() == 'a' && word == 'c') {
                        stack.add(word);
                        chk = true;
                        break;
                    } else if(stack.peek() == 'c' && word == 'k') {
                        stack.add(word);
                        chk = true;
                        break;
                    }
                }
            }

            if(!chk) {
                if(word != 'q') {
                    System.out.println(-1);
                    return;
                }
                Stack<Character> s = new Stack<>();
                s.add(word);
                stackList.add(s);
                answer++;
            }
        }

        for(Stack<Character> stack : stackList) {
            if(stack.size() % 5 != 0) {
                System.out.println(-1);
                return;
            }
        }
        System.out.println(answer);

    }
}
