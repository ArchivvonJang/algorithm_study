package moon;

import java.util.Arrays;
import java.util.Comparator;

/*
1.  int[]-> String[]로 변환
2. 내림차순 정렬
3. 첫번째 자리가 0인 경우 return 0
4. String[] -> String 변환
 */
public class 정렬_가장큰수 {
    public String solution(int[] numbers) {
        String[] stringNums = new String[numbers.length];
        String answer = "";

        // 정수형 배열 -> String 배열
        for (int i = 0; i < numbers.length; i++) {
            stringNums[i] = Integer.toString(numbers[i]);   //["10","30","4","3"]
        }
        // 내림차순으로 정렬
        Arrays.sort(stringNums, new Comparator<String>() {  //   함수형 인터페이스의 함수 객체
            @Override
            public int compare(String o1, String o2) {
                return (o2 + o1).compareTo(o1 + o2);    // 내림차순
                // o1  o2
                // 30 10
                // 4   30
                // 3    4
                // 3    30
                // 3    4
            }
        });
        //  첫번째 자리가 0이면 끝
        if (stringNums[0].equals("0")) return "0";

        // 0이 아니면 String 배열 -> String으로 변환
        for (String s : stringNums) answer += s;
        return answer;
    }

    public static void main(String[] args) {
        정렬_가장큰수 k = new 정렬_가장큰수();
        int[] numbers = {10, 30, 4, 3};
        String answer = k.solution(numbers);
        System.out.println(answer);
    }
}
