package moon;
import java.util.Arrays;
import java.util.Comparator;
// 내림차순 정렬
// 중복 o

/*
1.  int[]-> String[]로 변환
2. 내림차순 정렬          => a.compareTo(b) 메서드 : 앞에서부터 비교하다 다른 문자열이 나오면 'a-b' 순서로 해당 문자의 아스키코드 값을 뺀 결과(int)를 리턴
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
                return (o2 + o1).compareTo(o1 + o2);    // 내림차순 : 아스키코드를 비교. o2+o1이 더 클 때 자리 exchange
                // o1  o2
                // 30 10
                // 4   30
                // 3    4
                // 3    30
                // 3    4
            }
        });
        // 모두 0일 경우("000") :  첫번째 자리가 0이면 0을 한개만 리턴하도록
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

/* CHECK
- for 반복문 돌릴 시, 문자열 결합하면서(o2+o1) 새 인스턴스가 생성되어 비용이 발생하므로 StringBuilder를 사용해서 효율 ↑
- Arrays.sort()와 Collections.sort() 차이는 없다. 사용 주체만 다를 뿐, 모두 퀵정렬 사용하여 시간 복잡도가 동일하다.
 */