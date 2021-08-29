import java.util.*;

/*
    풀이 시간: 20분
    풀이 방법: BFS 탐색 이용
*/

class programmers_네트워크_jdh {
    public static int N;
    public static boolean visited[];

    public static int solution(int n, int[][] computers) {
        int answer = 0;
        N = n;
        visited = new boolean[N];

        for(int i = 0; i < N; i++){
            if(visited[i]) continue;
            bfs(i, computers);
            answer++;
        }
        return answer;
    }

    public static void bfs(int n, int computers[][]){
        Queue<Integer> q = new LinkedList<Integer>();
        q.offer(n);
        visited[n] = true;

        while(!q.isEmpty()){
            Integer cur = q.poll();

            for(int i = 0; i < N; i++){
                if(visited[i]) continue;
                if(computers[cur][i] != 1) continue;
                q.offer(i);
                visited[i] = true;
            }
        }
    }
}
