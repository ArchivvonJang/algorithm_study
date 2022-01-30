package yun;

import java.util.HashMap;

public class 위장 {
	public int solution(String[][] clothes) {
		int answer = 1;
		//종류 개수 구하기
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for(int i=0; i<clothes.length; i++) {
			map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0)+1);
		}
		
		//경우의 수 구하기 
		for(String key : map.keySet()) {
			answer *= map.get(key)+1; // 각 종류마다 미착용 조건이 있으므로 구해진 개수에서 +1
			/*
			 * 예-> 종류: 모자
			 * 		개수 : 2개
			 * 경우의 수 : 1-> 1번 모자 착용, 2-> 2번 모자 착용, 3-> 모자 미착용
			 */
		}
		
		return answer-1;//경우의 수를 구하고 나면 모든 종류 미착용 조건이 포함되어있기 때문에 예외처리로 -1
		
	}
	public static void main(String[] args) {
		위장 sol = new 위장();
//		System.out.println(sol.solution(new String[][] {
//			{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}
//		}));
		System.out.println(sol.solution(new String[][] {
			{"crowmask", "face"}, {"bluesunglasses", "face"}, {"smoky_makeup", "face"}
		}));	
	}

}
