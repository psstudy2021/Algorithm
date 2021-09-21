package programmers;

import java.util.*;

public class 단어변환 {
    public static void main(String[] args) {
        System.out.println(solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log", "cog"}));
    }

    static class Node {
        String next;
        int cnt;

        public Node(String next, int cnt) {
            this.next = next;
            this.cnt = cnt;
        }
    }

    public static int solution(String begin, String target, String[] words) {
        int answer = 0;
        Queue<Node> que = new LinkedList<>();
        boolean[] visited = new boolean[words.length];
        que.offer(new Node(begin, 0));
        while (!que.isEmpty()) {
            Node top = que.poll();
            if (top.next.equals(target)) {
                answer = top.cnt;
                break;
            }
            for (int i = 0; i < words.length; i++) {
                if (!visited[i] && isCorrect(top.next, words[i])) {
                    visited[i] = true;
                    que.offer(new Node(words[i], top.cnt + 1));
                }
            }
        }
        return answer;
    }

    static boolean isCorrect(String before, String next) {
        int cnt=0;
        for (int i = 0; i < next.length(); i++){
            if(before.charAt(i) != next.charAt(i)){
                cnt++;//다른개 2개이상이면 부정
            }
        }
        if(cnt>1) return false;
        return true;
    }

}
