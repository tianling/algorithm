package searchMatrix;

/**
 * Created by luoxinyu-xy on 2017/6/19.
 */
public class SearchMatrix {

       public static void main(String args[]) {

           int[][] matrix = {{1,2,3,4},{5,7,8,10},{13,56,78,99,344}};
           int target = 78;

           SearchMatrix seMa = new SearchMatrix();
           boolean search = seMa.solution(matrix, target);

           System.out.println(search);

       }

       private boolean solution(int[][] matrix, int target) {
            if (matrix == null || matrix.length == 0){
                return false;
            }

            if (matrix[0] == null || matrix[0].length == 0) {
                return false;
            }

            int row = matrix.length;
            int column = matrix[0].length;

            int start = 0,end = row - 1;
            while (start + 1 < end){
                int mid = start + (end - start) / 2;

                if (matrix[mid][0] == target) {
                    return true;

                }else if(matrix[mid][0] > target) {
                    end = mid;
                }else{
                    start = mid;
                }
            }

            if (matrix[end][0] <= target){
                row = end;
            }else if(matrix[start][0] <= target){
                row = start;
            }else{
                return false;
            }

            start = 0;
            end = column - 1;
            while (start + 1 <end) {
                int mid = start + (end - start) / 2;

                if (matrix[row][mid] == target) {
                    return true;
                } else if (matrix[row][mid] < target) {
                    start = mid;
                }else{
                    end = mid;
                }
            }

            if (matrix[row][end] == target) {
                return true;
            } else if(matrix[row][start] == target) {
                return  true;
            }

            return false;


       }
}
