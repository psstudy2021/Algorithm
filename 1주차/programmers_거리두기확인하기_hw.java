import java.util.*;

public class 거리두기확인하기_programmers_hw {
    public static void main(String[] args) {
        String[][] a = {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"}, {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"}, {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"}, {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"}, {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};
        System.out.println(solution(a));
    }
    static class Node {
        int r, c, dist;

        public Node(int r, int c, int dist) {
            this.r = r;
            this.c = c;
            this.dist = dist;
        }
    }
    static int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static int[] solution(String[][] places) {
        int[] answer = new int[places.length];

        for (int tc = 0; tc < places.length; tc++) {
            char[][] map = new char[5][5];
            for (int i = 0; i < 5; i++) {
                String str = places[tc][i];
                for (int j = 0; j < 5; j++) {
                    map[i][j] = str.charAt(j);
                }
            }
            answer[tc] = bfs(map);
        }
        for(int i =0; i<answer.length; i++){
            System.out.println(answer[i]);
        }

        return answer;
    }

    static int bfs(char[][] map){
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if(map[i][j] != 'P') continue;
                boolean[][] visited = new boolean[5][5];
                Queue<Node> que = new LinkedList<>();
                que.add(new Node(i,j,0));
                visited[i][j] = true;

                while(!que.isEmpty()){
                    Node top = que.poll();

                    for (int d = 0; d < 4; d++) {
                        int newR = top.r + dirs[d][0];
                        int newC = top.c + dirs[d][1];
                        if(isRange(newR,newC) && !visited[newR][newC] && top.dist<2){
                            if(map[newR][newC] == 'P') return 0;
                            if(map[newR][newC] == 'O'){
                                visited[newR][newC] = true;
                                que.add(new Node(newR,newC,top.dist+1));
                            }
                        }

                    }
                }
            }
        }
        return 1;
    }

    static boolean isRange(int newR, int newC) {
        if (newR >= 0 && newC >= 0 && newR < 5 && newC < 5) {
            return true;
        } else return false;
    }
}
