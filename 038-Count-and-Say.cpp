38. Count and Say

The count-and-say sequence is the sequence of integers with the first five terms as following:

1.     1
2.     11
3.     21
4.     1211
5.     111221

1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.
Given an integer n, generate the nth term of the count-and-say sequence.

Note: Each term of the sequence of integers will be represented as a string.

Example 1:

Input: 1
Output: "1"
Example 2:

Input: 4
Output: "1211"


思路：题目有点不好理解，大概的意思用口语读书。如，1读作“1”；2就是读1的数，“一个1”，也就是“11”；就是读2的数，“两个1”，也就是“21”；4就是读3的数，“一个2一个1”，也就是“1211”，以此类推，5读作“一个1一个2两个1”，也就是“111221”。最终，输出第n个的读法。




class Solution {
public:
    string countAndSay(int n) {
        string str = "1";     
        for(int i=1;i<n;i++){      
            string t="";
            for(int j=0;j<str.size();j++){
                int count=1;
                while(str[j]==str[j+1]&&j<str.size()-1){
                    count++;
                    j++;
                }
                t += to_string(count) + str[j];
            }
            str = t;
        }
        return str;
    }
};