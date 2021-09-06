import java.util.*;

/**
 * 푼 날짜 : 2021-08-30
 * 푼 시간 : 14:10~15:20 거의 3h... 언제쯤 시간이 줄어들까나~
 * */

//https://programmers.co.kr/learn/courses/30/lessons/72411
public class 메뉴리뉴얼 {
    public static void main(String[] args){
        메뉴리뉴얼 m = new 메뉴리뉴얼();
        String[] orders = {"XYZ", "XWY", "WXA"};
        int[] course = {2, 3, 4};
        String[] result = m.solution(orders, course);
        for(String r : result){
            System.out.println(r);
        }
    }

    static int most;
    public String[] solution(String[] orders, int[] course) {

        PriorityQueue<String> pq = new PriorityQueue<>();
        for(int c : course) {
            most = 0;
            Map<String, Integer> map = new HashMap<>();
            for (int i = 0; i < orders.length; i++) {
                getMenu(0, "", c, 0, orders[i], map);
            }

            Iterator<String> it = map.keySet().iterator();

            while (it.hasNext()) {
                String key = it.next();
                if (map.get(key) >= most && most > 1) {
                    pq.offer(key);
                }
            }
        }
        String[] result = new String[pq.size()];
        int i =0;
        while(!pq.isEmpty()){
            result[i++] = pq.poll();
        }

        return result;
    }

    public static void getMenu(int cnt, String str, int target, int idx, String word, Map<String, Integer> map){
        if(cnt == target) {
            char[] c = str.toCharArray();
            Arrays.sort(c);
            str = String.valueOf(c);
            map.put(str, (map.get(str) == null ? 1 : map.get(str) + 1));
            if(most < map.get(str)) {
                most = map.get(str);
            }
            return;
        }
        char[] wordArray = word.toCharArray();
        for(int i = idx; i < word.length(); i++){
            getMenu(cnt+1, str+wordArray[i], target, i+1, word, map);
        }
        return;
    }


}
