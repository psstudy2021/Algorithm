import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/1011

/**
 * 푼 날짜 : 2021-08-22-23
 * 푼 시간 : 21:05 ~ 21:40, 22:00~23:30, 10:30~11:20 거의 3h??
 */
public class FlymetotheAlphaCentauri {
    static int caseNum;
    static int[][] cases;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        caseNum = Integer.parseInt(st.nextToken());
        cases = new int[caseNum][2];
        for(int i = 0; i< cases.length; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<2; j++){
                cases[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int[] testCase : cases){
            System.out.println(solution(testCase));

        }

    }
    public static int solution(int[] testCase){
        int dist = testCase[1] - testCase[0];

        int max = (int) Math.sqrt(dist);

        if(max == Math.sqrt(dist)) { //제곱근이 정확히 떨어질 때
            return max*2-1;
        } else if(dist <= (max*max)+max){
            return max*2;
        } else {
            return max*2+1;
        }

    }
}
