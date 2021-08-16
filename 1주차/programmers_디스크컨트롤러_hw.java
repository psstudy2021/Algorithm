import java.util.*;

public class programmers_디스크컨트롤러_hw {
    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{0, 3}, {1, 9}, {2, 6}}));
    }

    static class Node implements Comparable<Node> {
        int start, time;

        public Node(int start, int time) {
            this.start = start;
            this.time = time;
        }

        @Override
        public int compareTo(Node o) {
            return this.time - o.time;
        }
    }

    public static int solution(int[][] jobs) {
        int answer = 0;
        //시작 오름차순
        Arrays.sort(jobs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int idx = 0;
        int cnt = jobs.length;
        int sum = 0;
        int start = 0;
        while (true) {
            while (idx < cnt && jobs[idx][0] <= start) {
                pq.offer(new Node(jobs[idx][0], jobs[idx][1]));
                idx++;
            }
            if (!pq.isEmpty()) {
                Node cur = pq.poll();
                start += cur.time;
                sum += start - cur.start;
            } else {
                if (idx == cnt)
                    break;
                else start++;
            }
        }
        answer = sum / cnt;
        return answer;
    }
}
