package google;

import java.util.HashSet;
// https://leetcode.com/discuss/interview-question/553399/
// Q2

public class SplitStringWithSameCharacters {

    public static boolean sameCharacters(String s1, String s2){
        HashSet<Character> hs1 = new HashSet<>();
        HashSet<Character> hs2 = new HashSet<>();

        for(int i =0 ; i<s1.length(); i++){
            hs1.add(s1.charAt(i));
        }

        for(int i =0 ; i<s2.length(); i++){
            hs2.add(s2.charAt(i));
        }

        return hs1.equals(hs2);
    }

    public static int countSameSubstrings(String str){
        int cnt = 0;

        for(int i=1;i<str.length();i++){
            if(sameCharacters((str.substring(0,i)),(str.substring(i)))){
                cnt++;
            }
        }

        return cnt;
    }
    public static void main(String[] args) {


        System.out.println(countSameSubstrings("ababa"));
        //System.out.println(hs1.equals(hs2));
    }
}
