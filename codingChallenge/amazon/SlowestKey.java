package amazon;

public class SlowestKey {

    static char findSlowestKey(int[][] arr){
        char ans = ' ';
        int prevTime =0;
        int maxTime =-1;
        for(int i=0; i<arr.length; i++){
            int time = arr[i][1]-prevTime;
            prevTime=arr[i][1];
            if(time > maxTime){
                maxTime =time;
                ans = (char)(arr[i][0]+65);
            }

        }
        return ans;
    }

    public static void main(String[] args) {
        int [][] arr = {{0,2},{1,5},{0,9},{2,15}};
        System.out.println(findSlowestKey(arr));
    }
}
