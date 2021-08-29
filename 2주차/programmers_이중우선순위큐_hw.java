import java.util.Collections;
import java.util.PriorityQueue;

public class 이중우선순위큐{


    public static void main(String[] args) {
        String[] a = {"I 16", "D 1"};
        System.out.println(solution(a));
    }

    public static int[] solution(String[] operations) {
        int[] answer = new int[2];
        PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> min = new PriorityQueue<>();
        for (int i = 0; i < operations.length; i++) {
            String[]op = operations[i].split(" ");
            if(op[0].equals("I")){
                int num = Integer.parseInt(op[1]);
                max.offer(num);
                min.offer(num);
            }else if(op[0].equals("D")){
                if(!max.isEmpty()){
                    if(op[1].equals("1")){
                        int high = max.peek();
                        max.remove(high);
                        min.remove(high);
                    }else if(op[1].equals("-1")){
                        int low = min.peek();
                        max.remove(low);
                        min.remove(low);
                    }
                }
            }
        }
        if(!max.isEmpty()){
            answer[0]=max.peek();
            answer[1]=min.peek();
            return answer;
        }
        return new int[]{0, 0};
    }
}
