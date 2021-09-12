import java.util.Arrays;

/**
 * 푼 날짜 : 2021-09-09
 * 푼 시간 : 16:42~16:48
 */
//https://programmers.co.kr/learn/courses/30/lessons/42577
public class 전화번호목록 {
    public static void main(String[] args){
        전화번호목록 j = new 전화번호목록();
        //String[] phone_book = {"119", "97674223", "1195524421"};
        String[] phone_book = {"12","123","1235","567","88"};
        System.out.println(j.solution(phone_book));
    }

    public boolean solution(String[] phone_book){
        Arrays.sort(phone_book);
        String before = "";
        for (String s : phone_book) {

            if(!before.equals("") && s.startsWith(before)){
                return false;
            }else{
                before = s;
            }
        }
        return true;
    }

}
