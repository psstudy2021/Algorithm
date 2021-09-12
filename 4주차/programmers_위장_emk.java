import java.util.HashMap;
import java.util.Map;

/**
 * 푼 날짜 : 2021-09-08
 * 수식을 만들어야 하는 문제였다. 어려워...
 */
//https://programmers.co.kr/learn/courses/30/lessons/42578
public class 위장 {
    public static void main(String[] args){
        위장 w = new 위장();
        String[][] clothes = {{"yellowhat", "headgear"},{"bluesunglasses", "eyewear"},{"green_turban", "headgear"}};
        //String[][] clothes = {{"crowmask", "face"}, {"bluesunglasses", "face"}, {"smoky_makeup", "face"}};
        //String[][] clothes = {{"crowmask", "face"}};

        System.out.println(w.solution(clothes));
    }
    public int solution(String[][] clothes) {
        int result = clothes.length;
        int cnt = 0;
        Map<String, Integer> map = new HashMap<>();
        for(String[] s : clothes){
            map.put(s[1], map.getOrDefault(s[1], 0) + 1);
        }

        if(map.size()>=1){
            cnt = 1;
            for(String key : map.keySet()){
                cnt *= (map.get(key)+1);  //왜... +1???
            }

        }

        return cnt-1;
    }

}
