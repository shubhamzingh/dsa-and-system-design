package twitter;
import java.util.*;
public class UserIDinGroup {

    public static void func(List<Integer> counts){
        int cnt =0;
        List<Integer> res = new ArrayList<>();
        for(Integer i : counts){
            while(i>0 && cnt<counts.size()){
                res.add(cnt);
               // System.out.print(cnt);
                cnt++;
                i--;
            }
        }
        //System.out.println();
        res.add(null);

        Collections.sort(counts,Collections.reverseOrder());
        int groups = counts.get(0);

        for(Integer i : res){
            if(i!=null){
                System.out.print(i);
            }
            else{
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        List<Integer> l = new ArrayList<>();
                //l.add(2);l.add(2);l.add(2);l.add(2);
        l.add(3);l.add(3);l.add(3);l.add(3);l.add(3);l.add(1);l.add(3);
        func(l);
    }
}
