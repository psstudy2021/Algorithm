import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 푼 날짜 : 2021-08-29
 * 푼 시간 : 20:22~
 */


//https://www.acmicpc.net/problem/14502
public class 연구소 {
    static int[][] map;
    static int[][] map2;
    static boolean[][] visited;
    static int N;
    static int M;
    static int MAX;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static List<Wall> viruses;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        viruses = new ArrayList<Wall>();
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 2) {
                    viruses.add(new Wall(i, j));
                }
            }
        }
        visited = new boolean[N][M];
        MAX = Integer.MIN_VALUE;
        map2 = map.clone();
        //벽 세우기
        makeWalls(0);
        System.out.println(MAX);

    }

    static void makeWalls(int depth){
        if(depth == 3){
            int cnt = spreadViruses();
            if(cnt > MAX) MAX = cnt;
            return;
        }
        for(int i =0; i < N ; i++){
            for(int j = 0; j < M; j++){
                if(map[i][j] == 0) {
                    map[i][j] = 1;
                    makeWalls(depth + 1);
                    map[i][j] = 0;
                }
            }
        }
    }

    static int spreadViruses(){
        Queue<Wall> q = new LinkedList();
        int[][] virusMap = deepCopy(map);
        for(Wall w : viruses){
            q.add(w);
        }
        int cnt = 0;
        while(!q.isEmpty()) {
            Wall w = q.poll();
            for (int i = 0; i < 4; i++) {
                int x = w.x + dx[i];
                int y = w.y + dy[i];
                if (x >= 0 && y >= 0 && x < N && y < M) {
                    if (virusMap[x][y] == 0) {
                        virusMap[x][y] = 2;
                        q.add(new Wall(x,y));
                    }
                }
            }
        }

        for(int i =0; i<N; i++){
            for(int j =0; j<M; j++){
                if(virusMap[i][j] == 0){
                    cnt++;
                }
            }
        }
        return cnt;

    }
    public static int[][] deepCopy(int[][] map){
        int[][] virusMap = new int[N][M];
        for(int i = 0; i < N; i++){
            for(int j =0; j<M; j++){
                int tmp = map[i][j];
                virusMap[i][j] = tmp;
            }
        }
        return virusMap;
    }


    public static class Wall{
        int x;
        int y;
        Wall(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
