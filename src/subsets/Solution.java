package subsets;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by luoxinyu-xy on 2017/6/13.
 */
public class Solution {
    public static void main(String args[]){
        int[] nums = {1,2,3};

        Solution solution = new Solution();
        ArrayList<ArrayList<Integer>> result = solution.subsets(nums);

        System.out.println(result);
    }

    private ArrayList<ArrayList<Integer>> subsets(int[] nums){
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (nums == null) {
            return result;
        }

        if(nums.length == 0){
            result.add(new ArrayList<Integer>());
            return  result;
        }

        Arrays.sort(nums);
        helper(new ArrayList<Integer>(),nums,0,result);

        return result;
    }

    private void helper(ArrayList<Integer> subset,
                        int nums[],
                        int startIndex,
                        ArrayList<ArrayList<Integer>> result
                        ) {

        result.add(new ArrayList<Integer>(subset));

        for (int i = startIndex;i<nums.length;i++) {
            subset.add(nums[i]);

            helper(subset,nums,i+1,result);

            subset.remove(subset.size() - 1);
        }


    }
}
