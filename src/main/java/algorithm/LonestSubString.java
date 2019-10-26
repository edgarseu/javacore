package algorithm;

/**
 * Created by Administrator on 2019/2/1.
 */
public class LonestSubString {
    public static void main(String[] args) {
        String s = "pwwkew";
        String  result  = solution(s);

        System.out.println(result);
    }

    private static String solution(String s) {
        if(s == null || s.isEmpty()){
            return s;
        }
        char[] sArr = s.toCharArray();
        int l = 0;
        int endIndex = 0;

        for (int i = 0; i < s.length(); i++) {
            for(int j = i+1; j< s.length()-1; j++){

                if(!s.substring(i,j+1).contains(String.valueOf(s.charAt(j)))){

                    endIndex = j-i + 1 > l ? j+1 : endIndex;
                    l = Math.max(l, j-i +1);
                } else {
                    break;
                }
            }
        }
        return s.substring(endIndex - l,endIndex);
    }
}
