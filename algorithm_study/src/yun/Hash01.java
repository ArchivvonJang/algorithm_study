package yun;

import java.util.HashMap;
import java.util.Map;

//완주하지 못한 선수
public class Hash01 {
	public String findPlayer(String[] part, String[] comp) {
		String answer = ""; 
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		//참가선수를 맵에 다 넣고
		for(String player : part) {
//			map.put(player, "참가");
			map.put(player, map.getOrDefault(player, 0) + 1);
		}
		//완주선수를 맵에서 찾아서 뺀다
		for(String player : comp) {
//			map.remove(player);
			map.put(player, map.get(player) - 1);
		}
		//맵에 남아있는 선수이름은 리턴한다.
//		Map.Entry<String,String> entry = map.entrySet().iterator().next();
//		answer = entry.getKey();
		for (String key : map.keySet()) {
            if (map.get(key) != 0){
                answer = key;
            }
        }
		return answer;
	}

	public static void main(String[] args) {
		String[] part = {"min", "jang", "kim"}; 
		String[] comp = {"kim", "jang"}; 
		Hash01 sol = new Hash01(); 
		System.out.println(sol.findPlayer(part, comp));
	}

}
