541. Reverse String II

Given a string and an integer k, you need to reverse the first k characters for every 2k characters counting from the start of the string. If there are less than k characters left, reverse all of them. If there are less than 2k but greater than or equal to k characters, then reverse the first k characters and left the other as original.
Example:
Input: s = "abcdefg", k = 2
Output: "bacdfeg"
Restrictions:
The string consists of lower English letters only.
Length of the given string and k will in the range [1, 10000]




class Solution {
public:
    string reverseStr(string s, int k) {
        int start=0,end=s.size()-1;
        while((end-start+1)>(2*k)){
            reverse(s.begin()+start,s.begin()+start+k);
            start+=2*k;
        }
        if(end-start+1>=k){
            reverse(s.begin()+start,s.begin()+start+k);
        }else{
            reverse(s.begin()+start,s.end());
        }
        return s;
    }
};