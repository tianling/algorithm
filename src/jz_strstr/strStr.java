package jz_strstr;

/**
 * Created by tianling on 17/6/13.
 */
public class strStr {
    public static void main(String args[]){
        String source = "a";
        String target = "a";

        strStr strFetch = new strStr();
        int result = strFetch.strFetch(source,target);

        System.out.println(result);

    }


    private int strFetch(String source,String target){
        if (source == null || target == null) {
            return -1;
        }

        for (int i = 0; i < source.length() - target.length() + 1; i++) {
            int j;
            for (j = 0; j < target.length(); j++) {
                if (source.charAt(j + i) != target.charAt(j)) {
                    break;
                }
            }

            if (j == target.length()) {
                return i;
            }

        }

        return -1;

    }
}
