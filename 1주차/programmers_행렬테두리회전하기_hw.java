
public class programmers_행렬테두리회전하기_hw {
    public static void main(String[] args) {
        System.out.println(solution(6, 6, new int[][]{{2, 2, 5, 4}, {3, 3, 6, 6}, {5, 1, 6, 3}}));
    }

    static int[][] map;
    static int min;

    public static int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        map = new int[rows + 1][columns + 1];
        int cnt = 1;
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= columns; j++) {
                map[i][j] = cnt++;
            }
        }
        for (int tc = 0; tc < queries.length; tc++) {
            min = Integer.MAX_VALUE;
            rotation(queries[tc]);
            answer[tc] = min;
        }
        return answer;
    }

    static void rotation(int[] queries) {
        int r = queries[0];
        int c = queries[1];
        int h = queries[2] - queries[0];
        int w = queries[3] - queries[1];
        int cur = map[r][c];
        for (int i = 0; i < w; i++) {
            c++;
            cur = move(r, c, cur);
        }

        for (int i = 0; i < h; i++) {
            r++;
            cur = move(r, c, cur);
        }
        for (int i = 0; i < w; i++) {
            c--;
            cur = move(r, c, cur);
        }
        for (int i = 0; i < h; i++) {
            r--;
            cur = move(r, c, cur);
        }
    }

    static int move(int r, int c, int cur) {
        int tmp = map[r][c];
        min = Math.min(min, tmp);
        map[r][c] = cur;
        return tmp;
    }
}
