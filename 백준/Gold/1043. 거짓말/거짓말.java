import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr = new int[n+1];
        for(int i = 1; i <= n; i++) {
            arr[i] = i;
        }

        st = new StringTokenizer(br.readLine());
        int cnt = Integer.parseInt(st.nextToken());
        List<Integer> turePeople = new ArrayList<>();
        for(int i = 0; i < cnt; i++) {
            turePeople.add(Integer.parseInt(st.nextToken()));
        }
//        System.out.println("진실을 아는 사람 " + turePeople);

        List<int[]> partyList = new ArrayList<>();
        while(m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int participant = Integer.parseInt(st.nextToken()); // 파티 참석자 수
            int[] party = new int[participant];

            for(int i = 0; i < participant; i++) {
                party[i] = Integer.parseInt(st.nextToken());
            }
            partyList.add(party);

            for(int i = 0; i < party.length-1; i++) {
                union(party[i], party[i+1]);
            }
        }

//        System.out.println("arr = " + Arrays.toString(arr));

        int answer = 0;
        for(int[] pa : partyList) {
            boolean check = true;
            for(int truePerson : turePeople) {
                if(find(truePerson) == find(pa[0])) {
                    check = false;
                    break;
                }
            }

            if(check) answer++;
        }
        System.out.println(answer);
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if(a < b) arr[b] = a;
        else arr[a] = b;
    }

    static int find(int num) {
        if(num == arr[num]) return num;
        return arr[num] = find(arr[num]);
    }
}
