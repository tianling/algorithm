package findpeak;

/**
 * Created by luoxinyu-xy on 2017/7/14.
 */

public class findPeak {

    public static void main(String args[]) {
        int[] A = {1,2,1,3,4,5,7,6};
        findPeak find = new findPeak();

        int peak = find.findSolution(A);

        System.out.println(peak);
    }

    public int findSolution(int[] A) {
        if (A == null || A.length == 0) {
            return -1;
        }

        int start = 1, end = A.length - 2;//边界点不做考虑
        while (start + 1 < end) {
            int mid = (start + end) / 2;
            if (A[mid] < A[mid - 1]) {
                end = mid;
            } else if (A[mid] < A[mid + 1]) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if(A[start] < A[end]){
            return end;
        }else{
            return start;
        }

    }
}
