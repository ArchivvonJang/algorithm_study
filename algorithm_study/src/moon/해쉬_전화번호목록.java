package moon;

import java.util.*;

public class 해쉬_전화번호목록 {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Integer min = 1;
        Map<String, Integer> map = new HashMap<>();

        Arrays.sort(phone_book);
        // 해쉬에 전화번호와 접두사 횟수 담기(자기 자신 포함해서 1)
        for (String phone : phone_book) {
            map.put(phone, 1);
        }

        for (String prefixPhone : map.keySet()) {
            // 반복문 돌면서 prefixPhone이 접두사로 있으면 -1하기
            for (String phone : map.keySet()) {
                if (phone.startsWith(prefixPhone)) {
                    map.put(prefixPhone, map.get(prefixPhone) - 1);   // 접두사이면 접두사인 key의 value에 -1
                }
            }
            // min보다 작으면 min으로 저장
            if (map.get(prefixPhone) < min)
                min = map.get(prefixPhone);
        }

        //  0 미만인 value가 있으면 false 리턴
        if (min < 0) answer = false;

        return answer;
    }


    public static void main(String[] args) {
        해쉬_전화번호목록 k = new 해쉬_전화번호목록();

        String[] phoneBook = {"12","123","1235","567","88"};

        boolean answer = k.solution(phoneBook);
        System.out.println(answer);
    }
}

