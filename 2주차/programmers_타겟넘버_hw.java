
public class 타겟넘버 {
    public static void main(String[] args) {
        int[] num= {1,1,1,1,1};
        int tar = 3;
        System.out.println(solution(num,tar));
    }
    public static int solution(int[] numbers, int target) {
        int answer = 0;
        answer = dfs(numbers,target, 0, 0);
        return answer;
    }
    public static int dfs(int[]numbers, int target, int depth, int sum){
        if(depth == numbers.length){
            if(target == sum){
                return 1;
            }
            return 0;
        }
        return dfs(numbers, target,depth+1,sum+numbers[depth])
                +dfs(numbers, target,depth+1,sum-numbers[depth]);
    }
}
