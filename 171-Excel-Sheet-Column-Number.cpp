171. Excel Sheet Column Number

Related to question Excel Sheet Column Title

Given a column title as appear in an Excel sheet, return its corresponding column number.

For example:

    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28 
Credits:
Special thanks to @ts for adding this problem and creating all test cases.









class Solution {
public:
    int titleToNumber(string s) {
        int sum=0;
        for(int i=0;i<s.length();i++){
            sum = sum*26+(s[i]-'A'+1);
        }
        return sum;
    }
};