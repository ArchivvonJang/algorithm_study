package jang;

import java.util.HashMap;
import java.util.HashSet;

//해시 - 전화번호부
public class Hash02PhoneBook {

    public boolean solution(String[] phone_book) {
        boolean answer = true;

        HashSet<String> set = new HashSet<>();

    	for (int i = 0; i < phone_book.length; i++) {
            set.add(phone_book[i]);
        }

        for(String p:phone_book) {
            for(int j=1; j<p.length(); j++) {

                // LCS : Longest Common Subsequence의 약자로 최장 공통 부분 문자열
                // substring과 비교하면 substring은 연속된 부분 문자열이고 subsequence는 연속적이지는 않은 부분 문자열
                // 2개의 String을 비교하여 최장 공통 부분 문자열을 구한다.
                if(set.contains(p.subSequence(0, j)))
                    answer = false;
            }
        }
        return answer;
    }


    public static void main(String[] args) {
        //전화번호부
        String[] phone_book = {"12", "123", "13245", "567", "343"};

        Hash02PhoneBook pb = new Hash02PhoneBook();

        System.out.println(pb.solution(phone_book));


    }
}
