
//https://programmers.co.kr/learn/courses/30/lessons/42628

import java.util.*;

/**
 * 푼 날짜 : 2021-08-24
 * 푼 시간: 10:20-10:52, 32분!!
 */
public class 이중우선순위큐 {
    public static void main(String[] args){
        이중우선순위큐 q = new 이중우선순위큐();
        int[] result = q.solution(new String[]{"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"}); //["I 7","I 5","I -5","D -1"]

        for(int i : result){
            System.out.print(i + " ");
        }

    }
    //I 숫자 : 삽입
    //D 1 : 최댓값 삭제
    //D -1 : 최솟값 삭제
    public int[] solution(String[] operations){
        Deque<Integer> dq = new ArrayDeque<>();

        for(String operation : operations){
            String op = operation.substring(0,1);
            String num = operation.substring(2, operation.length());
            switch(op){
                case "I" :
                    dq.add(Integer.parseInt(num));
                    break;
                case "D" :
                    dq = sort(dq);

                    if(num.equals("1")){
                        dq.pollFirst();
                    } else{
                        dq.pollLast();
                    }
            }
        }

        dq = sort(dq);

        if(dq.isEmpty()){
            return new int[]{0, 0};
        } else {
            return new int[]{(int)dq.pollFirst(), (int)dq.pollLast()};
        }

    }
    public Deque<Integer> sort(Deque<Integer> dq){
        Object[] intArray = dq.toArray();
        Arrays.sort(intArray, Collections.reverseOrder());
        dq.clear();

        for(Object i : intArray){
            dq.add((int) i);
        }
        return dq;
    }
}
