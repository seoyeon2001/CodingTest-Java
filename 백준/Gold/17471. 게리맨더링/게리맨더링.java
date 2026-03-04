import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int[] people;
    static List<Integer>[] graph;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        people = new int[n+1];
        int totalPeople = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++) {
            int num = Integer.parseInt(st.nextToken());
            people[i] = num;
            totalPeople += num;
        }

        graph = new ArrayList[n+1];
        for(int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int linkCnt = Integer.parseInt(st.nextToken());
            for(int j = 0; j < linkCnt; j++) {
                graph[i].add(Integer.parseInt(st.nextToken()));
            }
        }

        answer = Integer.MAX_VALUE;

        // 조합 구하기
        List<Integer> aList = new ArrayList<>();
        for(int cnt = 1; cnt <= n / 2; cnt++) {
            combi(aList, 1, cnt);
        }

        // 다 처리한 후에도 변하지 않으면 -1
        if (answer == Integer.MAX_VALUE) {
            System.out.println(-1);
            return;
        }

        System.out.println(answer);
    }

    static void combi(List<Integer> aList, int start, int r) {
        if(r == 0) {
            cal(aList);
            return;
        }

        for(int i = start; i <= n; i++) {
            aList.add(i);
            combi(aList, i + 1, r - 1);
            aList.remove(aList.size() - 1);
        }
    }

    static void cal(List<Integer> aList) {
        // A구가 잘 연결되어있는지 확인
        if(!isLinked(aList.get(0), aList, aList.size())) {
            return;
        }

        List<Integer> bList = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (aList.contains(i)) {
                continue;
            }
            bList.add(i);
        }

        // B구가 잘 연결되어있는지 확인
        if(!isLinked(bList.get(0), bList, bList.size())) {
            return;
        }

        int resultA = 0, resultB = 0;

        // A 지역구 인구 계산
        for (int i : aList) {
            resultA += people[i];
        }

        // B 지역구 인구 계산
        for (int i : bList) {
            resultB += people[i];
        }

        int result = Math.abs(resultA - resultB);
        answer = Math.min(answer, result);

    }

    // 선거구가 모두 연결되어있는지 확인.
    static boolean isLinked(int num, List<Integer> list, int size) {
        boolean[] visited = new boolean[n+1];
        visited[num] = true;
        Queue<Integer> q = new LinkedList<>();
        q.add(num);

        int count = 1;
        while (!q.isEmpty()) {
            int start = q.poll();

            for (int i : graph[start]) {
                // 이미 방문한 적이 없고, list에 속해야 함.
                if (!visited[i] && list.contains(i)) {
                    visited[i] = true;
                    count++;
                    q.add(i);
                }
            }
        }

        if (count == size) {
            return true;
        }
        return false;
    }
}
