package jang;

import java.util.*;

//Hash02 전화번호 목록

public class Hash02v3 {      
	
    public boolean solution(String[] phone_book) {
        // set 인터페이스의 구현 클래스
    	// set : 중복 저장x, 하나의 null만 저장, 순서 유지x, **중복 자동 제거 
    	//LinkedHashSet: 순서 유지o, TreeSet : 자동정렬
    	
    	HashSet<String> set = new HashSet<>();
    	
    	for(String pb : phone_book) {
    		
    		for(String pb2 : set) {
    			if(pb.startsWith(pb2)|| pb2.startsWith(pb) )   				
    				return false;
    		}
    		set.add(pb);
    	}
    	return true;
        
    }

    
    public static void main(String[] args) {
    	//전화번호부
    	String[] phone_book = {"12", "123", "13245", "567", "343"};

    	Hash02 h02 = new Hash02();
    	
    	System.out.println(h02.solution(phone_book)+"입니다!");
    	 
    }
}