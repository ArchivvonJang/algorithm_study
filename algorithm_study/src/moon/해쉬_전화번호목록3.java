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
class 해쉬_전화번호목록3 {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Map<String, Integer> map = new HashMap<>();
        Arrays.sort(phone_book);

        // 해쉬에 전화번호와 접두사 횟수 담기(자기 자신 포함해서 1)
        for (int i = 0; i < phone_book.length; i++) {
            map.put(phone_book[i], i);
        }

        for (int i = 0; i < phone_book.length; i++) {
            for (int j = 1; j < phone_book[i].length(); j++) {      // 끝에서 두번째까지만 탐색해서 그 값이 있으면 접두어가 있는 것으로 처리 (중복 전화번호x+ 끝까지 탐색하면  자기 자신)
                System.out.println("phoneBook은 "+ phone_book[i]);
                System.out.println(phone_book[i].substring(0, j));
                if (map.containsKey(phone_book[i].substring(0, j))) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        해쉬_전화번호목록3 k = new 해쉬_전화번호목록3();

        String[] phoneBook = {"12","123","1235","567","88"};

        boolean answer = k.solution(phoneBook);
        System.out.println(answer);
    }
}