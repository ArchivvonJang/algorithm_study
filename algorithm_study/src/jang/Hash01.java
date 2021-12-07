package jang;

import java.util.HashMap;
import java.util.Map.Entry; 
// Hash01.완주하지 못한 선수 

//Collection> Map> HashMap : key & value pair (key 중복x, value 중복ㅇ, 순서x)

public class Hash01 {      
						// 마라톤참가 선수들의 이름 배열, 완주한 선수들의 이름 배열 
    public String solution(String[] participant, String[] completion) {
    	
    	// 풀이 방법?
    	// HaspMap에 participant 담기
    	// HashMap에 completion 담기
    	// 비교하면서 찾기 containsKey()? participant가 담긴 map에서 completion remove?
    	// 없는 이름 entrySet()으로 꺼내기 : Key와 Value에 대한 Entry 형태로 Set에 저장해서 반환
    	// keySet() 저장된 key값 확인 써도되지만 
    	// 효율 : entrySet > keySet
    	

    	
    	
    	
        String answer = "";
        

        HashMap<String, Integer> map = new HashMap<String, Integer>();
        
        for(int i = 0; i< participant.length; i++){
        	// 마라톤 참가 선수들의 이름
            String name = participant[i]; 
            
            // 마라톤 참가 선수이름을 key로 map에 담기
            map.put(name, i);            
        }
 
       for(int i = 0; i<completion.length; i++) {
    	  // 완주한 선수들의 이름
    	  String name = completion[i];
    	  
    	  // 완주한 선수들의 이름이 마라톤 참가선수 map에 있다면,
    	  if(map.containsKey(name)) {
    		  //완주한 선수들 삭제
    		  map.remove(name);
    	  }
       }
       //남은 선수들을 찾는다.
       for (Entry<String, Integer> entry : map.entrySet()) {
    	    answer = entry.getKey() + "는 참여자 명단에는 있지만 완주자 명단에는 없기 때문에 완주하지 못했습니다." ;
    	}
        
        return answer; // 완주하지 못한 선수들의 이름을 return 
    }
    
    public static void main(String[] args) {
    	//선수들 명단
    	String[] participant = {"marina", "josipa", "nikola", "vinko", "filipa"};
    	String[] completion = {"josipa", "filipa", "marina", "nikola"};
    	
    	Hash01 h01 = new Hash01();
    	
    	System.out.println(h01.solution(participant, completion));
    	
    	//21.12.07 : programmers 코드실행 결과 중복이름은 해결이 안됨!! 다른 방법도 찾아보기 
    }
}