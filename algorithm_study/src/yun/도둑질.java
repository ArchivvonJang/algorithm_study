package yun;

public class 도둑질 {
	public int solution(int[] money) {
        int answer = 0;
        int t = money.length;
        int[] dp1 = new int[money.length-1];//첫번째 집 o, 마지막 집 x
        int[] dp2 = new int[money.length];//첫번째 집 x, 마지막 집 o
        
        dp1[0] = money[0];
        dp1[1] = money[0];
        
        dp2[0] = 0;
        dp2[1] = money[1];
        
        for(int i=2; i<dp1.length; i++) {
        	dp1[i] = Math.max(dp1[i-2] + money[i], dp1[i-1]);
        }
        
        for(int i=2; i<dp2.length; i++) {
        	dp2[i] = Math.max(dp2[i-2] + money[i], dp2[i-1]);
        }
        
        answer = Math.max(dp1[dp1.length-1], dp2[dp2.length-1]);
        
        return answer;
    }

	public static void main(String[] args) {	
		도둑질 a = new 도둑질();
		System.out.println(a.solution(new int[] {1,2,3,1}));
	}

}
