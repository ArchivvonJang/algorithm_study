package yun;

public class 타켓넘버 {

    int[] numbers;
    int target;
    int answer = 0;

    public void dfs(int level, int sum){
        if(level == numbers.length){
            if(sum == target){
                answer++;
            }
        } else{
            dfs(level+1, sum+numbers[level]);
            dfs(level+1, sum-numbers[level]);
        }
    }

    public int solution(int[] numbers, int target){
        this.numbers = numbers;
        this.target = target;

        dfs(0, 0);

        return answer;
    }

    public static void main(String[] args) {
        타켓넘버 sol = new 타켓넘버();
        int[] numbers = {1,1,1,1,1};
        int target = 3;
        System.out.println(sol.solution(numbers, target));
    }
}
