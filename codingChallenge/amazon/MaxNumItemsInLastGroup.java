package amazon;

import java.util.Arrays;

public class MaxNumItemsInLastGroup {

    public static int getMaxItems(int[] arr){
        // arrange the groups in ascending order
        Arrays.sort(arr);
        // apply first constrained
        arr[0]=1;

        // iterate through to apply the second constraint
        for(int i=1; i<arr.length;i++){
            if(arr[i]-arr[i-1] > 1){
                arr[i]=arr[i-1]+1;
            }
        }

        return arr[arr.length-1];
    }
    public static void main(String[] args) {
        //int[] arr = {1,3,4,3};
        int[] arr = {1,1,1};
        System.out.println("Max items : "+getMaxItems(arr));
    }
}
