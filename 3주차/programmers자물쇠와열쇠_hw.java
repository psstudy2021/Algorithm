package solution.programmers.level3;

public class 자물쇠와열쇠_1 {
    public static void main(String[] args) {
        int[][] key = {{0, 0, 0}, {1, 0, 0}, {0, 1, 1}};
        int[][] lock = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        boolean ans = solution(key, lock);
        System.out.println(ans);
    }

    static int hole;

    public static boolean solution(int[][] key, int[][] lock) {
        boolean answer = false;
        for (int i = 0; i < lock.length; i++) {
            for (int j = 0; j < lock.length; j++) {
                if (lock[i][j] == 0) {
                    hole++;
                }
            }
        }
        for (int d = 0; d < 4; d++) {
            key = rotate(key);
            int padding = key.length - 1;
            for (int i = -padding; i < lock.length; i++) {
                for (int j = -padding; j < lock.length; j++) {
                    if (isCorrect(key, lock, i, j)) {
                        answer = true;
                    }
                }
            }
        }
        return answer;
    }

    private static boolean isCorrect(int[][] key, int[][] lock, int r, int c) {
        int cnt = 0;
        for (int i = 0; i < key.length; i++) {
            int newR = r + i;
            for (int j = 0; j < key.length; j++) {
                int newC = c + j;
                if (newR >= 0 && newR < lock.length && newC >= 0 && newC < lock.length) {
                    if (key[i][j] == 1 && lock[newR][newC] == 0) {
                        cnt++;
                    } else if (key[i][j] == 1 && lock[newR][newC] == 1) {
                        return false;
                    }
                }
            }
        }
        return cnt == hole;
    }

    private static int[][] rotate(int[][] key) {
        int[][] tmp = new int[key.length][key.length];
        for (int i = 0; i < key.length; i++) {
            for (int j = 0; j < key.length; j++) {
                tmp[j][key.length - i - 1] = key[i][j];
            }
        }
        return tmp;
    }

}
