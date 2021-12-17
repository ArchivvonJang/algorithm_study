package moon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 배열 변경 불가 -> 리스트로 변환하는 방법 택함..
1. commands의 1차원 배열만큼 돌면서
2. 2차원 배열의 i, j를 받아서 자르기 및 정렬
3. List<Integer> -> int[]
*/
public class 정렬_K번째수 {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer;
        List<Integer> list = new ArrayList<>();

        // 1.
        for (int a = 0; a<commands.length; a++) {
            // 2.
            int[] first = Arrays.copyOfRange(array, commands[a][0]-1, commands[a][1]);
            Arrays.sort(first);
            list.add(first[commands[a][2]-1]);
        }
        // 3.
        answer = list.stream().mapToInt(i->i).toArray();
        return answer;
    }

    public static void main(String[] args) {
        정렬_K번째수 k = new 정렬_K번째수();
        long time1 = System.currentTimeMillis();

        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};

        int[] s = k.solution(array, commands);
        System.out.println( (System.currentTimeMillis() - time1) / 1000.0 );  // 0.003
    }
}
