package dsa.leetcode.backtracking;

import java.util.*;

public class GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
            List<String> lists = new ArrayList<>();
            int cnto = n, cntc = n;
            String s = "";
            func(lists, "", 0, 0, n);
            return lists;

        };

    void func(List<String> lists, String s, int cnto, int cntc, int len){
        if(s.length()==len*2){
            lists.add(s);
            return;
        }
        if(cnto<len)
            func(lists, s+"(", cnto+1,cntc, len);
        if(cntc<cnto)
            func(lists, s+")", cnto,cntc+1, len);
    }

    public static void main(String[] args) {
        GenerateParenthesis gp = new GenerateParenthesis();
        gp.generateParenthesis(3);
    }
}
