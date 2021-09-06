import java.util.*;

/**
 * 푼 날짜: 2021-08-31
 * 푼 시간:
 */

//보석 배열의 길이가 10만이므로 2중 for문으로는 해결 불가능
//슬라이딩 윈도우 알고리즘 활용
//https://programmers.co.kr/learn/courses/30/lessons/67258
public class 보석쇼핑_재도전 {
    public static void main(String[] args){
        보석쇼핑_재도전 j = new 보석쇼핑_재도전();
        //String[] gems = {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA" };  //[3,7]
        //String[] gems = {"AA", "AB", "AC", "AA", "AC" }; // [1,3]
        String[] gems = {"XYZ", "XYZ", "XYZ" };  //[1,1]
        //String[] gems = {"a", "b", "b", "b", "c", "d", "d", "d", "d", "d", "d", "d", "b", "c", "a" }; //[12, 15]
        //String[] gems = {"ZZZ", "YYY", "NNNN", "YYY", "BBB" };  //[1,5]
        int[] result = j.solution(gems);
        for(int i : result){
            System.out.println(i);
        }

    }
    public int[] solution(String[] gems){
        Set<String> gemsSet = new HashSet<>();
        for(String g : gems){
            gemsSet.add(g);
        }
        return slidingWindow(gems, gemsSet.size());

    }
    public int[] slidingWindow(String[] gems, int length) {
        int n = gems.length;
        int[] result = new int[2];
        int rightIdx = 0;
        int min = Integer.MAX_VALUE;
        Map<String, Integer> map = new HashMap<>();
        while (rightIdx < n) {

            if (map.size() < length) {
                map.put(gems[rightIdx], rightIdx);
                rightIdx++;
            }
            if (map.size() == length) {
                int firstIdx = Collections.min(map.values());
                int lastIdx = Collections.max(map.values());
                if((lastIdx - firstIdx) < min){
                    min = lastIdx - firstIdx;

                    result[0] = firstIdx + 1;
                    result[1] = lastIdx + 1;
                }
                map = new HashMap<>();
                rightIdx = firstIdx+1;
            }


        }
        return result;
    }

}
