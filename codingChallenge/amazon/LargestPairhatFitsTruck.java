package amazon;

import java.util.*;

public class LargestPairhatFitsTruck {

    public static PairInt getMaxPair(int truckSpace, int numPackages, ArrayList<Integer> packageSpace){
        int target =truckSpace-30;

        Map<PairInt, Integer> map =  new HashMap<>();
        map.put(new PairInt(-1,-1),Integer.MIN_VALUE);

        for(int i = 0 ; i<numPackages; i++){
            for(int j=i+1; j<numPackages; j++){
                if((packageSpace.get(i)+packageSpace.get(j)) == target){
                    map.put(new PairInt(i,j), Math.max(packageSpace.get(i), packageSpace.get(j)));
                }
            }
        }

        ArrayList<Map.Entry<PairInt,Integer>> entries = new ArrayList<>(map.entrySet());
        Collections.sort(entries, (Comparator.comparingInt(Map.Entry::getValue)));
        return entries.get(entries.size()-1).getKey();

    }

    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);list.add(10);list.add(25);list.add(35);list.add(60);
        int space = 90;
        int numPacks = 5;

//        ArrayList<Integer> list = new ArrayList<>();
//        list.add(20);list.add(70);list.add(90);list.add(30);list.add(60);list.add(110);
//        int space = 110;
//        int numPacks = 6;

//        ArrayList<Integer> list = new ArrayList<>();
//        list.add(100);list.add(180);list.add(40);list.add(120);list.add(10);
//        int space = 250;
//        int numPacks = 5;


        PairInt p = getMaxPair(space, numPacks, list);
        System.out.println(p.first + "::" + p.second);
    }
}
