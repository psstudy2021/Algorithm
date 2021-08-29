
/**
 * 푼 날짜 : 2021-08-27
 * 푼 시간 : 09:54~ 11:19 1h25 걸림!
 */
//https://programmers.co.kr/learn/courses/30/lessons/42842
public class 카펫 {
    public static void main(String[] args) {
        카펫 c = new 카펫();
        int[] result = c.solution(24, 24);
        System.out.println(result[0] + " :" + result[1]);
    }

    public int[] solution(int brown, int yellow) {

        for (int i = 1; i < yellow+1; i++) {
            int factor = yellow;
            if (factor % i == 0 && (factor/i+2)*(i+2) - yellow == brown)  {

                return new int[]{factor / i + 2, i + 2};
            }
        }

        return null;

    }

}

