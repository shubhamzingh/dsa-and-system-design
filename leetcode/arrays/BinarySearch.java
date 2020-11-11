package leetcode.arrays;

public class BinarySearch {

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
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        BinarySearch b = new BinarySearch();
        System.out.println(b.bs(nums, 0, nums.length, 0));
    }
}
