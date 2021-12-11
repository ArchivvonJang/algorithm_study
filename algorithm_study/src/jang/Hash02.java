package jang;

import java.util.Arrays;
import java.util.HashMap;

//Hash02 전화번호 목록

public class Hash02 {      
	
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        
        HashMap<String, Integer> map = new HashMap<>();
        for(String pb : phone_book) {
        	map.put(pb, map.getOrDefault(map, null));
        }
        	// ...
        	
        return answer;
    }

    
    public static void main(String[] args) {
    	//전화번호부
    	String[] phone_book = {"9900", "josipa", "nikola", "vinko", "filipa"};

    	Hash02 h02 = new Hash02();
    	
    	System.out.println();
    	
    
    }
}