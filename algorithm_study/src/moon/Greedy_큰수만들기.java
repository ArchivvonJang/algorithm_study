package moon;

// 참조 : 지우는 방식으로 생각하면 안되고, 큰 값을 추가하는 방식으로 진행해야 한다.
// 4177252841
// 앞에서부터 탐색하는데, 뒤에 더 붙여야할 5자리를 남기고 최댓값 탐색 -> 41772 중에 7 (4,1 제거)
// 그 뒤인덱스부터 탐색하는데, 뒤에 더 붙여야할 4자리 남기고 최댓값 탐색 -> 725 중에 7
// 동일.. 3자리남기고탐색 -> 252 중에 5 (2 제거)
// 동일.. 2자리남기고 탐색 -> 28 중에 8 (2 제거)
// 동일.. 1자리 남기고 탐색 -> 4 중에 4
// 0자리 남기고 탐색 -> 1중에 1
// 775841
public class Greedy_큰수만들기 {
    public String solution(String number, int k) {
        int ansLength = number.length() - k;    // k개를 제거한 문자열이 정답
        StringBuilder ans = new StringBuilder();
        int maxIdx = 0;
        // 구해야하는 길이만큼 반복문을 돌면서 최댓값을 하나씩 추가
        for (int i = 1; i <= ansLength; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = 0; j < number.length() - (ansLength - i); j++) {  // 남겨놔야하는 자릿수만큼을 뺀 길이값까지 돌면서 max값 찾기
                // 만약 숫자가 9이면 그게 바로 최댓값
                if (number.charAt(j) - '0' == 9) {
                    max = 9;
                    maxIdx = j;
                    break;
                }
                if (max < (number.charAt(j) - '0')) {
                    max = number.charAt(j) - '0';
                    maxIdx = j;
                }
            }
            ans.append(max);
            number = number.substring(maxIdx + 1, number.length());
        }
        return ans.toString();
    }

// 내 생각
// 앞에있는 값부터 지워나가되 최댓값보다 작으면서 가장 최소의 값부터 지운다.
        //1제거 -> 477252841
        // 4 제거 : 77252841
        // 2 제거 : 7752841
        // 2 제거: 775841
        // 47752841
        // 뒤에있는 값보다 작으면 제거
        /* 정확도 통과X
        List<Integer> numberList = new LinkedList<>();
        for (int i=0; i< number.length(); i++) {
            int n = Integer.parseInt(String.valueOf(number.charAt(i)));
            numberList.add(n);
        }
        int cnt=0;
        int idx = 0;
        while (cnt<k) {
            if (numberList.get(idx) < numberList.get(idx+1)) {
                numberList.remove(idx);
                cnt++;
                idx = 0;
            }
            else {
                idx++;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int n: numberList) sb.append(n);
        return sb.toString();
    }*/
}
