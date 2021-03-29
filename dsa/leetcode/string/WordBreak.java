package dsa.leetcode.string;

import java.util.*;

public class WordBreak {
    public static boolean wordBreak(String s, List<String> wordDict) {
        //String[] dict = wordDict.toArray(new String[0]);//new String[s.length()];
        //Arrays.sort(dict, (a, b)-> a.length()-b.length());
        TreeSet<String> dict = new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return b.length()-a.length();
            }});
        dict.addAll(wordDict);


        return canMakeString(s, dict) ;

    }

    public static boolean canMakeString(String s , Set<String> dict){
        if(s.length()==0) return true;
        if(dict.contains(s)) return true;

        for(String word : dict){
            if(s.indexOf(word)>-1){
                int leftIndex = s.indexOf(word);
                int rightIndex = leftIndex+word.length();
                String left = s.substring(0,leftIndex);
                String right ="";
                if(rightIndex<s.length()) right = s.substring(rightIndex,s.length());

                return canMakeString(left, dict) && canMakeString(right, dict);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String a  = "ccaccc";
        List<String> l = new LinkedList<>();
        l.add("cc"); l.add("ca");// l.add("rs");
        if(WordBreak.wordBreak(a,l)){
            System.out.println("can break word");
        }
        else System.out.println("cant break word");
    }
}
