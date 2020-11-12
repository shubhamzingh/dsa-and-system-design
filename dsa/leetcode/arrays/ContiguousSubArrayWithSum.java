package dsa.leetcode.arrays;

//https://practice.geeksforgeeks.org/problems/subarray-with-given-sum/0
public class ContiguousSubArrayWithSum {

    //Brute Force n^2
    public static int[] getArrayIndex(int[] arr, int sum){
        int[] res= {0,0};
        int total=0;

        for(int i=0;i<arr.length; i++){
            res[0]=i+1;
            total=arr[i];
            for(int j=i+1;j<arr.length;j++){
                total=total+arr[j];
                if(total==sum){
                    res[1]=j+1;
                    return res;
                }
                else if(total>sum){
                    break;
                }
            }
            total=0;
        }

        return res;
    }

    public static int[] getArrayIndexSliding(int[] arr, int sum){
        int[] res= {0,0};
        int total=0;
        int start=-1;
        int end=-1;
        start=0;
        for(int i=0; i<arr.length; i++){
            total=total+arr[i];
            if(total>sum){
                total=total-arr[start];
                start++;
            }
            if(total==sum){
                end=i;
                break;
            }
        }
        res[0]=start;
        res[1]=end;

        return res;
    }

    public static void main(String[] args) {
    int[] input= {9,1,1,2,3,1};
        int[] res=ContiguousSubArrayWithSum.getArrayIndex(input,6);
        System.out.println("first "+res[0]+" second "+res[1]);

        int[] res2=ContiguousSubArrayWithSum.getArrayIndexSliding(input,6);
        System.out.println("first "+res2[0]+" second "+res2[1]);
    }
}
