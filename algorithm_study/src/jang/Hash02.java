package jang;

import java.util.*;

//Hash02 전화번호 목록

public class Hash02 {      
	
    public boolean solution(String[] phone_book) {
        // 각 전화번호끼리 비교해야한다.
        // 전화번호들을 하나씩 꺼낸다.
        // 전화번호들끼리 숫자가 겹치는 번호가 있는지 확인한다.
        // 번호가 3개면 123 1-2 2-3 3-1 이런식으로 비교해야할까?ㅏ
        // 아니면 글자를 하나하나 잘라야할까?
        
        //오름차순으로 정렬해준다. 미리 오름차순해서 번호를 비교하는 시간을 단축해준다
        Arrays.sort(phone_book); 
        
        //다른 조건으로 정렬을 하고 싶다면, Comparable, comparator 사용하면 된다.        
        
        
        // phone_book i
        for(int i = 0; i<phone_book.length; i++) {
        	// phone_book j 
        	for (int j = 0; j < phone_book.length; j++) {
				
        		//i 배열과 j 배열의 전화번호부 번호를 비교한다. 
        		// startsWith() : 대상 문자열이 특정 문자 또는 문자열로 시작하는지 체크해주는 함수 *공백도 취급하므로 주의  
        		// return 은 true, false
        		// * endsWith() : 반대로 대상 문자열이 특정 문자 또는 문자열로 끝나는지 체크하는 함수  
        		if(phone_book[j].startsWith(phone_book[i]));
        		return false;
				
			}
        	
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