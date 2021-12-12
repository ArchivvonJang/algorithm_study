package jang;

import java.util.*;

//Hash02 전화번호 목록

public class Hash02v3 {      
	
    public boolean solution(String[] phone_book) {
    	
    	boolean answer = true;
        // set 인터페이스의 구현 클래스
    	// set : 중복 저장x, 하나의 null만 저장, 순서 유지x, **중복 자동 제거 
    	//LinkedHashSet: 순서 유지o, TreeSet : 자동정렬
    	
    	HashSet<String> set = new HashSet<>();
    	
        // phone_book i
        for(int i = 0; i<phone_book.length; i++) {
        	//set에 전화번호를 담아준다. 
        	set.add(phone_book[i]); 
        }
        // phone_book i와 j를 비교한다. 
        for (int i = 0; i < phone_book.length; i++) {
        	// 0번째-1번째, 1-2 순으로 비교해주기 위해 1부터 시작한다.
        	for (int j = 1; j < phone_book.length; j++) {
				// i를 담은 set에서 i를 0부터 j글자까지 자른 값이 있는 지 확인 
        		if(set.contains(phone_book[i].substring(0,j)))
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