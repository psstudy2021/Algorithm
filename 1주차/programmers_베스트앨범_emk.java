import java.util.*;

/**
 * 푼 날짜 : 21-08-12
 * 소요 시간 : 기억안남.. 
 */
//https://programmers.co.kr/learn/courses/30/lessons/42579
public class 베스트앨범 {
    /*
    속한 노래가 많이 재생된 장르를 먼저 수록합니다.
    장르 내에서 많이 재생된 노래를 먼저 수록합니다.
    장르 내에서 재생 횟수가 같은 노래 중에서는 고유 번호가 낮은 노래를 먼저 수록합니다.
    가장 많이 재생된 노래를 두 개씩
     */
    public static void main(String[] args){
        베스트앨범 ba = new 베스트앨범();
        //String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        //int[] plays = {500, 600, 150, 800, 2500}; //[4,1,3,0]

        String[] genres = {"classic", "pop", "classic", "classic", "classic"};
        int[] plays = {500, 1000, 400, 300, 200, 100}; //[0,2,1]
        int[] result = ba.solution(genres, plays);
        for(int i : result){
            System.out.println(i);
        }
    }

    class GenrePlayed{
        String name;
        int played;
        GenrePlayed(String name, int played){
            this.name = name;
            this.played = played;
        }
    }

    public int[] solution(String[] genres, int[] plays) {
        //plays 기준, genre내에서 plays 기준, 고유번호 기준
        //["1", ["classic", 500]
        Map<String, PriorityQueue<int[]>> map = new HashMap<>();
        Map<String, Integer> genreMap = new HashMap<>();
        for(int i =0; i<genres.length; i++){

            PriorityQueue obj = map.get(genres[i]);

            if(obj == null){
                PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
                    @Override
                    public int compare(int[] o1, int[] o2) {
                        return o2[1]- o1[1];
                    }
                });

                int[] intArray = new int[2];
                intArray[0] = i;
                intArray[1] = plays[i];

                genreMap.put(genres[i], plays[i]);
                pq.add(intArray);
                map.put(genres[i], pq);

            }else {
                int[] intArray = new int[2];
                intArray[0] = i;
                intArray[1] = plays[i];

                obj.add(intArray);
                genreMap.put(genres[i], genreMap.get(genres[i]).intValue() + plays[i]);
            }
        }

        PriorityQueue<GenrePlayed> totalPQ = new PriorityQueue<GenrePlayed>(new Comparator<GenrePlayed>() {
            @Override
            public int compare(GenrePlayed o1, GenrePlayed o2) {
                return o2.played - o1.played;
            }
        });
        for(String name : genreMap.keySet()){
            GenrePlayed genrePlayed = new GenrePlayed(name, genreMap.get(name));
            totalPQ.add(genrePlayed);
        }

        List listResult = new ArrayList();

        while(!totalPQ.isEmpty()){
            String genre = totalPQ.poll().name;
            for(int j=0; j<2; j++){
                if(map.get(genre).isEmpty()){
                    break;
                }
                int played = map.get(genre).poll()[0];
                listResult.add(played);

            }
        }
        int[] result = new int[listResult.size()];
        for(int i =0; i<listResult.size(); i++){
            result[i] = (int) listResult.get(i);
        }
        return  result;

    }
}
