package yun;

import java.util.HashMap;

public class 완주하지_못한_선수 {
	public String solution(String[] participant, String[] completion) {
		String answer = "";
		
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for(String player : participant) {
			map.put(player, map.getOrDefault(player, 0)+1);
		}
		
		for(String player : completion) {
			map.put(player, map.get(player)-1);
		}
		
		for(String key : map.keySet()) {
			if(map.get(key) != 0) {
				answer = key;
			}
		}
		return answer;
	}
	
	public static void main(String[] args) {
		완주하지_못한_선수 sol = new 완주하지_못한_선수();
//		System.out.println(sol.solution(new String[] {"leo", "kiki", "eden"}, new String[] {"eden", "kiki"}));
//		System.out.println(sol.solution(new String[] {"marina", "josipa", "nikola", "vinko", "filipa"}, new String[] {"josipa", "filipa", "marina", "nikola"}));
		System.out.println(sol.solution(new String[] {"mislav", "stanko", "mislav", "ana"}, new String[] {"stanko", "ana", "mislav"}));
	}

}
