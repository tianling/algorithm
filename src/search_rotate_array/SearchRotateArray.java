package search_rotate_array;

/**
 * Created by luoxinyu-xy on 2017/7/13.
 */
public class SearchRotateArray {

    public static void main(String args[]) {
        int nums[] = {11,12,56,1,3,4,5};
        SearchRotateArray search = new SearchRotateArray();

        int min = search.findMin(nums);
        int find = search.searchTarget(nums,12);

        System.out.println(min);
        System.out.println(find);
    }

    /*
    * 查找最小值
    * */
    public int findMin(int nums[]) {
        if(nums == null || nums.length == 0) {
            return -1;
        }

        int start = 0, end = nums.length - 1;
        int target = nums[nums.length - 1];//target为较小增序序列最大值

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

    }

    /*
    * 旋转数组查找目标值
    * 关键在于找到纯递增序列
    * */
    public int searchTarget(int[] A, int target) {
        if (A == null || A.length == 0) {
            return -1;
        }

        int start = 0, end = A.length - 1;
        int mid;

        while (start + 1 < end) {
            mid = start + (end - start) / 2;

            if (A[mid] == target) {
                return mid;
            }

            if (A[start] < A[mid]) { //start到mid之间为纯递增序列
                if (A[start] <= target && target <= A[mid]) {
                    end = mid;
                }else{
                    start = mid;
                }
            }else{
                if (A[mid] <= target && target <= A[end]) { //mid右侧为纯递增序列
                    start = mid;
                } else {
                    end = mid;
                }
            }
        }

        if (A[start] == target) {
            return start;
        }else if (A[end] == target) {
            return end;
        }

        return -1;

    }
}
