package amazon;

import java.util.HashMap;
import java.util.HashSet;

class PairIntt{
    int first, second;
    PairIntt(){}
    PairIntt(int first, int second){
        this.first=first;
        this.second=second;
    }
}

public class PairWithMax {

    public static int[] getMaxPair(int[] arr, int weight){
        int res[] = new int[2];
        res[0]=-1; res[1]=-1;
        int max = Integer.MIN_VALUE;
        int target = weight-30;

//        for(int i=0; i<arr.length; i++){
//            for(int j=i+1; j<arr.length;j++){
//                if(arr[i]+arr[j] == target && (arr[i] > max || arr[j] > max)){
//                       max  = Math.max(arr[i],arr[j]); //arr[i]>arr[j] ? arr[i] : arr[j];
//                       res[0]=i; res[1]=j;
//                }
//            }
//        }

        HashMap<Integer, Integer> hm = new HashMap<>();



        return res;
    }


    public static void main(String[] args) {

        // int[] arr = {20,70,90,30,60,110};
        // int[] res = PairWithMax.getMaxPair(arr,110);

        int[] arr = {100,180,40,120,10};
        int[] res = PairWithMax.getMaxPair(arr,250);

        System.out.println("1::::: "+res[0]+" :::2::::: "+ res[1]);

    }
}
