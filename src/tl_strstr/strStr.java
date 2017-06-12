package tl_strstr;

/**
 * Created by luoxinyu-xy on 2017/6/12.
 */
public class strStr {

    public static void main(String args[]){
        String source = "tartarget";
        String target = "t6";

        tl_strstr.strStr strFetch = new tl_strstr.strStr();
        int result = strFetch.strFetch(source,target);

        System.out.print(result);

    }

    private int strFetch(String source,String target){
        if(source == null || target == null || target.length() > source.length()){
            return  -1;
        }else if (target.length() == 0) {
            return  0;
        }

        int position = 0;
        for(int i = 0; i<source.length();i++){

            int begin = i;
            int fetch = 0;
            for(int k = 0;k<target.length();k++){
                if (begin >= source.length()) {
                    return -1;
                }

                if(target.charAt(k) == source.charAt(begin)){
                    begin++;
                    fetch++;

                }else{
                    if(source.length() - begin < target.length()){
                        return -1;
                    }

                    position++;
                    break;
                }

                if(fetch == target.length()){
                    return position;
                }
            }
        }

        return  -1;

    }
}
