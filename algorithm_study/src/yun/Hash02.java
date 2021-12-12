package yun;

import java.util.HashMap;

public class Hash02 {
	public boolean check(String[] number) {
		boolean answer = true;
		HashMap<String, String> map = new HashMap<String, String>();
		for(String value : number) {
			map.put(value, value);
		}
		for(int i=0; i<number.length; i++) {
			for(int j=0; j<map.size(); j++) {
				if(!number[i].equals(map.get(number[j]))) {//number[i]와 number[j]가 같은 경우에는 제외.
					int idxOfNumber = map.get(number[j]).indexOf(number[i]); //map의 j번째 value에 number[i]가 없으면 -1
					if(idxOfNumber != -1) {
						answer = false;
					}
				}
			}
			
		}
        return answer;
	}
	public static void main(String[] args) {
		String[] number = {"119", "97674223", "1195524421"}; 
//		String[] number = {"123","456","789"};
		Hash02 sol = new Hash02(); 
		System.out.println(sol.check(number));
	}

}
