409. Longest Palindrome

Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can be built with those letters.

This is case sensitive, for example "Aa" is not considered a palindrome here.

Note:
Assume the length of given string will not exceed 1,010.

Example:

Input:
"abccccdd"

Output:
7

Explanation:
One longest palindrome that can be built is "dccaccd", whose length is 7.





class Solution {
public:
    int longestPalindrome(string s) {
        int alph[52];
        for(int i=0;i<52;++i){
            alph[i]=0;
        }
        for(int i=0;i<s.size();++i){
            if(s[i]>='A'&&s[i]<='Z'){
                ++alph[s[i]-'A'+26];
            }else{
                ++alph[s[i]-'a'];
            }
        }
        int flag=0;
        int sum=0;
        for(int i=0;i<52;++i){
            if(flag==0){
                if(alph[i]&1==1){
                    flag=1;
                }
            }
            sum+=alph[i]/2;
        }
        sum=2*sum+flag;
        return sum;
    }
};






