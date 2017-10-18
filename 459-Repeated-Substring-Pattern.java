459. Repeated Substring Pattern

Given a non-empty string check if it can be constructed by taking a substring of it and appending multiple copies of the substring together. You may assume the given string consists of lowercase English letters only and its length will not exceed 10000.

Example 1:
Input: "abab"

Output: True

Explanation: It's the substring "ab" twice.
Example 2:
Input: "aba"

Output: False
Example 3:
Input: "abcabcabcabc"

Output: True

Explanation: It's the substring "abc" four times. (And the substring "abcabc" twice.)



思路：
1. 先判断字符串s能切割成长度为多少的子串，比如s的长度为9，它只可能切割成长度为1、3的子串；
2. 根据步骤1，依次判断各种切割方式下，切割后的每个子串是否相等。




class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int len = s.length();
        
        if(len<2){
            return false;
        }
        
        for(int i=1;i<=len/2;i++){
            if(len%i!=0){
                continue;
            }
            
            String str1 = s.substring(0,i);
            boolean match = true;
            
            for(int j=i;j<len;j+=i){
                String str2 = s.substring(j,j+i);
                if(!(str1.equals(str2))){
                    match = false;
                    break;
                }
            }
            if(match==true){
                return true;
            }
        }   
        
        return false;
    }
}
