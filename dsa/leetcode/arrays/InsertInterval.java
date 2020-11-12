package dsa.leetcode.arrays;

import java.util.*;

public class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {

        if(intervals.length==0){
            int[][] res = {};
            return res;
        }
        // insert new interval
        int finalLength = intervals.length+1;//newInterval.length;
        int[][] input  = new int[finalLength][2];

        if(newInterval.length>0){
            for(int i = 0 ; i<intervals.length ; i++){
                input[i][0]=intervals[i][0];
                input[i][1]=intervals[i][1];
            }
            input[finalLength-1][0]=newInterval[0];
            input[finalLength-1][1]=newInterval[1];

        }
        else{
            input=intervals;
        }


        Arrays.sort(input, (a, b)->{return a[0]-b[0];});
        List<int[]> list = new ArrayList<>();

        int start=input[0][0];
        int end=input[0][1];

        for(int i= 1; i<input.length ; i++){
            int s = input[i][0];
            int e = input[i][1];

            if(doOverlap(s,e,start,end)){
                start = Math.min(start,s);
                end =Math.max(end,e);
            }
            else{
                int[] curr = new int[2];
                curr[0]=start; curr[1]=end;
                start = input[i][0];
                end = input[i][1];
                list.add(curr);
            }
        }

        //adding last element
        int[] curr = new int[2];
        curr[0]=start; curr[1]=end;
        list.add(curr);

        int[][] res = new int[list.size()][2];
        int i=0;
        for(int[] tupple : list){
            res[i]=tupple;
            i++;
        }

        return res;


    }

    boolean doOverlap(int s, int e, int start, int end){
        if(s<=end){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        InsertInterval mi = new InsertInterval();
        int[][] interval = {{1,3},{6,9}};
        int[] n = {2,5};
        mi.insert(interval, n);
    }
}
