package amazon;


import java.util.*;

public class MaximizeProfit {

    public static int getMaxProfit(int[] arr, int numOfItems){
    int res=0;

        // items entered in PQ, max heap
        PriorityQueue<Integer> profitQueue = new PriorityQueue<>(Comparator.reverseOrder());
        for(int i=0; i< arr.length; i++){
            profitQueue.add(arr[i]);
        }

        int items =0;
        while(items<numOfItems){
            int polled = profitQueue.poll();
            // adds the profit to result, adds back the updated number of item to queue
            res+=polled;
            profitQueue.add(--polled);
            items++;
        }
    return res;
    }

    public static void main(String[] args) {

        int[] arr={3,5};
        System.out.println(getMaxProfit(arr,6));
        TreeMap<Integer,Integer> tm = new TreeMap<>(Collections.reverseOrder());
    }
}
