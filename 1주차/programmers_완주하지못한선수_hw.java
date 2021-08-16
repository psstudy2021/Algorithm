import java.util.*;

public class programmers_완주하지못한선수_hw {
    public static void main(String[] args) {
        System.out.println(solution(new String[]{"marina", "josipa", "nikola", "vinko", "filipa"}, new String[]{"josipa", "filipa", "marina", "nikola"}));
    }
    public static String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String, Integer> map = new HashMap<>();
        for(String str : participant)
            map.put(str, map.getOrDefault(str,0)+1);
        for(String str : completion)
            map.put(str, map.get(str)-1);
        for(String str : map.keySet()){
            if(map.get(str) != 0){
                answer = str;
            }
        }
        return answer;
    }
}
