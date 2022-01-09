package hansol;

public class 타겟넘버 {
    int goal, answer;
    boolean[] visit;
    int[] numbers;



    public int solution(int[] numbers, int target) {
        visit = new boolean[numbers.length];
        this.numbers = numbers;
        goal = target;

        dfs(0, 0);

        return answer;
    }

    private void dfs(int index, int sum) {
        if (index == numbers.length) {
            if (sum == goal) {
                answer++;
            }
            return;
        }

        dfs(index + 1, sum + numbers[index]);
        dfs(index + 1, sum - numbers[index]);
    }
}
