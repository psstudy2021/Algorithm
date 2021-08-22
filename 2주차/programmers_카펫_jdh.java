package psstudy2021;

import java.util.Arrays;

/*
    풀이시간: 10분
    풀이 방법:
            - brown의 열의 길이를 하나씩 증가하면서 brown의 행 길이를 계산
            - brown의 행 길이를 이용해서 yellow의 열 길이 계산
            - 딱 맞아떨어지면 가능한 경우이므로 return할 배열에 길이 넣고 종료
 */

public class programmers_카펫_jdh {
        public static int[] solution(int brown, int yellow) {
            int answer[] = new int[2];

            for(int i = 3; i < brown / 2; i++){
                int leftBrown = brown - (i * 2); // i는 행의 길이 * 2 ==> brown의 두 개의 행 길이의 합
                int brownRow = leftBrown / 2; // 남은 brown 수 / 2 ==> brown의 두 개의 열 길이의 합
                int yellowCol = yellow % brownRow == 0 ?  yellow / brownRow : 0;

                if(yellowCol == i - 2) {
                    answer[0] = brownRow + 2;
                    answer[1] = i;
                    break;
                }
             }
            return answer;
        }

    public static void main(String args[]){
        System.out.println(Arrays.toString(solution(24, 24)));
    }
}
