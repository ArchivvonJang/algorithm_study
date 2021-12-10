package yun;

import java.util.HashMap;

public class Hash02 {
	public boolean check(String[] number) {
		boolean answer = true;
		HashMap<String, String> map = new HashMap<String, String>();
		for(int i=1; i<number.length; i++) {
			map.put(number[i], number[i]);
		}
		for(int i=0; i<number.length; i++) {
			if(map.containsKey(number[0])) {
				System.out.println(map.toString());
//				System.out.println(number[i]);
				answer = false;
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
