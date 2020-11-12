package dsa.leetcode;

import java.util.*;

public class PartitioningPalindrome {
    public List<List<String>> partition(String s) {

        List<List<String>> lists = new ArrayList<>();
        List<String> l= new ArrayList<>();
        func(s,l,lists);
        return lists;
    }

    void func(String s, List<String> l, List<List<String>> lists){

        if(s.length()==0){
            lists.add(new ArrayList(l));
        }

        for(int i=1; i<=s.length();i++){
            if(isPalindrome(s.substring(0,i))){
                l.add(s.substring(0,i));
                func(s.substring(i,s.length()),l,lists);
                l.remove(l.size()-1);
            }
        }
    }

    boolean isPalindrome(String s){
        int i=0; int j=s.length()-1;
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
            i++;j--;
        }
        return true;
    }

    public static void main(String[] args) {
        PartitioningPalindrome p = new PartitioningPalindrome();
        System.out.println(p.partition("abbab"));
    }
}
