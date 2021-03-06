package moon;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;

public class 해쉬_완주하지못한선수 {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String, Integer> map = new HashMap<>();
        Arrays.sort(participant);
        Arrays.sort(completion);

        // hashMap에 추가
        for (String p : participant) {
            map.put(p, map.getOrDefault(p, 0) + 1); // p가 key에 있으면 value를 가져옴. 없으면 디폴트 0
        }
        // 통과된 선수들 제거
        for (String c : completion) {
            map.put(c, map.get(c)-1);
        }
        // 순환하면서 0인 선수 return
        // Iterator가 더 속도높음
        Iterator<String> keys = map.keySet().iterator();
        while (keys.hasNext()) {
            String key = keys.next();
            if (map.get(key) != 0) {
                answer = key;
                break;
            }
        }

        // for (String key : map.keySet()) {
        //     if (map.get(key) != 0) {
        //         answer = key;
        //         break;
        //     }
        // }
        return answer;
    }

    public static void main(String[] args) {
        해쉬_완주하지못한선수 k = new 해쉬_완주하지못한선수();

        String[] part = {"marina", "josipa", "nikola", "vinko", "filipa"};
        String[] comp = {"josipa", "filipa", "marina", "nikola"};

        String answer = k.solution(part, comp);
        System.out.println(answer);
    }
}
