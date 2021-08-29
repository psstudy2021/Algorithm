//https://programmers.co.kr/learn/courses/30/lessons/43165

/**
 * 푼 날짜 : 2021-08-24
 * 푼 시간 : 15:00 ~
 */
public class 타겟넘버 {
    public static void main(String[] args){
        타겟넘버 t = new 타겟넘버();
        int[] numbers = {1, 1};
        int target = 1;
        System.out.println(t.solution(numbers, target));
    }
    public int solution(int[] numbers, int target){
        /*
        * 1. for문을 numbers.length까지 돌린다.
        * 2. BFS를 호출 한다.
        * */
        int result = 0;

        result = bfs(numbers, target, numbers[0], 1) + bfs(numbers, target, -numbers[0], 1);


        return result;

    }
    public int bfs(int[] numbers, int target, int total, int index){

        if(index == numbers.length){
            if(total == target){
                return 1;
            } else {
                return 0;
            }
        }

        int result = 0;
        result += bfs(numbers, target, total + numbers[index], index + 1);
        result += bfs(numbers, target, total - numbers[index], index + 1);
        return result;
    }


}
