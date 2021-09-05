package solution.programmers.level3;

import java.util.*;

public class 보석쇼핑 {
    public static void main(String[] args) {
        String[] a = {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"};
        System.out.println(solution(a));
    }

    public static int[] solution(String[] gems) {
        int[] answer;
        Set<String> set = new HashSet<>();

        for (String item : gems) {
            set.add(item);
        }


        Map<String, Integer> map = new HashMap<>();
        Queue<String>queue = new LinkedList<>();

        int plus=0;
        int min = Integer.MAX_VALUE;
        int idx=0;

        for (int i = 0; i < gems.length; i++) {
            map.put(gems[i], map.getOrDefault(gems[i],0)+1);
            System.out.println(gems[i]+" "+map.get(gems[i]));
            queue.offer(gems[i]);

            while (!queue.isEmpty()){
                String tmp = queue.peek();
                if(map.get(tmp)>1){
                    queue.poll();
                    map.put(tmp,map.get(tmp)-1);
                    plus++;
                }else {
                    break;
                }
            }
// String[] a = {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"};

            if(set.size()==map.size() && min>queue.size()){
                min = queue.size();
                idx = plus;
            }
        }



//        for(String key : map.keySet()){
//            System.out.println(key+" "+ map.get(key));
//        }
        System.out.println(idx+" "+min );
        answer = new int[]{idx + 1, idx + min};
        return answer;
    }
}
