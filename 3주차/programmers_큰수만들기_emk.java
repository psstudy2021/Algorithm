import java.util.Stack;

/**
 * 푼 날짜: 2021-09-02
 * 푼 시간: 너무 오래걸려서 의미없다~~
 * 출처 : https://bangu4.tistory.com/221
 */
public class 큰수만들기_재도전 {
    public static void main(String[] args){
        큰수만들기_재도전 z = new 큰수만들기_재도전();
        System.out.println(z.solution("1924", 2));
        System.out.println(z.solution("999" , 2)); //9
    }
    public String solution(String number, int k){
        int count = k;
        char[] number_array = number.toCharArray();
        Stack<Character> stack = new Stack<>();
        int i = 0;
        while(i<number_array.length){
            char num = number_array[i];
            while(!stack.isEmpty() && num > stack.peek() && count-- > 0){
                stack.pop();
            }
            stack.push(num);
            i++;
        }

        StringBuilder sb = new StringBuilder();
        for(Character c : stack){
            sb.append(c);
        }
        return sb.toString().substring(0, number.length()-k);
    }

    public String solution2(String number, int k) {
        char[] result = new char[number.length() - k];
        Stack<Character> stack = new Stack<>();

        for (int i=0; i<number.length(); i++) {  // 하나씩 돌면서
            char c = number.charAt(i);
            while (!stack.isEmpty() && stack.peek() < c && k-- > 0) { // top보다 큰값이면 pop()!
                stack.pop();
            }
            stack.push(c);
        }
        for (int i=0; i<result.length; i++) {
            result[i] = stack.get(i);
        }
        return new String(result);
    }

}
