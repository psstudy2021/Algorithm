import java.util.*;

/**
 * 푼 날짜 : 21-08-12
 * 소요 시간 : 기억안남...
 */
//https://programmers.co.kr/learn/courses/30/lessons/42627
public class 디스크컨트롤러 {
    //[[0, 3], [1, 9], [2, 6]]	9

    public static void main(String[] args){
        디스크컨트롤러 dc = new 디스크컨트롤러();
        int[][] jobs = {{0, 3}, {2, 6}, {1, 9}};
        System.out.println(dc.solution(jobs));
    }
    class Job{
        int requestedTime;
        int workingTime;

        Job(int requestTime, int workingTime){
            this.requestedTime = requestTime;
            this.workingTime = workingTime;

        }
    }
    public int solution(int[][] jobs){
        LinkedList<Job> waiting = new LinkedList<>();
        PriorityQueue<Job> pq = new PriorityQueue<>(new Comparator<Job>() {
            @Override
            public int compare(Job j1, Job j2) {
                int result = j1.workingTime - j2.workingTime;
                return result;
            }
        });

        for(int[] job : jobs){
            waiting.offer(new Job(job[0], job[1]));
        }

        Collections.sort(waiting, new Comparator<Job>() {
            @Override
            public int compare(Job j1, Job j2) {
                int result = j1.requestedTime - j2.requestedTime;
                return result;
            }
        });

        int answer = 0;
        int cnt = 0;
        int time = waiting.peek().requestedTime;

        while (cnt < jobs.length){
            while(!waiting.isEmpty() && waiting.peek().requestedTime <= time){
                pq.offer(waiting.pollFirst());
            }
            if(!pq.isEmpty()){
                Job job = pq.poll();
                time += job.workingTime;
                answer += time - job.requestedTime;
                cnt++;
            } else {
                time ++;
            }
        }
        return answer / cnt;
    }

}
