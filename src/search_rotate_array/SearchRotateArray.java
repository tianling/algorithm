package search_rotate_array;

/**
 * Created by luoxinyu-xy on 2017/7/13.
 */
public class SearchRotateArray {

    public static void main(String args[]) {
        int nums[] = {11,12,56,1,3,4,5};
        SearchRotateArray search = new SearchRotateArray();

        int min = search.findMin(nums);

        System.out.println(min);
    }

    public int findMin(int nums[]) {
        if(nums == null || nums.length == 0) {
            return -1;
        }

        int start = 0, end = nums.length - 1;
        int target = nums[nums.length - 1];

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if(nums[mid] <= target) {
                end = mid;
            }else{
                start = mid;
            }
        }

        if(nums[start] <= nums[end]){
            return nums[start];
        }else {
            return nums[end];
        }

//        if(nums[start] <= target) {
//            return nums[start];
//        } else {
//            return nums[end];
//        }
    }
}
