import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 푼 날짜 : 2021-09-06
 * 푼 시간 : 18:30~19:40 1h 10min
 */

//https://programmers.co.kr/learn/courses/30/lessons/60057
public class 문자열압축 {
    public static void main(String[] args){
        //테스트 5번빼고 통과 ==> "a"
        문자열압축 z = new 문자열압축();
        System.out.println(z.solution("a"));
    }
    public int solution(String s){
        //"a" "aa" "aab"
        //stack에 하나씩 담는다
        //stack.peek()과 비교한다
        //같으면 stack.push()
        //다르면 stack.size()를 글자앞에 붙이고 stack을 비운다음에 그 다음 글자를 stack에 넣는다.
        //stack size가 1일 경우에는 숫자를 붙이지 않는다.

        int min = s.length();
        String newStr = "";
        Stack<String> stack = new Stack<>();
        for(int i =1; i<s.length(); i++){
            Queue<String> q = split(s, i);

            while(!q.isEmpty()){
                String tmp = q.poll();
                if(stack.isEmpty()) {
                    stack.push(tmp);
                }else if(stack.peek().equals(tmp)) {
                    stack.push(tmp);
                }else if(stack.peek() != tmp){
                    if(stack.size()>1) {
                        newStr += stack.size() + stack.peek();
                    }else if(stack.size()==1){
                        newStr += stack.peek();

                    }
                    stack.clear();
                    stack.push(tmp);
                }

            }

            if(min > newStr.length()) {
                min = newStr.length();

            }
            newStr = "";
            stack.clear();
        }

        return min;
    }

    public Queue<String> split(String s, int i){
        Queue<String> q = new LinkedList();
        int begin = 0;
        int end = i;
        while(begin < s.length()){
            q.add(s.substring(begin, end));
            if(begin == s.length()-1) break;
            begin = end;
            end = end + i;
            if(begin >= (s.length() -i)){
                end = s.length();
            }else if(end >= (s.length()-1)) {
                end = s.length()-1;
            }

        }
        q.add("");
        return q;

    }
}
