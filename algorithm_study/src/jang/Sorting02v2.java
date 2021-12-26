package jang;

import java.util.*;

public class Sorting02v2 {
	
	 public String solution(int[] numbers) {
		 
	        String answer = "";
	        //List를 호출 (저장 순서ㅇ, 중복ㅇ)
	        List<Integer> list = new ArrayList<>();
	        // numbers를 list에 담는다.
	        for(int i = 0; i < numbers.length; i++) {
	            list.add(numbers[i]);
	        }
	        // ArrayList와 같이 배열을 이용한 자료구조 
	        //			장점 : 데이터를 읽어오고 저장하는데는 효율 b
	        //			단점 : 용량을 변경해야할 때는 새로운 배열을 생성한 후 기존 배열로부터 새로 생선된 배열로 데이터를 복사해야하기 때문에, 효율이 떨어짐
	       
	        //List와 Set의 조상님 
	        Collections.sort(list, (a, b) -> {   //<-람다식 : 익명의 객체
	        	// * ? 왜 Collections는 되고 List는 안되는건지 ? List와 int 또는 obj를 sort해줘서?
	        	
	        	// 문자열로 변경
	            String stra = String.valueOf(a);
	            String strb = String.valueOf(b);
	            return -Integer.compare(Integer.parseInt(stra + strb), Integer.parseInt(strb + stra));
	        });
	        
	        // String과 문자열을 더할 때 새로운 객체 생성x, 기존 데이터에 더하는 방식을 사용, 속도 빠르며 부하 적다
	        StringBuilder sb = new StringBuilder(); //문자열을 이어준다.
	        for(Integer i : list) {
	            sb.append(i); //먼저 StringBuilder의 객체를 생성한 후, append()의 인자로 연결하고자 하는 문자열을 넣어서 StringBuilder의 객체를 통해 호출
	        }
	        answer = sb.toString(); //이렇게 더해준 문자열을 담는다. 

	        // numbers의 0 이 아스키코드 0과 같으면 0을 리턴 
	        if(answer.charAt(0) == '0') {
	            return "0";
	        }else {
	            return answer;
	        }
	    }
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
