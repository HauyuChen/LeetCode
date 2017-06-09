242. Valid Anagram

Given two strings s and t, write a function to determine if t is an anagram of s.

For example,
s = "anagram", t = "nagaram", return true.
s = "rat", t = "car", return false.

Note:
You may assume the string contains only lowercase alphabets.

Follow up:
What if the inputs contain unicode characters? How would you adapt your solution to such case?




class Solution {
public:
    bool isAnagram(string s, string t) {
        if(s.size()!=t.size()){
            return false;
        }
        int arr[26];
        for(int i=0;i<26;++i){
            arr[i]=0;
        }
        for(int i=0;i<s.size();++i){
            ++arr[s[i]-'a'];
            --arr[t[i]-'a'];
        }
        for(int i=0;i<26;++i){
            if(arr[i]!=0){
                return false;
            }
        }
        return true;
    }
};