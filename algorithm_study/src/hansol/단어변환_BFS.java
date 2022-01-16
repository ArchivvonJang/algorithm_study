package hansol;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

public class 단어변환_BFS {
    private static class Node {
        String word;
        int cost;
        boolean visited;

        private Node(String word, int cost) {
            this.word = word;
            this.cost = cost;
        }

        static Node from(String word) {
            return new Node(word, 0);
        }

        boolean changeable(Node tNode) {
            String target = tNode.word;
            for (int i = 0, count = 0; i < word.length(); i++) {
                if (word.charAt(i) != target.charAt(i) && ++count > 1) {
                    return false;
                }
            }
            return true;
        }

        Node visit(int cost) {
            visited = true;
            this.cost = cost + 1;
            return this;
        }
    }


    public int solution(String begin, String target, String[] words) {
        List<Node> nodes = createNodes(words);
        Queue<Node> que = new LinkedList<>();
        Node bNode = Node.from(begin);
        que.offer(bNode);
        bNode.visited = true;

        while (!que.isEmpty()) {
            Node pNode = que.poll();

            if (target.equals(pNode.word)) {
                return pNode.cost;
            }

            for (Node node : nodes) {
                if (!node.visited && pNode.changeable(node)) {
                    que.offer(node.visit(pNode.cost));
                }
            }
        }

        return 0;
    }

    private List<Node> createNodes(String[] words) {
        return Arrays.stream(words)
                .map(Node::from)
                .collect(Collectors.toList());
    }
}
