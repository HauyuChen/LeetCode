551. Student Attendance Record IYou are given a string representing an attendance record for a student. The record only contains the following three characters:

'A' : Absent.
'L' : Late.
'P' : Present.
A student could be rewarded if his attendance record doesn't contain more than one 'A' (absent) or more than two continuous 'L' (late).

You need to return whether the student could be rewarded according to his attendance record.

Example 1:
Input: "PPALLP"
Output: True
Example 2:
Input: "PPALLL"
Output: False




class Solution {
public:
    bool checkRecord(string s) {
        int a=0,l=0;
        for(int i=0;i<s.size();++i){
            if(s[i]=='L'){
                l++;
                if(l>2) return false;
            }else{
                l=0;
            }
            if(s[i]=='A'){
                a++;
                if(a>1) return false;
            }
        }
        return true;
    }
};