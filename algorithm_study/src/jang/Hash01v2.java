package jang;

import java.util.HashMap;
import java.util.Map.Entry; 
// Hash01v2.완주하지 못한 선수 다른 버전 - 21.12.08 하지만 이것도 동명이인 못거름 

//Collection> Map> HashMap : key & value pair (key 중복x, value 중복ㅇ, 순서x)

public class Hash01v2{      
						// 마라톤참가 선수들의 이름 배열, 완주한 선수들의 이름 배열 
    public String solution(String[] participant, String[] completion) {
    	
    	// 풀이 방법?
    	// 문자열 배열에 담긴 문자열을 하나씩 읽어서 HashMap에 키로 저장하고 값으로 1을 저장한다. 
    	// HashMap에 같은 문자열이 키로 저장되어 있는지 containsKey()로 확인하여 이미 저장되어 있는 문자열이면 값을 1 증가시킨다.
    	// 비교하면서 찾기 containsKey()? participant가 담긴 map에서 completion remove?
    	// 없는 이름 entrySet()으로 꺼내기 : Key와 Value에 대한 Entry 형태로 Set에 저장해서 반환
    	// keySet() 저장된 key값 확인 써도되지만 
    	// 효율 : entrySet > keySet
    	
    	
        String answer = "";
        int val ;

        HashMap<String, Integer> map = new HashMap<String, Integer>();
        
        for(int i = 0; i< participant.length; i++){
        	// 마라톤 참가 선수들의 이름을 담는다.
            String name = participant[i]; 
            
            // map에 같은 문자열이 키로 저장되어있는지 확인한다.
            if(map.containsKey(name)) {
            	 val = map.get(name);
            	// 같은 문자열이 저장되어있다면, val += 1을 해준다.
            	 val++;
            	map.put(name, val);     
            }else {
            	// 그게 아니면 값은 1, 마라톤 참가 선수이름을 key로 map에 담는다.
            	map.put(name, 1); 
            }      
        }
 
       for(int i = 0; i<completion.length; i++) {
    	  // 완주한 선수들의 이름
    	  String name = completion[i];
    	  // map에 저장된 값 꺼낸다.
    	  	val = map.get(name);
    	  // 완주한 선수들의 이름이 마라톤 참가선수 map에 있다면, value가 1이라면
    	  if(map.containsKey(name) && val == 1) {
    		  //완주한 선수들 삭제
    		  map.remove(name);
    	  }else {
    		  // value 가 1인 선수들이 꺼내졌으므로, 기존에 2이상이었던 선수들의 value -=1 해준다.
    		  map.put(name, val--);  
    	  }

       }
       
       //남은 선수들을 찾는다.
      for (Entry<String, Integer> entry : map.entrySet()) {
  	    answer = entry.getKey()+ "는 참여자 명단에는 있지만 완주자 명단에는 없기 때문에 완주하지 못했습니다.";
  	}
        
        return answer; // 완주하지 못한 선수들의 이름을 return 
    }
    
    public static void main(String[] args) {
    	//선수들 명단
    	String[] participant = {"marina", "josipa", "nikola", "vinko", "filipa","marina"};
    	String[] completion = {"josipa", "filipa", "marina", "nikola"};
    	
    	Hash01v2 h01 = new Hash01v2();
    	
    	System.out.println(h01.solution(participant, completion));
    	
    
    }
}