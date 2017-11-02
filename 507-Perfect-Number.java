507. Perfect Number

We define the Perfect Number is a positive integer that is equal to the sum of all its positive divisors except itself.

Now, given an integer n, write a function that returns true when it is a perfect number and false when it is not.
Example:
Input: 28
Output: True
Explanation: 28 = 1 + 2 + 4 + 7 + 14
Note: The input number n will not exceed 100,000,000. (1e8)


思路：本题不能简单的遍历解决，否则会超时。
1. num 小于 1 时，都不符合要求，直接返回 false ；
2. 直接从 i = 2 开始遍历，直到 i * i = num ，也就是最多根号 num 次就可以得出结果；
3. 当 i 是 num 的正因子时，则 sum += i + num/i ，因为 num/i 也是 num 的正因子。
4. 比较 sum 是否等于 num ，返回结果。


class Solution {
    public boolean checkPerfectNumber(int num) {
        if(num<=1){
            return false;
        }
        
        int sum = 1;
        int i;
        
        for(i=2;i*i<num;i++){
            if(num%i==0){
                sum += i + num/i;
            }
        }
        
        if(i*i==num){
            sum += i;
        }
        
        return sum==num?true:false;    
    }
}

