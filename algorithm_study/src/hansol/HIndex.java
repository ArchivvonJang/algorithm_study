package hansol;

import java.util.Arrays;

public class HIndex {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        return recSolution(citations, citations.length - 1, 0);
    }

    private int recSolution(int[] citations, int numOfRemainCitation, int h) {
        if (numOfRemainCitation < 0 || h >= citations[numOfRemainCitation]) {
            return h;
        }

        return recSolution(citations, numOfRemainCitation - 1, h + 1);
    }
}
