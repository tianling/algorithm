package lastPosition;

/**
 * Created by luoxinyu-xy on 2017/6/18.
 */
public class LastPosition {
    public static void main(String args[]) {
        int[] nums = {1,2,2,4,5,5};
        int target = 2;

        LastPosition lp = new LastPosition();
        int position = lp.lastPosition(nums,target);

        System.out.println(position);
    }

    private int lastPosition(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int start = 0,end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start)/2;
            if (nums[mid] <= target){
                start = mid;
            }else {
                end = mid;
            }
        }

        if(nums[end] == target){
            return end;
        }else if(nums[start] == target){
            return start;
        }else {
            return -1;
        }
    }
}
