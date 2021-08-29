
import java.io.*;
import java.util.*;

public class 연구소 {

    static class Node {
        int r, c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static int N;
    static int M;
    static boolean[][] visited;
    static int[][] map;
    static int[][] copyMap;
    static ArrayList<Node> list;
    static Queue<Node> que;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        br = new BufferedReader(new StringReader(src));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        copyMap = new int[N][M];
        visited = new boolean[N + 1][M + 1];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        list = new ArrayList<Node>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 2) {
                    list.add(new Node(i, j));
                }

            }
        }
        combination(0);

        System.out.println(max);
    }

    public static void combination(int depth) {
        if (depth == 3) {
            copyMap = deepCopy(map);
            BFS();
        } else {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] == 0 && !visited[i][j]) {
                        map[i][j] = 1;
                        visited[i][j] = true;
                        combination(depth + 1);
                        map[i][j] = 0;
                        visited[i][j] = false;
                    }
                }
            }
        }
    }

    public static int[][] deepCopy(int[][] original) {
        int[][] arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            System.arraycopy(original[i], 0, arr[i], 0, original[i].length);
        }
        return arr;
    }

    public static void BFS() {
        que = new LinkedList<>();
        for (int i = 0; i < list.size(); i++) {
            que.offer(list.get(i));
        }
        while (!que.isEmpty()) {
            Node top = que.poll();
            copyMap[top.r][top.c] = 2;

            for (int d = 0; d < dir.length; d++) {
                int newR = top.r + dir[d][0];
                int newC = top.c + dir[d][1];

                if (isRange(newR, newC) && copyMap[newR][newC] == 0) {
                    que.offer(new Node(newR, newC));
                }
            }

        }
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (copyMap[i][j] == 0) {
                    cnt++;
                }
            }
        }
        max = Math.max(max, cnt);
    }

    public static boolean isRange(int newR, int newC) {
        return newR >= 0 && newC >= 0 && newR < N && newC < M;
    }

    static String src = "7 7\n" +
            "2 0 0 0 1 1 0\n" +
            "0 0 1 0 1 2 0\n" +
            "0 1 1 0 1 0 0\n" +
            "0 1 0 0 0 0 0\n" +
            "0 0 0 0 0 1 1\n" +
            "0 1 0 0 0 0 0\n" +
            "0 1 0 0 0 0 0";
}
