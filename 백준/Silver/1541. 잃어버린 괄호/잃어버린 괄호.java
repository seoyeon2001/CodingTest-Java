import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputs = br.readLine().split("-");
//        System.out.println("inputs = " + Arrays.toString(inputs));

        int answer = 0;
        for(int j = 0; j < inputs.length; j++) {
            String[] nums = inputs[j].split("\\+");
//            System.out.println("nums = " + Arrays.toString(nums));

            int sum = 0;
            for(int i = 0; i < nums.length; i++) {
                sum += Integer.parseInt(nums[i]);
            }
            if(j == 0) answer += sum;
            else answer -= sum;
        }

        System.out.println(answer);
    }
}
