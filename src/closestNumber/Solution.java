package closestNumber;

/**
 * Created by luoxinyu-xy on 2017/6/18.
 */
public class Solution {
    public static void main(String args[]){
        int[] A = {1,3,3,4};
        int target = 2;

        Solution closestNum = new Solution();
        int closest = closestNum.closest(A,target);

        System.out.println(closest);

    }

    private int closest (int[] A, int target){
        if (A == null || A.length == 0){
            return -1;
        }

        int start = 0,end = A.length - 1,mid;
        while (start + 1 < end){
            mid = start + (end - start)/2;
            if(A[mid] == target){
                return mid;
            }else if(Math.abs(A[mid + 1] - target) > Math.abs(A[mid - 1] - target)){
                end = mid;
            }else{
                start = mid;
            }

        }

        if(Math.abs(end - target) > Math.abs(start - target)){
            return start;
        }else{
            return end;
        }

    }
}
