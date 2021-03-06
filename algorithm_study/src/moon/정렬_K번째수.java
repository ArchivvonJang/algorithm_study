package moon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
1. commands의 1차원 배열만큼 돌면서
2. 2차원 배열의 i, j를 받아서 자르기 및 정렬
3. List<Integer> -> int[]
*/
public class 정렬_K번째수 {
    public int[] solution(int[] array, int[][] commands) {
        /* 1번째 풀이
        int[] answer;
        List<Integer> list = new ArrayList<>();

        // 1.
        for (int a = 0; a<commands.length; a++) {
            // 2.
            int[] arrRange = Arrays.copyOfRange(array, commands[a][0]-1, commands[a][1]);
            Arrays.sort(arrRange);
            list.add(arrRange[commands[a][2]-1]);
        }
        // 3.
        answer = list.stream().mapToInt(i->i).toArray();
        return answer;
    }*/

    /* 2번째 풀이 - stream()을 알아보면서 3번이 아닌 2번에서 사용할 수 있겠다 생각하게 됨. */
        int[] answer = new int[commands.length];
        List<Integer> list = new ArrayList<>();
        // 1.
        for (int a = 0; a<commands.length; a++) {
            // 2.
            int[] sortedArr = Arrays.stream(array, commands[a][0]-1, commands[a][1])
                    .sorted()
                    .toArray();
            answer[a] = (sortedArr[commands[a][2]-1]);
        }
        // 3.
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
