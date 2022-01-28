package moon;
import java.util.HashMap;

/**
 * 의상의 종류를 key로
 * 합칠 때는 의상의 종류가 다른 것들 끼리만 합칠 수 있음
 * 각 의상 종류 갯수끼리 경우의 수를 곱하기
 **/
class 해쉬_위장 {
    public int solution(String[][] clothes) {
        int answer = 1;
        // 1. map에 의상 종류와 갯수
        HashMap<String, Integer> map = new HashMap<>();
        for (String[] cloth: clothes) {
            map.put(cloth[1], map.getOrDefault(cloth[1], 0)+1);
        }
        // 2. 의상 종류 갯수(map size)만큼 돌면서 경우의 수(value+안 입은 경우)를 곱한 후, -1을 한다. (둘다 안입은 경우의 수 제거)
        for (int cloth : map.values()) {
            answer *= (cloth +1) ;
        }
        answer--;

        return answer;
    }

    public static void main(String[] args) {
        String[][] clothes = {{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}};
        해쉬_위장 k = new 해쉬_위장();
        System.out.println(k.solution(clothes));
    }
}