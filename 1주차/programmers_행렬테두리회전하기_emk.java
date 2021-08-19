/**
 * 푼 날짜 : 21-08-19
 * 소요 시간 : 음... 이틀...?
 */
//https://programmers.co.kr/learn/courses/30/lessons/77485
public class 행렬테두리회전하기 {
    public static void main(String[] args) {
        행렬테두리회전하기 g = new 행렬테두리회전하기();
        //int[][] queries = {{2, 2, 5, 4}, {3, 3, 6, 6}, {5, 1, 6, 3}}; //6,6 [8,10,25]
        //int[][] queries = {{1, 1, 2, 2}, {1, 2, 2, 3}, {2, 1, 3, 2}, {2, 2, 3, 3}}; //3,3 [1,1,5,3]
        int[][] queries = {{1,1,100,97}}; //100, 97 [1]
        int[] result = g.solution(100, 97, queries);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }
    public int[] solution(int rows, int columns, int[][] queries){
        //[x1,y1,x2,y2]
        int[] result = new int[queries.length];
        //map 만들기
        int[][] map = new int[rows+1][columns+1];
        int num = 0;
        for(int i=1; i<=rows; i++){
            for(int j=1; j<=columns; j++){
                map[i][j] = num+1;
                num++;
            }
        }

        int before = 0;
        int next = 0;

        for(int q=0; q<queries.length; q++) {
            int min = Integer.MAX_VALUE;
            for (int i = queries[q][1]; i < queries[q][3]; i++) { //[2,2] --> 2,3 [2,3]
                next = map[queries[q][0]][i];
                if (i == queries[q][1]) {
                    map[queries[q][0]][i] = map[queries[q][0] + 1][i];
                } else {
                    map[queries[q][0]][i] = before;
                }
                before = next;
                if (next < min) min = next;
            }
            for (int i = queries[q][0]; i < queries[q][2]; i++) { //[2,4] --> [5,4]
                next = map[i][queries[q][3]];
                map[i][queries[q][3]] = before;
                before = next;
                if (next < min) min = next;
            }
            for(int i = queries[q][3]; i>queries[q][1]; i-- ) { //[5,4] --> [5,3],[5,2]
                next = map[queries[q][2]][i];
                map[queries[q][2]][i] = before;
                before = next;
                if (next < min) min = next;
            }

            for(int i = queries[q][2]; i>queries[q][0]; i-- ) { //[5,2] --> [4,2],[3,2][[2,2]
                next = map[i][queries[q][1]];
                map[i][queries[q][1]] = before;
                before = next;
                if (next < min) min = next;
            }
            result[q] = min;

        }
        return result;

    }
}
