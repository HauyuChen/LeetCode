557. Reverse Words in a String III

Given a string, you need to reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.

Example 1:
Input: "Let's take LeetCode contest"
Output: "s'teL ekat edoCteeL tsetnoc"
Note: In the string, each word is separated by single space and there will not be any extra space in the string.





class Solution {
public:
    string reverseWords(string s) {
        vector<int> stack;
        int index = 0;
        
        for(int i=0;i<s.length();i++){
            if(s[i]!=' '){
                stack.push_back(s[i]);
            }else{
                while(!stack.empty()){
                    s[index++]=stack.back();
                    stack.pop_back();
                }
                s[index++]=' ';
            }
        }
        while(!stack.empty()){
            s[index++]=stack.back();
            stack.pop_back();
        }
        s[index++]='\0';
        return s;
    }
};