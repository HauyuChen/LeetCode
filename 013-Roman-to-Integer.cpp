13. Roman to Integer

Given a roman numeral, convert it to an integer.

Input is guaranteed to be within the range from 1 to 3999.





class Solution {
public:
    int romanToInt(string s) {
        unordered_map<char,int> hm;
        hm.insert(pair<char,int>('I',1));
        hm.insert(pair<char,int>('V',5));
        hm.insert(pair<char,int>('X',10));
        hm.insert(pair<char,int>('L',50));
        hm.insert(pair<char,int>('C',100));
        hm.insert(pair<char,int>('D',500));
        hm.insert(pair<char,int>('M',1000));
        int sum=hm[s[s.size()-1]];
        for(int i=s.size()-1;i>0;--i){
            if(hm[s[i]]>hm[s[i-1]]){
                sum-=hm[s[i-1]];
            }else{
                sum+=hm[s[i-1]];
            }
        }
        return sum;
    }
};