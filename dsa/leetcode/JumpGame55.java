package dsa.leetcode;

import java.util.ArrayList;
import java.util.List;

public class JumpGame55 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> combinationList = new ArrayList<>();
        List<Integer> combination = new ArrayList<>();

        addCombinations(combinationList, combination, target,candidates,0);

        return combinationList;

    }

    private void addCombinations(List<List<Integer>> combinationList, List<Integer> combination,
                                 int target, int[] nums, int i){
        if(i>=nums.length){
            if(combination.size()>0)
            combination.remove(combination.size()-1);
            return;
        }

        //combination.add(nums[i]);
        //target-=nums[i];
        if(target<0){
            combination.remove(combination.size()-1);
            //target+=nums[i];
            return;
        }
        else if(target==0){
            // copy entire list to a new list and add that to the combination list
            List ans = new ArrayList(combination);
            combinationList.add(ans);

            combination.remove(combination.size()-1);
            return;
        }

        //select the current item
        combination.add(nums[i]);
        addCombinations(combinationList, combination, target-nums[i],nums,i);
        // dont select
        //combination.remove(combination.size()-1);
        addCombinations(combinationList, combination, target,nums,++i);

    }
    public static void main(String[] args) {
        /*List<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(2);
        a.add(3);
        a.add(1);

        a.remove(a.size()-1);
        for(Integer i : a){
            System.out.println("a "+ i);
        }*/
        int[] c  = {2,3,6,7};
        JumpGame55 j = new JumpGame55();
        j.combinationSum(c,7);
    }
}
