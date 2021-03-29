package amazon;

import java.util.Comparator;
import java.util.PriorityQueue;

public class HardDiskSpace {

public static int hddSpace(int [] arr, int segment){
    PriorityQueue<Integer> pq = new PriorityQueue<>(segment);

    //populate the initial limit
    for(int i=0; i<segment; i++){
        pq.add(arr[i]);
    }
    int end = segment;
    int prev = 0;
    int max = Integer.MIN_VALUE;
    while(end < arr.length){
        int polled = pq.poll();
        max = Math.max(max,polled);

        pq.add(polled);
        //remove trailing
        pq.remove(arr[prev]);
        prev++;

        //add new
        pq.add(arr[end]);
        end++;
    }
    return max;

////////////////////////////////////////////////////////////////////////////////////////////
//    //populate the initial limit
//    for(int i=0; i<segment; i++){
//        pq.add(arr[i]);
//    }
//    int polled = pq.poll();
//    temp= Math.min(temp, polled);
//
//    for(int i = segment; i<arr.length; i++){
//        pq.add(arr[i]);
//        // take min out of the segments, and take the max in those minimums
//        int polled2 = pq.poll();
//        temp= Math.min(temp, polled2);
//        res= Math.max(res, temp);
//    }
////////////////////////////////////////////////////////////////////////////////////////////
//    int max = Integer.MIN_VALUE;
//    for(int i=0; i<arr.length-segment; i++){
//        int min =Integer.MAX_VALUE;
//        for(int j=i; j<segment+i ;j++){
//            min = Math.min(min, arr[j]);
//        }
//        max= Math.max(max, min);
//    }
//
//    return max;
}

    public static void main(String[] args) {
        //int[] arr = {8,2,4};
        int[] arr = {1,2,3,1,2};

        PriorityQueue<Integer> pq = new PriorityQueue<>(3);
        pq.add(1);
        pq.add(2);
        pq.add(3);
        pq.add(4);


        System.out.println(hddSpace(arr,2));
    }
}
