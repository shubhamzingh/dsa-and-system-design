package dsa.leetcode.string;

import java.util.HashSet;
import java.util.Set;

// https://practice.geeksforgeeks.org/problems/smallest-distant-window/0
public class MinWindowWithAllChar {

    public String findMinWindow(String s){
        Set<Character> set = new HashSet<>();
        for(char c : s.toCharArray()){
            set.add(c);
        }

        int windownSize = set.size();
        while(windownSize<=s.length()){
            for(int winStart=0, winEnd=windownSize; winEnd<=s.length();winStart++,winEnd++){
                // starting winEnd from windows size is suitable since substring would exclude the charAt(windowSize)
                // otherwise, if we have to make some other calculation like summing up all the elements in this window then j should be winSize-1;
                // eg. if winSize =4 then we want just first 4 elements to start with, i.e. from 0 to 3.

                // another thing to see here is the terminating condition, winEnd<=s.length()
                // we have elegantly made sure winEnd doesnt exceed s.length. Ideally it would have been < s.length()
                // but again, since we are passing this winEnd to substring, it will throw index out of bounds.
                if(containsAll(s.substring(winStart,winEnd), set)){
                    return s.substring(winStart,winEnd);
                }
            }
            windownSize++;
        }
        return s;
    }

    boolean containsAll(String s , Set<Character> set){
        for(Character c : set){
            if(s.indexOf(c)==-1)
                return false;
        }
        return true;
    }
    public static void main(String[] args) {
        MinWindowWithAllChar m = new MinWindowWithAllChar();

        // aabcbcdbca
        System.out.println(m.findMinWindow("aabzcbcdbcaz"));
    }

}
