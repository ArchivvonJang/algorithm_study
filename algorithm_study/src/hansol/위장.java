package hansol;

import java.util.HashMap;
import java.util.Map;

public class 위장 {
    public static final int INIT_CLOTHE_COUNT = 2;
    public static final int CLOTHE_CATEGORY_POINT = 1;

    public int solution(String[][] clothes) {
        Map<String, Integer> clothesMap = toMap(clothes);
        int count = 1;

        for (int value : clothesMap.values()) {
            count *= value;
        }

        // 아무 것도 안 입은 경우 1가지를 제거한다.
        return count - 1;
    }

    private Map<String, Integer> toMap(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();
        for (String[] clothe : clothes) {
            map.merge(clothe[CLOTHE_CATEGORY_POINT], INIT_CLOTHE_COUNT, (value, putValue) -> ++value);
        }

        return map;
    }
}
