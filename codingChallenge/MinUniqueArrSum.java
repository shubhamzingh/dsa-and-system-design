package codingChallenge;

import java.util.Arrays;

public class MinUniqueArrSum {

    public static int minSum(int[] arr){
        Arrays.sort(arr);
        int sum =arr[0];
        if(arr.length==0) return sum;
        for(int i=1; i<arr.length;i++){
            if(arr[i]==arr[i-1]){
                arr[i]=arr[i]+1;
            }
            sum+=arr[i];
        }

        return sum;
    }
    public static void main(String[] args) {
        int[] arr = {3,2,1,2,7};
        System.out.println(MinUniqueArrSum.minSum(arr));
    }
}
