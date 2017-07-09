package combinatonsum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by tianling on 17/6/26.
 */
public class combinationSum {
    public static void main(String args[]) {

        int[] candidates = {5,4,32,77,8};

        int target = 4;

        combinationSum comb = new combinationSum();
        comb.solution(candidates,target);
    }

    public List<List<Integer>> solution(int[] candidates, int target) {

        List<List<Integer>> result = new ArrayList<>();

        if (candidates == null || candidates.length == 0) {
            return result;
        }


        removeDuplicates(candidates);


        System.out.println(Arrays.toString(candidates));

        return result;
    }

    private int[] removeDuplicates(int[] candidates) {
        Arrays.sort(candidates);



        return candidates;
    }

 }
