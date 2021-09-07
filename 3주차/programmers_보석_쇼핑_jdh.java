import java.util.*;

/*
    풀이 시간: 초과
    풀이 방법: 투-포인트 사용
            - hashset을 이용하여 보석 종류 추출
            - queue에 쓸어담은 보석 저장
            - hashmap을 이용하여 보석의 종류와 개수 저장
            - 담은 보석 중 첫번쨰 보석이 hashmap에 2개 이상 들어 있으면 이미 담은 보석 중에 중복되는 것이 있기 때문에 제거함(최소 길이를 구해야 하므로)
            - map의 크기와 set의 크기가 일치하면 모든 종류의 보석을 다 쓸어담은 것이므로 결과값 만들고 종료

 */

public class programmers_보석_쇼핑_jdh {
    public static int[] solution(String[] gems) {
        HashSet<String> set = new HashSet<>();
        HashMap<String, Integer> map = new HashMap<>();
        Queue<String> queue = new LinkedList<>();

        int left = 0;
        int idx = 0;
        int length = Integer.MAX_VALUE;

        set.addAll(Arrays.asList(gems));

        for(int i = 0; i < gems.length; i++){
            queue.offer(gems[i]); // 모은 보석
            map.put(gems[i], map.getOrDefault(gems[i], 0) + 1); // 없으면 0, 있으면 그 값에 + 1 put

            while(true){
                String gem = queue.peek();
                if(map.get(gem) > 1){
                    map.put(gem, map.get(gem) - 1);
                    queue.poll();
                    idx++;
                }
                else break;
            }

            if(map.size() == set.size() && length > queue.size()) {
                left = idx;
                length = queue.size();
            }
        }

        return new int[]{left + 1, left + length};
    }

    public static void main(String args[]){
        String gems[] = {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"};
        System.out.println(Arrays.toString(solution(gems)));
    }
}
