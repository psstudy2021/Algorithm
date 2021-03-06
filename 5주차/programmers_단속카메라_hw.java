package programmers;

import java.util.*;

public class 단속카메라 {
    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{-20, 15}, {-14, -5}, {-18, -13}, {-5, -3}}));
    }

    public static int solution(int[][] routes) {
        int answer = 1;
        Arrays.sort(routes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        for (int i = 0; i < routes.length; i++) {
            System.out.println(routes[i][0] + " " + routes[i][1]);
        }
        int section = routes[0][1];

        for (int i = 1; i < routes.length - 1; i++) {
            if (section > routes[i][1]) {
                section = routes[i][1];
            }
            if (section < routes[i + 1][0]) {
                answer++;
                section = routes[i + 1][1];
            }
        }


        return answer;
    }

}
