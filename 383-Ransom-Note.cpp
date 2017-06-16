383. Ransom Note

Given an arbitrary ransom note string and another string containing letters from all the magazines, write a function that will return true if the ransom note can be constructed from the magazines ; otherwise, it will return false.

Each letter in the magazine string can only be used once in your ransom note.

Note:
You may assume that both strings contain only lowercase letters.

canConstruct("a", "b") -> false
canConstruct("aa", "ab") -> false
canConstruct("aa", "aab") -> true






class Solution {
public:
    bool canConstruct(string ransomNote, string magazine) {
        if(magazine.size()<ransomNote.size()){
            return false;
        }
        vector<int> alp(26,0);
        for(int i=0;i<magazine.size();i++){
            alp[magazine[i]-'a']++;
        }
        
        for(int i=0;i<ransomNote.size();i++){
            if(alp[ransomNote[i]-'a']!=0){
                alp[ransomNote[i]-'a']--;
            }else{
                return false;
            }
            
        }
        return true;
    }
};