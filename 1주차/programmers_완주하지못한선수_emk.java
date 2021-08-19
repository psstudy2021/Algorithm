import java.util.HashMap;
import java.util.Map;

/**
 * 푼 날짜 : 21-08-17
 * 소요 시간 : 1시간 
 */
//https://programmers.co.kr/learn/courses/30/lessons/42576
public class Runner_again {
    public static void main(String[] args){
        Runner_again r = new Runner_again();
        String[] participants = {"kiki","kiki","kiki"};
        String[] completion = {"kiki","kiki" };
        System.out.println(r.solution(participants, completion));

    }
    /*
    completion의 길이는 participant의 길이보다 1 작습니다.
    participants 중에는 동명이인이 있을 수 있습니다.
     */
    public String solution(String[] participants, String[] completion){

        Map<String, Integer> map = new HashMap<>();
        for(String participant : participants){
            map.put(participant, (map.get(participant) == null? 1 : map.get(participant)+1));
        }

        for(String completed : completion){
            if(map.get(completed) != null) {
                map.put(completed, map.get(completed)-1);
            }
        }

        for(Map.Entry entry : map.entrySet()){
            if((int) entry.getValue() > 0){
                return entry.getKey().toString();
            }
        }
        return null;
    }
}
