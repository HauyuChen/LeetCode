504. Base 7

Given an integer, return its base 7 string representation.

Example 1:
Input: 100
Output: "202"
Example 2:
Input: -7
Output: "-10"
Note: The input will be in range of [-1e7, 1e7].






class Solution {
public:
    string convertToBase7(int num) {
        string str="";
        int nega=0;
        if(num<0){
            nega = 1;
            num = abs(num);
        }
        while(num/7){
            str+=to_string(num%7);
            num/=7;
        }
        str+=to_string(num%7);
        if(nega){
            str+="-";
        }
        reverse(str.begin(),str.end());
        return str;
    }
};