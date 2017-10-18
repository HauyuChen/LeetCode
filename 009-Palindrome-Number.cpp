9. Palindrome Number

Determine whether an integer is a palindrome. Do this without extra space.

click to show spoilers.

Some hints:
Could negative integers be palindromes? (ie, -1)

If you are thinking of converting the integer to string, note the restriction of using extra space.

You could also try reversing an integer. However, if you have solved the problem "Reverse Integer", you know that the reversed integer might overflow. How would you handle such case?

There is a more generic way of solving this problem.



思路：
1. 本方法只需判断x的前(n/2)位是否等于x的后(n/2)位的逆序，是则为回文数，否则不是回文数；
2. 当x的位数为偶数，则判断x是否等t；当x的位数为奇数，t的位数比x大一位，则判断x是是否等于t/10。


class Solution {
public:
    bool isPalindrome(int x) {
        if(x<0||(x!=0&&x%10==0)){
            return false;
        }
        int t=0;
        while(x>t){
            t = 10*t+x%10;
            x /= 10;
        }
        return (x==t)||(x==t/10);
    }
};