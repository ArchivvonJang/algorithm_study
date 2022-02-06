package moon;
// 중복 x, 같은 장르 내에서는 재생횟수 같을 수 있음(다른 장르끼리는 재생횟수 X)
// 노래 수록 기준 : plays 재생횟수 높은 장르(합을 비교) - 같은 장르의  노래 수록(재생횟수가 같으면 고유번호 낮은 노래 먼저)
// 한 장르가 선택되면 그 장르들 노래를 먼저 수록
// 장르별로 가장 많이 재생된 노래 2개만 수록
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 프로그래머스 통과 실패 풀이
 */
public class 해쉬_베스트앨범 {
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, Integer> map = new HashMap<>();
        // 1. 해쉬 추가 : <장르, play횟수 합>
        for (int i=0; i<genres.length; i++) {
            map.put( genres[i], map.getOrDefault(genres[i], 0)+plays[i]);
        }
        int[] answer = new int[map.size()*2];
        // 2. 가장 큰 value값부터 2곡씩 index 수록
        // 2-1. 큰 plays 기준 정렬 <장르, play 횟수합>
        HashMap<String, Integer> sortedMap = map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())   // 값으로정렬
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, HashMap::new));

        int max;
        int secondMaxIdx = 0;
        int maxIdx = 0;
        int answerIdx = -1;
        // 3. 정렬된 genre map 반복 돌면서 장르 내 노래들 비교. 같으면 i가 더 적은 노래를 배열에 추가
        for(String genre : sortedMap.keySet()) {
            max = Integer.MIN_VALUE;
            // 3-1. 장르 비교(같으면)
            for (int i=0; i<genres.length; i++) {
                if (genre.equals(genres[i]))
                    // 3-2. plays 크기 비교해서 2번째까지 수록
                    if (max < plays[i]) {
                        if (max != Integer.MIN_VALUE) {
                            secondMaxIdx = maxIdx;
                        }
                        max = plays[i];
                        maxIdx = i;
                    }
            }
            answer[++answerIdx] = maxIdx;
            answer[++answerIdx] = secondMaxIdx;
        }
        return answer;
    }

    public static void main(String[] args) {
//        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
//        int[] plays = {500, 600, 150, 800, 2500};
//
        해쉬_베스트앨범 k = new 해쉬_베스트앨범();
//        int[] answer = k.solution(genres, plays);
//        for (int i :
//                answer) {
//            System.out.print(i + " ");        // 4 1 3 0
//        }
        int[] result1 = k.solution(
                new String[]{"A", "A", "B", "A", "B", "B", "A", "A", "A", "A"},
                new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1});

        System.out.println(Arrays.toString(result1));
    }
}
