6. ZigZag Conversion

The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"
Write the code that will take a string and make this conversion given a number of rows:

string convert(string text, int nRows);
convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".





class Solution {
public:
    string convert(string s, int numRows) {
        if(numRows==1){
            return s;
        }
        
        string ret="";
        int dist1 = numRows*2-2;
        
        for(int i=0;i<s.size();i+=dist1){
            ret+=s[i];
        }
        for(int i=1;i<numRows-1;i++){
            int dist2 = i*2;
            for(int j=i;j<s.size();j+=dist2){
                ret+=s[j];
                dist2 = dist1-dist2;
            }
            
        }
        for(int i=numRows-1;i<s.size();i+=dist1){
            ret+=s[i];
        }
        return ret;
    }
};