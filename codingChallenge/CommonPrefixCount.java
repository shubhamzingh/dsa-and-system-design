
import java.util.*;

public class CommonPrefixCount {

    public static int getcount(String s){
        int res=s.length();
        List<String> list = new LinkedList<>();
        for(int i=1; i<s.length(); i++){
            list.add(s.substring(i));
        }

        for(String str : list){
            int temp =0;
            for(int j=0; j<str.length();j++){
                if(str.charAt(j)==s.charAt(j)){
                    temp++;
                }
            }
            res+=temp;
        }
    return res;
    }
    public static void main(String[] args) {
        System.out.println(getcount("abcabcd"));
    }
}
