import java.util.ArrayList;
import java.util.List;

/**
 * 푼 날짜 : 21-08-19~20
 * 소요 시간 : 15:30~17:00 멈춤 (개어려워), 11:00~11:30. 13:30~15:00 = 4h 30min
 */
//https://programmers.co.kr/learn/courses/30/lessons/81302
    //
public class 거리두기확인하기 {
    public static void main(String[] args){
        거리두기확인하기 r = new 거리두기확인하기();
        String[][] places = {{"PPXXX", "XXXXX", "XXXXX", "XXXXX", "XXXXX"}};
        int[] result = r.solution(places);
        for(int i : result){
            System.out.print(i +" ");
        }
        System.out.println();
    }
    static char[][] map;
    static int[] dirX = {0, 0, -1, 1}; //오,왼,위,아래
    static int[] dirY = {1, -1, 0, 0};

    static int[] diagX = {-1, -1, 1, 1}; //대각선 위오 위왼 아래오 아래왼
    static int[] diagY = {-1, 1, -1, 1};

    public int[] solution(String[][] places) {
        int[] result = new int[places.length];
        map = new char[5][5];
        //for(String[] place : places){
        for(int p=0; p<places.length; p++){
            List<int[]> participants = new ArrayList<>();
            for(int i=0; i<5; i++){
                for(int j=0; j<5; j++){
                    char[] tmp = places[p][i].toCharArray();
                    map[i][j] = tmp[j];
                    if (tmp[j] == 'P') {
                        participants.add(new int[]{i, j});
                    }
                }
            }
            result[p] = checkParticipants(participants);
        }
        return result;
    }

    public int checkParticipants(List<int[]> participants){
        int result = 1;
        //맨하튼 거리 안에 응시자 있는지 확인
        for(int[] participant : participants) {
            //오,왼,위,아래 확인하기
            int x = participant[0];
            int y = participant[1];
            while (result==1) {
                for(int dir = 0; dir < 4; dir++) {
                    int dx = x + dirX[dir];
                    int dy = y + dirY[dir];

                    if(dx <5 && dy < 5 && dy>= 0 && dx >= 0 ) {
                        if (map[dx][dy] == 'O')
                        { //오른쪽이 'O'이면 그다음 오른쪽이 'P'인지 확인
                            dy += dirY[dir];
                            dx += dirX[dir];
                            if (dx < 5 && dy < 5 && dy >= 0 && dx >= 0 && map[dx][dy] == 'P') {
                                result = 0;
                            }
                        }else if (map[dx][dy] == 'P') {
                            result = 0;
                        }
                    }
                }

                for(int diag = 0; diag<4; diag++){
                    int dx = x + diagX[diag];
                    int dy = y + diagY[diag];
                    if(dx <5 && dy < 5 && dy>= 0 && dx >= 0 && map[dx][dy] == 'P'){
                        if(map[x][dy] != 'X' || map[dx][y] != 'X'){
                            result = 0;
                        }
                    }
                }


                break;
            }
        }

        return result;
    }


}
