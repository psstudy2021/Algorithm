
public class 광고삽입 {
    public static void main(String[] args) {
        System.out.println(solution("02:03:55", "00:14:15", new String[]{"01:20:15-01:45:14", "00:40:31-01:00:00", "00:25:50-00:48:29", "01:30:59-01:53:29", "01:37:44-02:02:30"}));
        //01:30:59
    }

    static int playTime;
    static int advTime;
    static int[] count;
    static long sum;
    static int result;
    static StringBuilder sb;
    public static String solution(String play_time, String adv_time, String[] logs) {
        playTime = getTimes(play_time);
        advTime = getTimes(adv_time);
        count = new int[playTime + 1];

        for (int i = 0; i < logs.length; i++) {
            String[] str = logs[i].split("-");
            int startLog = getTimes(str[0]);
            int endLog = getTimes(str[1]);
            for (int j = startLog; j < endLog; j++) {
                count[j]++;
            }
        }

        for (int i = 0; i < advTime; i++) {
            sum += count[i];
        }
        getBestAdvTime();
        getResult(result);
        return sb.toString();
    }
    static void getResult(int time){
        sb = new StringBuilder();
        int hour = time/3600;
        time%=3600;
        int minute = time / 60;
        int second = time % 60;

        if(hour<10) sb.append("0");
        sb.append(hour+":");
        if(minute<10) sb.append("0");
        sb.append(minute+":");
        if(second<10) sb.append("0");
        sb.append(second);

    }
    static void getBestAdvTime() {
        long max = sum;
        int start = 0;
        while (advTime <= playTime) {
            sum -= count[start];
            sum += count[advTime];
            if(sum > max){
                max = sum;
                result = start +1;
            }
            start++;
            advTime++;
        }
    }

    static int getTimes(String s) {
        String[] str = s.split(":");
        int time = 0;
        time += Integer.parseInt(str[0]) * 60 * 60;
        time += Integer.parseInt(str[1]) * 60;
        time += Integer.parseInt(str[2]);
        return time;
    }
}
