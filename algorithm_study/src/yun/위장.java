package yun;

import java.util.HashMap;

public class 위장 {
	public int solution(String[][] clothes) {
        int answer = 1; //곱하기해야해서 1로 초기화 
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        
        for(int i=0; i<clothes.length; i++) {
        	map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0)+1); // 종류마다 몇개가 clothes에 들어있는지 개수 구하기
        }
        
        // 경우의 수 구하기
        for(String key : map.keySet()) {
        	answer *= map.get(key)+1; // 종류마다 입지 않는다는 조건도 있으므로 +1
        	/*예) 모자가 2개일때
        	 * 1-> 모자 1번 착용
        	 * 2-> 모자 2번 착용
        	 * 3-> 모자 미착용
        	 *
        	 *  여기까지 진행되면 answer에는 모든 종류 미착용 경우가 들어간다
        	 */
        }
        
        return answer-1;  // 문제 조건에 종류를 하나라도 착용한다고 했으므로 모든 종류 미착용 경우를 제외하기 위해 -1
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
