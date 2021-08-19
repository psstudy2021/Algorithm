
/**
 * 푼 날짜 : 21-08-18
 * 소요 시간 : 음.. 혼자 못풀어서 유투브 강의봤음
 */
//https://programmers.co.kr/learn/courses/30/lessons/12952
public class NQueen {
    /*
    퀸(Queen)은 가로, 세로, 대각선으로 이동할 수 있습니다.
    n은 12이하의 자연수 입니다.
     */
    public static void main(String[] args){
        NQueen nq = new NQueen();
        System.out.println(nq.solution(4));
    }
    static int count;
    static int[] map;
    public int solution(int n){
        map = new int[n+1];
        queen(0, n);
        return count;
    }
    public static void queen(int i, int n){
        if(promising(i)){
            if(i == n) {
                count++;
            }else {
                for(int j=0; j < n; j++){
                    map[i+1] = j;
                    queen(i+1, n);
                }
            }
        }

    }
    public static boolean promising(int i){
        int k = 1;
        //boolean flag = true;
        while(k < i ){ //k<=i 가 안되는 이유는 같은 row에 있을 때는 비교할 필요가 없다, k>i가 안되는 이유는 그 다음 줄을 미리 비교하면 안된다.
            if(map[i] == map[k] || Math.abs(map[i]-map[k]) == i-k){ //map[i],map[k] 안의 정보는 column 정보, i와 k는 row 정보
                return false;
            }
            k++;
        }
        return true;

    }
}
