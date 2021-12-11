package jang;

import java.util.*;

//Hash02 전화번호 목록

public class Hash02 {      
	
    public boolean solution(String[] phone_book) {
        boolean answer = true;
       
        // 각 전화번호끼리 비교해야한다.
        // 전화번호들을 하나씩 꺼낸다.
        // 전화번호들끼리 숫자가 겹치는 번호가 있는지 확인한다.
        // 번호가 3개면 123 1-2 2-3 3-1 이런식으로 비교해야할까?
        Arrays.sort(phone_book);
        
        for(int i = 0; i<phone_book.length; i++) {
        	if(!phone_book[i].equals(phone_book[i])) {
        		//글자를 하나하나 잘라서 숫자 비교를 해야할까???
        		
        		answer = true;
        		
        	}else
        		answer = false;
        	
        }
        	
        return answer;
    }

    
    public static void main(String[] args) {
    	//전화번호부
    	String[] phone_book = {"123", "009", "7645", "88", "343"};

    	Hash02 h02 = new Hash02();
    	
    	System.out.println(h02.solution(phone_book)+"이다!");
    	
    
    }
}