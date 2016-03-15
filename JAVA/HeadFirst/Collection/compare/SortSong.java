/*
 * use Comparable interface<java.lang.Comparable>
 * # public interface Comparable<T>{
 *      int compareTo(T o);
 * }
 * # Collections.sort(List<T> l);   // public static <Textends Comparable<? super T>> void sort(List<T> l);
 *
 * use HashSet to remove same object
 * use TreeSet to remove same object and sort
 */

import java.util.*;
import java.io.*;

public class SortSong
{
    class Song implements Comparable<Song>
    {
        private String title;
        private String artist;
        private Song(String t, String a){
            title = t;
            artist = a;
        }
        public int compareTo(Song s){
            return title.compareTo(s.getTitle());
        }
        public String getTitle(){
            return title;
        }
        public String getArtist(){
            return artist;
        }
        public String toString(){
            return title;
        }
        public boolean equals(Object aSong){
            Song s = (Song)aSong;
            return getTitle().equals(s.getTitle());
        }
        public int hashCode(){
            return title.hashCode();
        }
    }

    ArrayList<Song> sl = new ArrayList<Song>();
    
    public static void main(String[] args){
        new SortSong().go();
    }
    public void go(){
        getSong();
        System.out.println(sl);
//        Collections.sort(sl);
        System.out.println(sl);
        HashSet<Song> ss = new HashSet<Song>();
        ss.addAll(sl);
        System.out.println(ss);
        TreeSet<Song> st = new TreeSet<Song>();
        st.addAll(sl);
        System.out.println(st);
    }
    private void getSong(){
        try{
            File f = new File("SortSongList.txt");
            BufferedReader reader = new BufferedReader(new FileReader(f));
            String line = null;
            while((line = reader.readLine()) != null){
                addSong(line);
            }
        } catch(Exception ex){
            ex.printStackTrace();
        }
    }
    private void addSong(String lineTopare){
        String[] tokens = lineTopare.split("/");
        Song next = new Song(tokens[0], tokens[1]);
        sl.add(next);
    }
}
