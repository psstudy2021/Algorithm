package psstudy2021;

/*
    풀이 시간: 30분
    풀이 방법:
            - 첫 번째 행의 열의 위치에 따라 나머지 행들의 위치가 결정됨.
            - 이때 현재 놓으려는 행의 퀸의 위치는 이전에 놓았던 다른 행들의 퀸의 위치와 관계를 고려해야함.
            - 현재 놓으려는 행의 퀸의 위치가 이전에 놓았던 다른 행들의 퀸의 위치와 같은 열에 속하면 안되며,
              대각선 상에도 위치해서는 안됨.
            - 위와 같은 규칙을 통해서 불가능한 위치에 놓은 경우 백트래킹을 통해 다음 경우의 수를 탐색함.
 */

public class programmers_n_queen_jdh {
    public static int answer, col[];

    public static int solution(int n) {

        for(int i = 0; i < n; i++){
            col = new int[n];
            col[0] = i;

            backTracking(1, n);
        }

        return answer;
    }

    public static void backTracking(int row, int N){
        // 가장 마지막행까지 처리되는 경우 answer 증가
        if(row == N) {
            answer++;
            col[row - 1] = 0;
            return;
        }

        for(int i = 0; i < N; i++) {
            col[row] = i;
            if(isPossible(row))
                backTracking( row + 1, N);
        }
    }

    public static boolean isPossible(int row){
        for(int i = 0; i < row; i++) {
            // 같은 열에 있으면 false
            if(col[i] == col[row])
                return false;

            // 대각선에 있으면 false
            if(Math.abs(i - row) == Math.abs(col[i] - col[row]))
                return false;
        }

        return true;
    }

    public static void main(String args[]){
        System.out.println(solution(4));
    }
}
