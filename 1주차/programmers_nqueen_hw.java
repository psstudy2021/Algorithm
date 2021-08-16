public class programmers_nqueen_hw {
    public static void main(String[] args) {
        System.out.println(solution(4));
    }

    static int answer;
    static int[] col;

    public static int solution(int n) {
        col = new int[n];
        for (int i = 0; i < n; i++) {
            col[0] = i;
            backTracking(1, n);
        }
        return answer;
    }

    static void backTracking(int depth, int n) {
        if (depth == n) {
            answer++;
            return;
        } else {
            for (int i = 0; i < n; i++) {
                col[depth] = i;
                if (isRange(depth)) {
                    backTracking(depth + 1, n);
                } else {
                    col[depth] = 0;
                }
            }
        }
    }

    static boolean isRange(int row) {
        for (int i = 0; i < row; i++) {
            if (col[i] == col[row]) return false;
            if (Math.abs(i - row) == Math.abs(col[i] - col[row])) return false;
        }
        return true;
    }
}
