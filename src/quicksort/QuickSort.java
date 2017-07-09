package quicksort;

import java.util.Arrays;

/**
 * Created by tianling on 17/6/27.
 */
public class QuickSort {
    public static void main(String args[]) {

        int[] A = {1,4,5,3,7,9};
        System.out.println(Arrays.toString(A));

        QuickSort quick = new QuickSort();
        quick.Qsort(A,0,A.length - 1);

        System.out.println(Arrays.toString(A));

    }


    private void Qsort(int[] A, int start, int end) {

        if (start >= end) {
            return;
        }

        int left = start, right = end;
        int pivot = A[(start + end) / 2];

        while (left <= right) {

            while (left <= right && pivot > A[left]) {
                left++;
            }

            while (left <= right && pivot < A[right]) {
                right--;
            }

            if (left <= right) {
                int temp = A[left];
                A[left] = A[right];
                A[right] = temp;

                left++;
                right--;
            }

            Qsort(A,start,right);
            Qsort(A,left,end);

        }

    }
}