415. Add Strings

Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.

Note:

The length of both num1 and num2 is < 5100.
Both num1 and num2 contains only digits 0-9.
Both num1 and num2 does not contain any leading zero.
You must not use any built-in BigInteger library or convert the inputs to integer directly.





class Solution {
public:
    string addStrings(string num1, string num2) {
        string str;
        int index1=num1.size()-1;
        int index2=num2.size()-1;
        int flag=0;
        int num;
        while(index1>=0&&index2>=0){
            num=(num1[index1--]-'0')+(num2[index2--]-'0')+flag;
            if(num>9){
                flag=1;
                str.append(to_string(num%10));
            }else{
                flag=0;
                str.append(to_string(num));
            }
        }
        while(index1>=0){
            num=num1[index1--]-'0'+flag;
            if(num>9){
                flag=1;
                str.append(to_string(num%10));
            }else{
                flag=0;
                str.append(to_string(num));
            }
        }
        while(index2>=0){
            num=num2[index2--]-'0'+flag;
            if(num>9){
                flag=1;
                str.append(to_string(num%10));
            }else{
                flag=0;
                str.append(to_string(num));
            }
        }
        if(flag==1){
            str.append(to_string(1));
        }
        reverse(str.begin(),str.end());
        return str;
    }
};