package mountainSequence;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

/**
 * Created by luoxinyu-xy on 2017/6/20.
 */
public class mountainSequence {
    public static void main(String args[]){
        int[] nums = {1,2,4,8,6,3};

        mountainSequence mountain = new mountainSequence();
        int seq = mountain.Solution(nums);

        System.out.println(seq);
    }

    private int Solution (int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int start = 0,end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] > nums[mid + 1]) {
                end = mid;
            }else{
                start = mid;
            }
        }

        return Math.max(nums[start],nums[end]);

    }
}
