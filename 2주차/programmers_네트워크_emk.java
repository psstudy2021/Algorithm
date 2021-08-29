
/**
 * 푼 날짜 : 2021-08-27
 * 푼 시간 : 까먹고 안쟀네..
 */

//https://programmers.co.kr/learn/courses/30/lessons/43162
public class 네트워크 {
    public static void main(String[] args) {
        네트워크 n = new 네트워크();
        int[][] computers = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}; //2
        //int[][] computers = {{1, 1, 0, 1}, {1, 1, 0, 0}, {0, 0, 1, 1}, {1, 0, 1, 1}}; //1
        System.out.println(n.solution(3, computers));

    }

    public int solution(int n, int[][] computers) {
        /*
        * 1. n 갯수만큼 boolean 배열(visited) 을 만든다.
        * 2. visited[i] = false 이면 dfs 메소드를 호출하고 result + 1 한다.
        * */
        boolean[] visited = new boolean[n];
        int result = 0;
        for(int i = 0; i < n; i++){
            if(!visited[i]){
                //visited[i] = true;
                dfs(computers, i, visited);
                result++;
            }
        }

        return result;

    }

    public void dfs(int[][] computers, int i, boolean[] visited) {
        /*
         * 1. n 길이만큼 for문을 돌린다.
         * 2. 자기 자신이 아니고, 값이 1 이면 dfs 메소드를 재귀 호출한다.

         */
        visited[i] = true;
            for (int j = 0; j < computers.length; j++) {
                if (i != j && !visited[j] && computers[i][j] == 1) {

                    dfs(computers, j, visited);
                }
            }

        return;
    }

}

