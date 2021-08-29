
//https://programmers.co.kr/learn/courses/30/lessons/72414

/**
 * 푼 날짜: 2021-08-23
 * 푼 시간: 못풀어서 동영상 풀이 확인 ㅠㅠ https://www.youtube.com/watch?v=Xx5bk_EP8tQ
 */
public class 광고삽입 {
    public static void main(String[] args) {
        광고삽입 n = new 광고삽입();
        //String play_time = "02:03:55";
        //String adv_time = "00:14:15";
        //String[] logs = {"01:20:15-01:45:14", "00:40:31-01:00:00", "00:25:50-00:48:29", "01:30:59-01:53:29", "01:37:44-02:02:30"};
        String play_time = "00:00:10";
        String adv_time = "00:00:02";
        String[] logs = {"00:00:02-00:00:05", "00:00:03-00:00:06"};
        String result = n.solution(play_time, adv_time, logs);
        System.out.println(result);

    }
    public String solution(String play_time, String adv_time, String[] logs) {
        int playSec = convert(play_time);
        int advSec = convert(adv_time);

        int[] totalSec = new int[100 * 3600]; //최대 100시간을 초단위로 변경한것
        for(String log : logs){
            int start = convert(log.substring(0, 8)); //01:20:15
            int end = convert(log.substring(9, 17)); //01:45:14
            for(int i = start; i < end; i++){
                totalSec[i] += 1;
            }
        }
        long currSum = 0;
        for(int i=0; i< advSec; i++){
            currSum += totalSec[i];
        }

        long maxSum = currSum;
        int maxIdx = 0;
        for (int i= advSec; i <playSec; i++){
            currSum = currSum + totalSec[i] - totalSec[i - advSec];

            if(currSum > maxSum){
                maxSum = currSum;
                maxIdx = i - advSec + 1;
            }
        }
        return String.format("%02d:%02d:%02d", maxIdx / 3600, maxIdx / 60 % 60, maxIdx % 60);
    }

    int convert(String time){
        String[] nums = time.split(":");
        return Integer.parseInt(nums[0]) * 60 * 60 + Integer.parseInt(nums[1]) * 60 + Integer.parseInt(nums[2]);
    }

}
