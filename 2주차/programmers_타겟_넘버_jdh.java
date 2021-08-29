/*
    풀이 시간: 10분
    풀이 방법: DFS 탐색 이용
*/

class programmers_타겟_넘버_jdh {
    public static int answer;
    
    public int solution(int[] numbers, int target) {
        dfs(0, 0, numbers, target);
        return answer;
    }
    
    public static void dfs(int cnt, int sum, int numbers[], int target){
        if(cnt == numbers.length){
            if(sum == target) answer++;
            return;
        }

        dfs(cnt + 1, sum + numbers[cnt], numbers, target);
        dfs(cnt + 1, sum - numbers[cnt], numbers, target);
    }
}
