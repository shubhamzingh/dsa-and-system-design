package leetcode.backtracking;

import java.util.*;

public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        bt(lists,list,-1,nums);
        return lists;
    }

    void bt(List<List<Integer>>  lists , List<Integer> list, int i , int[] nums){
        if(i>=nums.length){
            return;
        }

        if(i!=-1){
            list.add(nums[i]);
        }
        List<Integer> res = new ArrayList(list);
        lists.add(res);


        bt(lists,list,i+1,nums);

        if(list.size()>0){
            list.remove(list.size()-1);
        }

        bt(lists,list,i+1,nums);
    }

    public static void main(String[] args) {
        Subsets s = new Subsets();
        int[] nums = {1,2,3};
        List<List<Integer>> ans = s.subsets(nums);
        System.out.println(ans);

        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> l = new ArrayList<>();
        l.add(1);
        l.add(2);
        l.add(3);
        lists.add(l);
        //System.out.println(lists);
        l.remove(2);
        //System.out.println(lists);
    }
}
