package yun;

import java.util.HashMap;

public class Hash02v2 {
	public boolean check(String[] number) {
		boolean answer = true;
		HashMap<String, String> map = new HashMap<String, String>();
		for(String value : number) {
			map.put(value, value);
		}
		for (int i = 0; i < number.length; i++) {
			for (int j = 0; j < number[i].length(); j++) {
				System.out.println("1=>"+map.get(number[i]));
				System.out.println(number[i].substring(0, j));
				System.out.println("i=>"+i);
//				if (map.containsKey(number[i].substring(0, j))) {
				if (map.containsKey(number[i].substring(0, j))) {
					System.out.println("??"+i);
					answer = false;
				}
			}
		}			
        return answer;
	}
	public static void main(String[] args) {
		String[] number = {"119", "9767", "1195"}; 
//		String[] number = {"123","456","789"};
		Hash02v2 sol = new Hash02v2(); 
		System.out.println(sol.check(number));
	}

}
