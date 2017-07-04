537. Complex Number Multiplication

Given two strings representing two complex numbers.

You need to return a string representing their multiplication. Note i2 = -1 according to the definition.

Example 1:
Input: "1+1i", "1+1i"
Output: "0+2i"
Explanation: (1 + i) * (1 + i) = 1 + i2 + 2 * i = 2i, and you need convert it to the form of 0+2i.
Example 2:
Input: "1+-1i", "1+-1i"
Output: "0+-2i"
Explanation: (1 - i) * (1 - i) = 1 + i2 - 2 * i = -2i, and you need convert it to the form of 0+-2i.
Note:

The input strings will not have extra blank.
The input strings will be given in the form of a+bi, where the integer a and b will both belong to the range of [-100, 100]. And the output should be also in this form.




class Solution {
public:
    string complexNumberMultiply(string a, string b) {
        int a1=0;
        int a2=0;
        int b1=0;
        int b2=0;
        int indexa=0;
        int indexb=0;
        bool minusa1=false;
        bool minusa2=false;
        bool minusb1=false;
        bool minusb2=false;
        string ret="";
        
        if(a[0]=='-'){
            minusa1=true;
            indexa++;
        }
        if(b[0]=='-'){
            minusb1=true;
            indexb++;
        }
        
        while(a[indexa]!='+'){
            a1 = a1*10+(a[indexa]-'0');
            indexa++;
        }
        while(b[indexb]!='+'){
            b1 = b1*10+(b[indexb]-'0');
            indexb++;
        }
        a1=minusa1==true?(0-a1):a1;
        b1=minusb1==true?(0-b1):b1;
        
        indexa++;
        indexb++;

        if(a[indexa]=='-'){
            minusa2=true;
            indexa++;
        }
        if(b[indexb]=='-'){
            minusb2=true;
            indexb++;
        }
        while(a[indexa]!='i'){
            a2 = a2*10+(a[indexa]-'0');
            indexa++;
        }
        while(b[indexb]!='i'){
            b2 = b2*10+(b[indexb]-'0');
            indexb++;
        }
        a2=minusa2==true?(0-a2):a2;
        b2=minusb2==true?(0-b2):b2;
        cout<<a1<<a2<<b1<<b2;
        
        ret.append(to_string(a1*b1-a2*b2));
        ret.append("+");
        ret.append(to_string(a1*b2+b1*a2));
        ret.append("i");
        return ret;
    }
};