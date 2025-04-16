import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        boolean c = true;

        for (int i = 0; i < T; i++) {
            c = true;
            String str = br.readLine();
            String[] strArray = str.split("");

            int right = strArray.length;

            while (right >= 2) {
                // 중간 값 찾기
                int mid = right / 2;

                String[] leftArray = Arrays.copyOfRange(strArray, 0, mid);
                String[] rightArray = Arrays.copyOfRange(strArray, mid+1, right);

                if (!check(leftArray, rightArray)) {
                    c = false;
                    break;
                }

                right = mid;
            }

            if (c) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    // 비교
    private static boolean check(String[] leftArray, String[] rightArray) {
        for (int i = 0; i < leftArray.length; i++) {
            if (leftArray[i].equals("0")) {
                leftArray[i] = "1";
            } else {
                leftArray[i] = "0";
            }
        }
        List<String> leftList = Arrays.asList(leftArray);
        Collections.reverse(leftList);
        leftList.toArray(leftArray);


        return Arrays.equals(leftArray, rightArray);
    }
}
