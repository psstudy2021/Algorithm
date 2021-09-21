package programmers;

import java.util.*;

public class 후보키 {
    public static void main(String[] args) {
        System.out.println(solution(new String[][]{
                {"100", "ryan", "music", "2"},
                {"200", "apeach", "math", "2"},
                {"300", "tube", "computer", "3"},
                {"400", "con", "computer", "4"},
                {"500", "muzi", "music", "3"},
                {"600", "apeach", "music", "2"}
        }));
    }

    static List<HashSet<Integer>> list;
    static int answer;

    public static int solution(String[][] relation) { // 유일성, 최소성 찾기\
        list = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        for (int i = 1; i <= relation[0].length; i++) {  // 1~4개 일때 체크
            combination(i, 0, 0, set, relation);
        }
        return answer;
    }

    static void combination(int size, int depth, int start, HashSet<Integer> set, String[][] relation) {
        if (depth == size) {
            for (HashSet<Integer> li : list) {
                if (set.containsAll(li))
                    return;
            }
            HashMap<String, Integer> map = new HashMap<>();
            for (int i = 0; i < relation.length; i++) {
                StringBuilder sb = new StringBuilder();
                for (int s : set) {
                    sb.append(relation[i][s]);
                }
                if (map.containsKey(sb.toString()))
                    return;
                map.put(sb.toString(), 0);
            }
            list.add(set);
            answer++;
        } else {
            for (int i = start; i < relation[0].length; i++) {
                HashSet<Integer> key = new HashSet<>(set);
                key.add(i);
                combination(size, depth + 1, i + 1, key, relation);
            }
        }
    }
}
