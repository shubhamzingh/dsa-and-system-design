package leetcode.string;

public class LongestSubstringWithoutRepeatingChar {
    public int lengthOfLongestSubstring(String s) {
        if(s.equals(" ")){
            return 1;
        }
        char[] input = s.toCharArray();
        String temp ="";
        String res="";
        for(int i=0; i<input.length; i++){
            //start window, keeping adding at end
            // when same char found, compare lenfth with string and keep the longest one.
            //move the start to the first occurence of this repeated char.
            // use a char array to store the index.

            if(temp.indexOf(input[i])>-1){
                res = (temp.length() > res.length()) ? temp :res;
                while(temp.indexOf(input[i])>-1){
                    temp=temp.substring(1,temp.length());
                }

            }
            temp+=input[i];
        }
        return Math.max(temp.length(),res.length());
    }
}
