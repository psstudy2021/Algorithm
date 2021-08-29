package programmers;

public class 카펫 {
    public static void main(String[] args) {

    }
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int sum = brown + yellow;
        int row=0;
        int col=0;
        for(int i =1; i<=yellow/2+1; i++){
            row =i;
            if(yellow%i==0){
                col = yellow/i;
            }else col = i+1;

            if(2*(row+col)+4==brown) break;
        }
        answer[0]= Math.max(row,col)+2;
        answer[1]= Math.min(row,col)+2;
        return answer;
    }
}
