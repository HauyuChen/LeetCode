<<<<<<< HEAD
7. Reverse Integer


Reverse digits of an integer.

Example1: x = 123, return 321
Example2: x = -123, return -321

click to show spoilers.

Have you thought about this?
Here are some good questions to ask before coding. Bonus points for you if you have already thought through this!

If the integer's last digit is 0, what should the output be? ie, cases such as 10, 100.

Did you notice that the reversed integer might overflow? Assume the input is a 32-bit integer, then the reverse of 1000000003 overflows. How should you handle such cases?

For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.

Note:
The input is assumed to be a 32-bit signed integer. Your function should return 0 when the reversed integer overflows.



思路：
本题重要是溢出问题，通过long long来避免运算过程中导致溢出，最终判断结果时候大于INT_MAX或INT_MIN判断溢出。



class Solution {
public:
    int reverse(int x) {
        int minus = 0;
        if(x<0){
            minus = 1;
            x = 0-x;
        }
        
        long long t=0;
        while(x!=0){
            t = x%10+10*t;
            x/=10;
        }
        
        t = minus==1?(0-t):t;
        
        return (t>INT_MAX||t<INT_MIN)?0:t;
    }
=======
7. Reverse Integer


Reverse digits of an integer.

Example1: x = 123, return 321
Example2: x = -123, return -321

click to show spoilers.

Have you thought about this?
Here are some good questions to ask before coding. Bonus points for you if you have already thought through this!

If the integer's last digit is 0, what should the output be? ie, cases such as 10, 100.

Did you notice that the reversed integer might overflow? Assume the input is a 32-bit integer, then the reverse of 1000000003 overflows. How should you handle such cases?

For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.

Note:
The input is assumed to be a 32-bit signed integer. Your function should return 0 when the reversed integer overflows.



思路：
本题重要是溢出问题，通过long long来避免运算过程中导致溢出，最终判断结果时候大于INT_MAX或INT_MIN判断溢出。



class Solution {
public:
    int reverse(int x) {
        int minus = 0;
        if(x<0){
            minus = 1;
            x = 0-x;
        }
        
        long long t=0;
        while(x!=0){
            t = x%10+10*t;
            x/=10;
        }
        
        t = minus==1?(0-t):t;
        
        return (t>INT_MAX||t<INT_MIN)?0:t;
    }
>>>>>>> 900eda1353bac26c39cf9c872352fef166197abb
};