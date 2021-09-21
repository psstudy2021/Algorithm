package programmers;

import java.util.Arrays;
import java.util.Comparator;

public class 섬연결하기 {
    public static void main(String[] args) {
        System.out.println(solution(4, new int[][]{{0, 1, 1}, {0, 2, 2}, {1, 2, 5}, {1, 3, 1}, {2, 3, 8}}));
    }

    static int[] parents;

    public static int solution(int n, int[][] costs) {
        int answer = 0;
        Arrays.sort(costs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];  //오름차순
            }
        });
        for(int i =0; i<costs.length; i++){
            System.out.println(costs[i][2]);
        }
        parents = new int[n]; // 섬 개수
        for (int i = 0; i < n; i++) {
            makeSet(i);
        }
        int cnt=0;
        for(int i =0; i<costs.length; i++){
            int a = findSet(costs[i][0]);
            int b = findSet(costs[i][1]);
            if(a == b) continue;
            union(a,b);
            answer += costs[i][2];
            cnt++;
            if (cnt==n-1) break;
        }

        return answer;
    }
    static void makeSet(int i){
        parents[i] = i;
    }
    static int findSet(int x){
        if(x == parents[x]) return x;
        parents[x] = findSet(parents[x]);
        return parents[x];
    }
    static void union(int a, int b){
        parents[findSet(b)] = findSet(a);
    }

}
