package amazon;

import java.util.HashSet;

public class SortedGroups {

    public static int getNumPackages(int[] arr){
    // int res=1;
        HashSet<Integer> hs = new HashSet<>();
        for(int i = 0; i< arr.length; i++){
            hs.add(arr[i]);
        }

    return hs.size();
    }

    public static void main(String[] args) {

    }
}
