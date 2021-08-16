import java.util.*;

public class programmers_베스트앨범_hw {
    public static void main(String[] args) {
        System.out.println(solution(new String[]{"classic", "pop", "classic", "classic", "pop"}, new int[]{500, 600, 150, 800, 2500}));
    }
    static class Node implements Comparable<Node>{
        int no, play;
        String genre;

        public Node(int no, int play, String genre) {
            this.no = no;
            this.play = play;
            this.genre = genre;
        }

        @Override
        public int compareTo(Node o) {
            if(this.play == o.play)
                return this.no - o.no;
            else
                return o.play - this.play;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "no=" + no +
                    ", play=" + play +
                    ", genre='" + genre + '\'' +
                    '}';
        }
    }
    public static int[] solution(String[] genres, int[] plays) {
        List<Node> list = new ArrayList<>();
        Map<String, Integer> genreMap = new HashMap<>();

        for(int i =0; i<genres.length; i++){
            int no = i;
            int play = plays[i];
            String genre = genres[i];
            list.add(new Node(i,play,genre));
            genreMap.put(genre, genreMap.getOrDefault(genre,0)+play);
        }

        Collections.sort(list, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if(o1.genre.equals(o2.genre))
                    return o1.compareTo(o2);
                else
                    return genreMap.get(o2.genre) - genreMap.get(o1.genre);
            }
        });

        Map<String, Integer>genreCnt = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        for(Node cur : list){
            if(!genreCnt.containsKey(cur.genre)){
                genreCnt.put(cur.genre, 1);
                result.add(cur.no);
            }else{
                int cnt = genreCnt.get(cur.genre);
                if(cnt>=2) continue;
                else{
                    genreCnt.put(cur.genre, cnt+1);
                    result.add(cur.no);
                }
            }
        }
        int[] answer = new int[result.size()];
        for(int i =0; i<result.size(); i++){
            answer[i] = result.get(i);
        }
        return answer;
    }
}
