import java.util.Map;
import java.util.HashMap;
import java.util.Queue;
import java.util.PriorityQueue;
import java.util.List;
import java.util.LinkedList;
import java.util.Collections;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Queue<Music>> musicMap = new HashMap<>();
        Map<String, Integer> genreMap = new HashMap<>();
        List<Music> musicL = new LinkedList<>();
        List<Integer> answer = new LinkedList<>();
        
        int len = genres.length;
        for(int i=0; i<len; i++){
            if(!musicMap.containsKey(genres[i])){
                musicMap.put(genres[i], new PriorityQueue<Music>());
            }
            musicMap.get(genres[i]).add(new Music(genres[i], plays[i], i));
            genreMap.put(genres[i], genreMap.getOrDefault(genres[i], 0) + plays[i]);
        }
        
        for(String genre : genreMap.keySet()){
            for(int i=0; i<2 && !musicMap.get(genre).isEmpty(); i++)
                musicL.add(musicMap.get(genre).poll());
        }
        
        Collections.sort(musicL, (x,y) -> {
            if(x.genre.equals(y.genre)) return x.compareTo(y);
            
            return genreMap.get(y.genre) - genreMap.get(x.genre);
        });
        
        for(Music m : musicL){
            answer.add(m.index);
        }
        
        return answer.stream().mapToInt(i->i).toArray();
    }
    
    private class Music implements Comparable<Music> {
        final String genre;
        final int plays;
        final int index;
        
        Music(String genre, int plays, int index){
            this.genre = genre;
            this.plays = plays;
            this.index = index;
        }
        
        @Override
        public int compareTo(Music other){
                return (plays == other.plays)? 
                index - other.index : other.plays - plays;
        }   
    }
}