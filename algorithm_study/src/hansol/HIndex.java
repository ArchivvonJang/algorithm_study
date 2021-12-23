import java.util.Arrays;

public class HIndex {
   public int solution(int[] citations) {
        Arrays.sort(citations);
        return rec_func(citations, citations.length - 1, 0);
    }

    private int rec_func(int[] citations, int h, int answer) {
        if (h < 0 || citations.length - h > citations[h]) {
            return answer;
        }

        return rec_func(citations, h - 1, answer + 1);
    }
}
