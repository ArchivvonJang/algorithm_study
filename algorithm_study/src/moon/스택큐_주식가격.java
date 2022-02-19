package moon;
import java.util.Arrays;
import java.util.LinkedList;

//각 숫자를 체크하면서 더 작은 수로 떨어지면 해당 idx - 자신의 idx = 떨어지지않은 기간
// 혹은 숫자를 체크하면서 유지하거나 큰수로 갈수록 +1
// Stock 클래스 : price, term
public class 스택큐_주식가격 {
    static class Stock implements Comparable<Stock> {
        private int price;
        private int term;
        private int idx;

        public Stock(int price, int idx) {
            this.price = price;
            this.term = 0;  // 처음엔 0초
            this.idx = idx;
        }
        @Override
        public int compareTo(Stock s) {
            return this.idx - s.idx;
        }
    }
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        LinkedList<Stock> qu = new LinkedList<>();
        for (int i=0; i< prices.length; i++) {
            qu.add(new Stock(prices[i], i));
        }
        Stock comparedStock;
        for (int i = 0; i < prices.length; i++) {
            comparedStock = qu.poll();
            for (int j = i + 1; j < prices.length; j++) {   // 각 인덱스마다 첫자리부터 비교
                if (comparedStock.price <= prices[j])
                    comparedStock.term++;
                else {
                    comparedStock.term = j - comparedStock.idx;
                    break;
                }
            }
            answer[i] = comparedStock.term;
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