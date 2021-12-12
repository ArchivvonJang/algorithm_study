package jang;

import java.util.*;

//Hash02 전화번호 목록

public class Hash02v2 {      
	
    public boolean solution(String[] phone_book) {
    	
    	boolean answer = true;
        
    	HashMap<String, Integer> map = new HashMap<>();
    	
        // phone_book i
        for(int i = 0; i<phone_book.length; i++) {
        	//전화번호를 키로 해시맵에 담아준다. 값은 i++
        	map.put(phone_book[i], i);
        }
        // phone_book i와 j를 비교한다. 
        for (int i = 0; i < phone_book.length; i++) {
        	// 0번째-1번째, 1-2 순으로 비교해주기 위해 1부터 시작한다.
        	for (int j = 1; j < phone_book.length; j++) {
				// i를 담은 맵의 키와 i를 0부터 j글자까지 자른 값이 있는 지 확인 
        		if(map.containsKey(phone_book[i].substring(0,j)))
        				answer = false;
			}
        }
        	return answer;
    
    }

    
    public static void main(String[] args) {
    	//전화번호부
    	String[] phone_book = {"12", "123", "13245", "567", "343"};

    	Hash02 h02 = new Hash02();
    	
    	System.out.println(h02.solution(phone_book)+"입니다!");
    	
    
    }
}