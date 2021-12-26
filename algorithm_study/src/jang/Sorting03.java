
package jang;

import java.util.Arrays;

// 정렬 - H-Index
public class Sorting03 {
    //citations중 인용횟수가 가장큰값부터 검사한다. 인용횟수와 논문갯수가 같아지면 return
    //인용 횟수는 감소하고 인용 횟수가 더 많은 논문의 개수는 증가한다.
    //따라서 h은 점점 감소하게 되는데 가장 큰 값이 되었을 때의 h값인 max가 h의 최댓값이다.
    public int solution(int[] citations) {
        int answer = 0;

        // 빠른 정렬을 위해 오름차순으로 정렬한다.
        Arrays.sort(citations);

        // 인용횟수 담은 배열의 길이
        int len = citations.length;
        // 인용횟수를 담을 변수
        int h = 0;
        // 인용된 논문갯수를 담을 변수 : 전체 논문을 확인하면서 가장 큰 h
        int max = 0;
        //가장 큰 인용 횟수부터 차례대로 확인하면서 최댓값을 찾는다. (내림차순)
        for(int i = len-1; i > -1; i--){
            //Math.h(a,b) : 입력받은 값 중 작은 값을 반환한다.
            h = (int)Math.min(citations[i], citations.length - i);

            // h번 인용된 논문이 h편이고 나머지 논문이 h번 이하 인용
            //max 되었을 때의 h값인 max가 h의 최댓값
            if(max < h)
                max = h; //논문 중 인용 횟수가 많은 논문의 개수
        }

        answer = max;
        return answer;

    }

}
