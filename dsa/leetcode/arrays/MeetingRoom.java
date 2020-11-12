package dsa.leetcode.arrays;

import java.util.Arrays;

// https://leetcode.com/problems/meeting-rooms/
public class MeetingRoom {
    public boolean canAttendMeetings(int[][] intervals) {
        if(intervals.length==0){
            return true;
        }
        Arrays.sort(intervals, (a, b)->{return a[0]-b[0];});
        int start = intervals[0][0];
        int end = intervals[0][1];

        for(int i=1; i<intervals.length;i++){
            int s = intervals[i][0];
            int e = intervals[i][1];
            //System.out.println("start"+start+"end"+end+"s"+s+"e"+e);
            if(overlap(s,e,start,end)){
                return false;
            }
            start = intervals[i][0];
            end = intervals[i][1];
        }
        return true;
    }

    boolean overlap(int s, int e, int start, int end){
        if(end>s){
            return true;
        }
        else return false;
    }
}
