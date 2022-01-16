package hansol;

public class 단어변환_DFS {
    int requireCost;
    boolean searched;

    public int solution(String begin, String target, String[] words) {
        init();
        dfs(begin, target, words, new boolean[words.length], 0);
        return requireCost;
    }

    private void dfs(String begin, String target, String[] words, boolean[] visit, int cost) {
        if (begin.equals(target)) {
            if (!searched) {
                requireCost = cost;
                return;
            }
            requireCost = Math.min(requireCost, cost);
            return;
        }

        for (int i = 0; i < words.length; i++) {
            if (!visit[i] && changeable(begin, words[i])) {
                visit[i] = true;
                dfs(words[i], target, words, visit, cost + 1);
                visit[i] = false;
            }
        }


    }

    private boolean changeable(String source, String target) {
        for (int i = 0, count = 0; i < source.length(); i++) {
            if (source.charAt(i) != target.charAt(i) && ++count > 1) {
                return false;
            }
        }
        return true;
    }

    private void init() {
        requireCost = 0;
        searched = false;
    }
}
