
public class 네트워크 {
    public static void main(String[] args) {
        int[][]arr= {{1,1,0},{1,1,1},{0,1,1}};
        System.out.println(solution(3,arr));
    }
    static boolean[][]visited;
    public static int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n][n];
        for(int i =0; i<n; i++){
            if(!visited[i][i]){
                dfs(n, i, computers);
                answer++;
            }
        }

        return answer;
    }
    static void dfs(int n, int start, int[][]computers){
        for(int i =0; i<n; i++){
            if(computers[start][i]==1 && !visited[start][i]){
                visited[start][i]=true;
                dfs(n,i,computers);
            }
        }
    }


}
