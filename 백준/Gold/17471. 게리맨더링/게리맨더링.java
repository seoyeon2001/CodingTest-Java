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
        // System.out.println("graph = " + Arrays.toString(graph));

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

    // 조합 구하기
    static void combi(List<Integer> aList, int start, int r) {
        if(r == 0) {
            cal(aList);
            return;
        }

        for(int i = start; i <= n; i++) {
            aList.add(i);
            combi(aList, i+1, r-1);
            aList.remove(aList.size()-1);
        }
    }

    static void cal(List<Integer> aList) {
        // A구가 잘 연결되어있는지 확인
        if(!isLinked(aList)) return;

        List<Integer> bList = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (aList.contains(i)) {
                continue;
            }
            bList.add(i);
        }

        // B구가 잘 연결되어있는지 확인
        if(!isLinked(bList)) return;

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

    // 선거구가 모두 연결되어있는지 확인
    static boolean isLinked(List<Integer> list) {
        boolean[] visited = new boolean[n+1];
        Deque<Integer> q = new ArrayDeque<>();

        visited[list.get(0)] = true;
        q.add(list.get(0));

        int count = 1;
        while (!q.isEmpty()) {
            int start = q.poll();

            for (int i : graph[start]) {
                // 방문 이력 없고, 선거구에 해당
                if (!visited[i] && list.contains(i)) {
                    visited[i] = true;
                    q.add(i);
                    count++;
                }
            }
        }

        return count == list.size() ? true : false;
    }
}
