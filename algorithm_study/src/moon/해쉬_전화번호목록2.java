package moon;
import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;

/**
 * 하지만 Arrays.sort(String[])은 String 클래스의 naturing ordering을 따릅니다. String클래스의 경우, natural ordering은 lexicographically라고 합니다.
 * 직역하면 "사전 편찬 상"라고 합니다. 쉽게 말해 사전에서 단어가 위치한 것처럼 정렬한 것입니다.
 * 따라서 "123", "1000", "1234"를 정렬하면 "123", "1234", "1000"이 되는 겁니다.
 * 따라서 O(N2)의 방식(이중 for문)이 아니라 O(N)의 방식(단일 for문)으로 앞뒤 String을 확인하면 문제를 풀 수 있는 겁니다.
 */
class 해쉬_전화번호목록2 {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Map<String, Integer> map = new HashMap<>();
        Arrays.sort(phone_book);

        // 해쉬에 전화번호와 접두사 횟수 담기(자기 자신 포함해서 1)
        for (String phone : phone_book) {
            map.put(phone, 0);
        }

        for (String prefixPhone : map.keySet()) {
            // 반복문 돌면서 prefixPhone이 접두사로 있으면 -1하기
            for (String phone : map.keySet()) {
                if (phone.equals(prefixPhone))
                    continue;
                if (phone.startsWith(prefixPhone)) {
                    answer = false;
                    break;
                }
            }
            if (answer == false)
                break;
        }
        // min보다 작으면 min으로 저장
        //     if (map.get(prefixPhone) < min)
        //         min = map.get(prefixPhone);
        // }

        //  0 미만인 value가 있으면 false 리턴
        // if (min < 0) answer = false;

        return answer;
    }

}