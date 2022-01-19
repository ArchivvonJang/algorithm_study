package yun;

import java.util.*;

public class 여행경로2 {
	ArrayList<String> routes;
	boolean[] visited;

	public String[] solution(String[][] tickets) {
		String[] answer = {};
		routes = new ArrayList<String>();
		visited = new boolean[tickets.length];
		
		dfs("ICN", "ICN", tickets, 0);
		
		System.out.println("+++++++++정렬 +++++++++++");
		print(routes);
		System.out.println("++++++++++++++++++++");
		Collections.sort(routes);
		System.out.println("++++++++++정렬 후 ++++++++++");
		print(routes);
        answer = routes.get(0).split(" ");
		
        return answer;
    }
	
	public void dfs(String start, String route, String[][] tickets, int count) {
		if(count == tickets.length) {
			routes.add(route);
			return;
		}
		
		for(int i = 0; i < tickets.length; i++) {
			if(start.equals(tickets[i][0]) && !visited[i]) {
				visited[i] = true;
				dfs(tickets[i][1], route+" "+tickets[i][1], tickets, count+1);
				visited[i] = false;
			}
		}
	}
	
	public void print(ArrayList<String> routes) {
		for(int i=0; i<routes.size(); i++) {
			System.out.println(routes.get(i));
		}
	}
	
	public static void main(String[] args) {
		String[][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}};
//		String[][] tickets = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
		여행경로2 sol = new 여행경로2();
		System.out.println(Arrays.toString(sol.solution(tickets)));
	}

}
