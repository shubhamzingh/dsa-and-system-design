package leetcode.arrays;

import java.util.*;

public class MergeInterval {

    public int[][] merge(int[][] intervals) {
        List<int[]> list = new ArrayList<>();
        if(intervals.length==0) {
            int[][] res = {};
            return res;
        }

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });

        int start = intervals[0][0];
        int end = intervals[0][1];

        for(int i=1; i<intervals.length; i++){

            int s = intervals[i][0];
            int e = intervals[i][1];
            if(isOverlap(start,s,end,e)){
                end=Math.max(e,end);
                start =Math.min(s,start);
            }
            else{
                int[] pair= new int[2];
                pair[0] = start; pair[1]=end;
                list.add(pair);

                start=intervals[i][0];
                end=intervals[i][1];
            }

        }

        if(start !=-1 && end !=-1){
            // add start and end to the list
            int[] pair= new int[2];
            pair[0] = start; pair[1]=end;
            list.add(pair);
        }

        int[][] res = new int[list.size()][2];
        int totalTime =0;

        int i=0;
        for(int[] tupple : list){
            res[i][0]=tupple[0];
            res[i][1]=tupple[1];
            totalTime += tupple[1]-tupple[0];
            i++;
        }

        System.out.println("total play time is "+totalTime);
        return res;
    }


    boolean isOverlap(int start , int s, int end, int e){
        if(s<=end){
            return true;
        }
        else return false;
    }

    public static void main(String[] args) {
        MergeInterval mi = new MergeInterval();
        //int[][] interval = {{1,3},{2,6},{8,10},{15,18}};
        int[][] interval = {{1,4},{0,0}};
        mi.merge(interval);
    }
}
