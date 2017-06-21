500. Keyboard Row

Given a List of words, return the words that can be typed using letters of alphabet on only one row's of American keyboard like the image below.


American keyboard


Example 1:
Input: ["Hello", "Alaska", "Dad", "Peace"]
Output: ["Alaska", "Dad"]
Note:
You may use one character in the keyboard more than once.
You may assume the input string will only contain letters of alphabet.






class Solution {
public:
    vector<string> findWords(vector<string>& words) {
        unordered_set<char> row1 = {'q','w','e','r','t','y','u','i','o','p'};
        unordered_set<char> row2 = {'a','s','d','f','g','h','j','k','l'};
        unordered_set<char> row3 = {'z','x','c','v','b','n','m'};
        vector<string> res;
        
        for(string word:words){
            int flag1=0;
            int flag2=0;
            int flag3=0;
            for(char ch:word){
                if(row1.count(ch)){
                    flag1 = 1;
                }
                if(row2.count(ch)){
                    flag2 = 1;
                }
                if(row3.count(ch)){
                    flag3 = 1;
                }
            }
            if(flag1+flag2+flag3==1){
                res.push_back(word);
            }
        }
        return res;
    }
};