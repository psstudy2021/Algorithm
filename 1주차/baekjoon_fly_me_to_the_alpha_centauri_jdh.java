package psstudy2021;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon_fly_me_to_the_alpha_centauri_jdh {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++) {
            String input[] = br.readLine().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);

            int dist = y - x;
            int mid = (int) Math.sqrt(dist); // 이동 거리 중 가장 높은 수(가운데)

            if(mid == Math.sqrt(dist)) // 가장 높은 수가 변경되는 지점에 딱 맞는 경우
                System.out.println(mid * 2 - 1);
            else if(dist <= mid * mid + mid) // 다음 변경 지점 이전 카운트가 변하는 지점에 해당하는 경우
                System.out.println(mid * 2);
            else
                System.out.println(mid * 2 + 1);
        }
    }
}
