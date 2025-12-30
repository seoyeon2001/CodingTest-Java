import java.util.*;

class Solution {
    
    static int[][] result;
	static int[] extra;
	
	static int[] gSales;
    static List<Integer>[] graph;
    
    public int solution(int[] sales, int[][] links) {
        int num = sales.length; // 직원 수
        
        // sales 복사
        gSales = new int[num]; 
        for(int i = 0; i < num; i++) gSales[i] = sales[i];
        
        // 2차원 배열 -> 리스트
        graph = new ArrayList[num+1];
        for(int i = 1; i <= num; i++) graph[i] = new ArrayList<>();
        for(int i = 0; i < links.length; i++) graph[links[i][0]].add(links[i][1]);
        
        result = new int[num+1][2]; // 참석한 경우, 참석하지 않은 경우 
        extra = new int[num+1];
        
        trevarsal(1); // CEO를 기준으로 모든 노드 순회 
        
        return Math.min(result[1][0], result[1][1]); // CEO가 참석한 경우 vs 참석하지 않은 경우 
    }
    
    // 후위 순회 (왼 -> 오 -> 루트)  
	static void trevarsal(int pos) {
		result[pos][0] = 0; // 참석 x
		result[pos][1] = gSales[pos - 1]; // 참석 o
        
        int childNum = graph[pos].size();
		if(childNum == 0) return; // leaf 노드 도착 (팀원)
		
		int extra_cost = Integer.MAX_VALUE;
		// 부모 -> 자식 탐색 
		for(int child : graph[pos]) {
			trevarsal(child); // child 탐색 
				
			// 팀원x : 해당 팀원(child)이 참석 안하는게 더 적은 비용이 드는 경우
			if(result[child][0] < result[child][1]) {
				result[pos][0] += result[child][0]; // 팀장 x 팀원 x -> 예외처리 필요(다른 자식노드 참여) 
				result[pos][1] += result[child][0]; // 팀장 o 팀원 x
					
				// 팀장x 팀원x인 경우 한 팀에 최소 한명이니깐 팀원 중 최소비용 추가해놓기
				extra_cost = Math.min(extra_cost, result[child][1] - result[child][0]);
			} else { // 팀원 o : 해당 팀원(child)이 참여하는게 더 적은 비용이 드는 경우  
				result[pos][0] += result[child][1]; // 팀장 x 팀원 o
				result[pos][1] += result[child][1]; // 팀장 o 팀원 o
					
				// 팀장x 팀원o 이면 다른 자식이 참여헀으니깐 0으로 초기화 
				extra_cost = 0;
			}
		}
        
//		System.out.println(pos +" 팀장 참여안할 때 최소비용드는 팀원 cost: " + extra_cost);
		result[pos][0] += extra_cost; // 아무도 참석 안할 경우 최소비용 팀원 추가
	}
}