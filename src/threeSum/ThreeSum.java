package threeSum;

import java.util.*;

public class ThreeSum {
    public static void main(String[] args) {
        int[] nums = new int[]{0,0,0,0};
        ThreeSum threeSum = new ThreeSum();

        List<List<Integer>> res = threeSum.solution(nums);
        System.out.println(res.toString());
    }

    public List<List<Integer>> solution(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 3) {
            return res;
        }
        Arrays.sort(nums);

        for (int first = 0; first < nums.length; first++) {
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }

            for (int second = first + 1; second < nums.length; second++) {
                if (second != first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }

                int third = nums.length - 1;
                while (nums[first] + nums[second] + nums[third] > 0 && third > second) {
                    third--;
                }

                if (nums[first] + nums[second] + nums[third] == 0 && third > second) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    res.add(list);
                }
            }
        }

        return res;
    }
}
