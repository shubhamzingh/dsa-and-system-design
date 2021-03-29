package codingChallenge;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Cisco {

    /*public static void stringExtrapolator(String s){
        String res = "";
        Stack<Character> stk= new Stack<>();
        char[] carr = s.toCharArray();
        String curr = "";

        for(int i=0; i<carr.length;i++){
            curr+=carr[i];
            if(carr[i]=='('){
                res += curr;
                curr="";
            }
            if(carr[i]=='{'){
                int index = i;
                //get index of open brack
                int op = getOpenBrack(index,carr);
                String tbmul = s.substring(op+1, i); //to be multiplied

                int multiplier = getMultiplier(index,carr);
                String mul = s.substring(index+1,multiplier);

                i++;
                while(carr[i]!='}'){
                    multiplier+=carr[i];
                    i++;
                }
                int mul = Integer.valueOf(multiplier);

            }
        }

    }*/

    private static int getMultiplier(int index, char[] carr) {

        int i =index;
        while(carr[i]!='}'){
            i++;
        }
        return i;



    }

    private static int getOpenBrack(int index, char[] carr) {
        while(carr[index]!='('){
            index--;
        }
        return index;
    }

    public static void main(String[] args) {
        List<String> l = new LinkedList<>();
        l.add("test");
        HashSet<String> hs = new HashSet<>(l);
        int s = hs.size();
    }
}
