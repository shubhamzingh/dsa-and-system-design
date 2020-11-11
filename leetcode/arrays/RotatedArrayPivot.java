package leetcode.arrays;

public class RotatedArrayPivot {
    public int search(int[] nums, int target) {
        int pivot = findPivotIndex(nums, 0, nums.length-1);
        if (pivot == -1){
            return -1;
        }
        if(nums[pivot] == target){
            return pivot;
        }

            int a =  bs(nums, pivot+1, nums.length-1, target);
            int b = bs(nums, 0, pivot - 1, target);
            //result
            if(a!=-1) return a;
            else return b;
    }

    int bs(int[] nums, int start, int end, int target){
        if(end<start) return -1;
        int mid = (end+start)/2;
        if(nums[mid] == target){
            return mid;
        }
        if(target>nums[mid]){
            return bs(nums, mid+1, end, target);
        }
        else{
            return bs(nums, start, mid-1, target);
        }

    }

    int findPivotIndex(int[] arr, int start, int end){
        if(end<start) return -1;

        int mid = end+start/2;
        if(arr[mid]>arr[0]){
            return findPivotIndex(arr, mid+1, end);
        }
        else{
            if(arr.length==1 || (mid-1)>=0 && (mid+1)<arr.length && arr[mid-1]>arr[mid] && arr[mid]<arr[mid+1]){
                return mid;
            }
            else{
                return findPivotIndex(arr, 0, mid-1);
            }
        }
    }

    public static void main(String[] args) {
        // int[] arr = {4,5,6,7,0,1,2}; // {4,0,1}
        // int[] arr = {4,5,0,1,2,3}; // {4,0,1}
        // int[] arr = {4,5,6,7,8,9,0,1,2}; // {4,0,1}
        int[] arr ={1,3};
        RotatedArrayPivot r = new RotatedArrayPivot();
        //System.out.println(r.findPivotIndex(arr, 0, arr.length-1));
        System.out.println(r.search(arr, 1));
    }
}
