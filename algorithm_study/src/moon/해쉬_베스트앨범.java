package moon;
// 중복 x, 같은 장르 내에서는 재생횟수 같을 수 있음(다른 장르끼리는 재생횟수 X)
// 노래 수록 기준 : plays 재생횟수 높은 장르(합을 비교) - 같은 장르의  노래 수록(재생횟수가 같으면 고유번호 낮은 노래 먼저)
// 한 장르가 선택되면 그 장르들 노래를 먼저 수록
// 장르별로 가장 많이 재생된 노래 2개만 수록
import java.util.*;
import java.util.stream.Collectors;
/**
 * 프로그래머스 통과 실패 풀이 => 수정 및 통과 완료
 */
public class 해쉬_베스트앨범 {
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, Integer> genrePlaysMap = new HashMap<>();
        int genresLength = genres.length;
        // 장르별로 playsCount 합
        for (int i = 0; i < genresLength; i++) {
            genrePlaysMap.put(genres[i], genrePlaysMap.getOrDefault(genres[i], 0) + plays[i]);
        }
        // playsCount 순으로 내림차순 정렬
        HashMap<String, Integer> sortedGenrePlaysMap = genrePlaysMap.entrySet().stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))   // 값으로 내림차순정렬
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, HashMap::new));
        // 위의 로직으로 3개 빼고 테스트 실패

        List<String> genresArr = new ArrayList<>(genrePlaysMap.keySet());
        Collections.sort(genresArr, (p1, p2) -> genrePlaysMap.get(p2).compareTo(genrePlaysMap.get(p1)));    // 내림차순

        System.out.println(sortedGenrePlaysMap.entrySet());
        // 장르별로 상위 2곡의 index를 추출
        int max;
        int firstIdx;
        int secondIdx;
        List<Integer> answer = new ArrayList<>();
        for (String genre : sortedGenrePlaysMap.keySet()) {
            max = -1;
            firstIdx = -1;
            secondIdx = -1;

            for (int i = 0; i < genresLength; i++) {
                // 1번째 곡
                if (genre.equals(genres[i])) {
                    if (plays[i] > max) {
                        max = plays[i];
                        firstIdx = i;
                    }
                }
            }
            if (firstIdx != -1)
                answer.add(firstIdx);

            // 2번째 곡
            max = -1;
            for (int i = 0; i < genresLength; i++) {
                if (genre.equals(genres[i])) {
                    if (plays[i] > max && i != firstIdx) {
                        max = plays[i];
                        secondIdx = i;
                    }
                }
            }
            if (secondIdx != -1)    // secondIdx는 없을 수 있음.
                answer.add(secondIdx);
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();   // List<Integer> -> int 값 -> array
    }

    public static void main(String[] args) {
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};

        해쉬_베스트앨범 k = new 해쉬_베스트앨범();
        int[] answer = k.solution(genres, plays);
        System.out.println(Arrays.toString(answer));// 4,1,3,0
        int[] result1 = k.solution(
                new String[]{"A", "A", "B", "A", "B", "B", "A", "A", "A", "A"},
                new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1});

        System.out.println(Arrays.toString(result1));   // 0,1,2,4
    }
}
