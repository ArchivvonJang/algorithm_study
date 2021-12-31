package moon;

import java.util.Arrays;
// 각 원소 : 각 논문의 인용 횟수
// 전체 길이 : 논문 편수
//  발표한 논문 n편 중, 논문 인용 횟수가 h번 이상인 논문들이 h개 이상. 그중 최대값이 h-Index

public class 정렬_HIndex {
    public int solution(int[] citations) {
        /*
        int answer = 0;
        Arrays.sort(citations);        // [0, 1, 3, 5, 6]
        int h;
        // 오름차순 정렬했으니까 앞에 있는 것보다 뒤에있는 논문이 당연히 더 많은 횟수로 인용된 것이므로 논문 인용 횟수를 생각&비교할 필요가 없어진다.
        // i    citations[i]      h (논문 편수)
        // 0        0               5-0=5 : 0편 이상 인용된 논문 5개
        // 1         1                5-1 =4
        // 2        3                5-2 =3
        //  논문 인용횟수가 h번 이상이어야 한다. 즉 h번 이상 인용된 논문이 h편 이상이어야함
        for (int i=0; i < citations.length; i++) {
            h = citations.length-i;  // 편 수
            if (citations[i]>=h) {      // 이 if문 하나로 논문 인용 횟수 citations[i] 가 h 이상인 논문 h편 이상? 인지만 비교하면
                answer = h;      // h의 최댓값
                break;
            }
        }
        return answer;*/

        // 첫번째 시도. test 16제외 실패..
        // citaions 오름차순 정렬 -> 앞에서부터 하나씩 자신을 포함한 원소 갯수가 자신이랑 같은값들

        int citationsSize = citations.length;
        int numCitations = 1;   // n번 이상 인용된 논문의 횟수 구할 때 자기 자신은 비교 필요없이 항상 포함이니까
        int answer = 0;
        Arrays.sort(citations);
        for (int i=0; i<citationsSize; i++) {
            for (int j= i+1; j<citationsSize; j++) {
                if (citations[i] <= citations[j])
                    numCitations++;
            }
            if (citations[i] == numCitations)
                answer = citations[i];
            numCitations = 1;
        }
           return answer;
    }
    public static void main(String[] args) {
        정렬_HIndex k = new 정렬_HIndex();
        int answer = k.solution(new int[]{4, 5, 6, 0, 1, 2, 10});  //3, 0, 6, 1, 5
        System.out.println(answer);
    }
}