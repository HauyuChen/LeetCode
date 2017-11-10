58. Length of Last Word

Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.

If the last word does not exist, return 0.

Note: A word is defined as a character sequence consists of non-space characters only.

Example:

Input: "Hello World"
Output: 5

思路：

从后往前遍历字符串。

1. 注意字符串后面是否有空格，所以先判断字符串是否以空格结尾；
2. 若当前字符不是空格，开始计数，直到遇到空格，返回计数的结果。


class Solution {
    public int lengthOfLastWord(String s) {
        int count = 0;
        int i = s.length()-1;
        
        while(i>=0&&s.charAt(i)==' '){
            i--;
        }
        while(i>=0&&s.charAt(i)!=' '){
            i--;
            count++;
        }
        
        return count;
    }
}