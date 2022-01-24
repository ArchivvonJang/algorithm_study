package yun;

import java.util.ArrayList;
import java.util.Arrays;

public class 여행경로 {
	String[] answer = {};
	ArrayList<String[]> routes = new ArrayList<String[]>();
	boolean[] visited;

	public String[] solution(String[][] tickets) {
		visited = new boolean[tickets.length];
		routes.add(tickets[0]);
		
        dfs(tickets[0], tickets, 0);
        
        return answer;
    }
	
	public void dfs(String[] start, String[][] tickets, int count) {
		if(count == tickets.length) {
			return;
		}
		
		for(int i=1; i<tickets.length; i++) {
			
        	if(start[1].equals(tickets[i][0]) && !visited[i]) {
        		visited[i] = true;
        		routes.add(tickets[i]);
        		dfs(tickets[i], tickets, count+1);
        		visited[i] = false;
        	}
        }
	}
	
	public static void main(String[] args) {
//		String[][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}};
		String[][] tickets = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
		여행경로 sol = new 여행경로();
		System.out.println(Arrays.toString(sol.solution(tickets)));
	}

}
