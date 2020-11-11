package dsa.leetcode.backtracking;

// https://leetcode.com/problems/implement-strstr/
public class Substring {
    public int strStr(String haystack, String needle) {
        int i=0;

        while(i<haystack.length()){
            if(haystack.charAt(i)==needle.charAt(0) && match(haystack, needle, i+1, 1)){
                return i;
            }
            i++;
        }
        return 0;

    }
    boolean match(String haystack, String needle, int i, int j){
        while(i<haystack.length() && j<needle.length()){
            if(haystack.charAt(i)!=needle.charAt(j)){
                return false;
            }
            i++;j++;
        }
        //got a perfect match for all characters
        if(j==needle.length())
            return true;
        else return false;
    }

    public static void main(String[] args) {
        Substring s = new Substring();
        System.out.println(s.strStr("h", ""));
    }
}
