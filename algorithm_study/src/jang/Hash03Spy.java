package jang;

import java.util.HashMap;

public class Hash03Spy {
    public int solution(String[][] clothes) {
        int answer = 1; // 경우의 수를 곱했을 때, 0이 나오는 참사를 막기 위해

        HashMap<String, Integer> map = new HashMap<>();

        //옷의 조합보다는 조합의 개수에 집중
        //headgear, eyewear 등 각 종류별로 옷의 개수를 구한 뒤 각 종류별 옷의 조합에 대한 경우의 수 구하기
        // ABCD 를 선택하는 경우의 수를 구하는 방법 : (A+1) x (B+1) x (c+1) x (D+1)- 1
        for(int i = 0; i<clothes.length; i++){
            String kind = clothes[i][1];
            map.put(kind, map.getOrDefault(kind,1) + 1); // +1을 해주는 이유는 특정 종류의 옷을 선택하지 않는 경우
        }
        for(String key : map.keySet()){
            answer *= map.get(key) ;
        }
        return answer-1 ; //-1 은 아무것도 입지 않은 경우
    }

    public static void main(String[] args) {
        String[][] clothes = {
                {"yellowhat", "headgear"},
                {"bluesunglasses", "eyewear"},
                {"green_turban", "headgear"}
        };

        Hash03Spy h03 = new Hash03Spy();
        System.out.println(h03.solution(clothes));
    }
}
