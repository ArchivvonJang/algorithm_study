package yun;

public class 단어변환 {
	int answer = 0;
	boolean[] visited;
	
	public int solution(String begin, String target, String[] words) {
		visited = new boolean[words.length];
		
		dfs(begin, target, words, 0);
		
		return answer;
	}
	
	public void dfs(String begin, String target, String[] words, int count) {
		if(begin.equals(target)) {
			answer = count;
			return;
		}
		for(int i=0; i<words.length; i++) {
//			System.out.println(begin+"//////"+words[i]+"++++"+wordCheck(begin, words[i])); 
			if(wordCheck(begin, words[i]) && !visited[i]) {
				visited[i] = true;
				dfs(words[i], target, words, count+1);
				visited[i] = false;
			}
		}
	}
	
	public boolean wordCheck(String begin, String word) {
		int idx = 0;
		for(int i=0; i<begin.length(); i++) {
			if(begin.charAt(i) != word.charAt(i)) {
				idx++;
			}
		}
		return idx == 1 ? true : false;
	}
	
	public static void main(String[] args) {
		단어변환 sol = new 단어변환();
		String begin = "hit";
		String target = "cog";
		String[] words = {"hot","dot","dog","lot","log","cog"};
		System.out.println(sol.solution(begin, target, words));
	}
}
