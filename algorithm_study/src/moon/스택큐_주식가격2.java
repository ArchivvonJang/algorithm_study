package moon;
import java.util.Arrays;
import java.util.LinkedList;

//각 숫자를 체크하면서 더 작은 수로 떨어지면 해당 idx - 자신의 idx = 떨어지지않은 기간
// 혹은 숫자를 체크하면서 유지하거나 큰수로 갈수록 +1
// 정확성&효율성 면에서 더 좋은 코드 (more than 스택큐_주식가격.java)
// 큐를 안쓰면 더 좋을 듯..
public class 스택큐_주식가격2 {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        LinkedList<Integer> qu = new LinkedList<>();
        for(Integer p : prices)
            qu.add(p);

        Integer price;
        for (int i = 0; i < prices.length; i++) {
            price = qu.poll();
            for (int j = i + 1; j < prices.length; j++) {   // 각 인덱스마다 첫자리부터 비교
                if (price <= prices[j])
                    answer[i]++;
                else {
                    answer[i] = j - i;
                    break;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        스택큐_주식가격 k = new 스택큐_주식가격();
        int[] prices = new int[]{1, 2, 3, 2, 3};
        int[] answer = k.solution(prices);
        System.out.println(Arrays.toString(answer));
    }
}