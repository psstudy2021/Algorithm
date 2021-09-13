package programmers;

public class 문자열압축 {
    public static void main(String[] args) {
        System.out.println(solution("aabbaccc"));
    }
    static int min = Integer.MAX_VALUE;
    public static int solution(String s) {
        int answer = 0;
        if(s.length()==1) return 1;
        for(int i =1; i<=s.length()/2; i++){
            answer = divide(s,i);
        }
        return answer;
    }
    static int divide(String s, int idx){
        int cnt=1;
        String result = "";
        String pattern = "";
        for(int i=0; i<=s.length()+idx; i+=idx){
            String now;
            if(i>=s.length()){
                now="";
            }else if(s.length()<i+idx){
                now = s.substring(i);
            }else{
                now = s.substring(i,i+idx);
            }
            if(i!=0){
                if(now.equals(pattern))
                    cnt++;
                else if(cnt>=2){
                    result += cnt+pattern;
                    cnt=1;
                }else
                    result += pattern;
            }

            pattern = now;
        }

        return min = Math.min(min,result.length());

    }
}
