66. Plus One

Given a non-negative integer represented as a non-empty array of digits, plus one to the integer.

You may assume the integer do not contain any leading zero, except the number 0 itself.

The digits are stored such that the most significant digit is at the head of the list.


思路：题目的意思是将数组当成一个整数，然后对这个整数加一，返回结果。比如[9,9,9]返回[1,0,0,0]；[9,9,8]返回[9,9,9]。

从数组最右边开始遍历：

1. 如果当前元素小于 8 ，则将当前元素加 1 后，直接返回数组 digits ；
2. 如果当前元素等于 9 ，将当前元素置为 0 ，继续判断；
3. 若遍历结束还没返回结果，说明数组 digits 内的元素全为 9 ，则创建一个新的数组，首位为 1 ，其余位为 0 ，返回新数组。


class Solution {
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        if(len==0){
            return digits;
        }
        for(int i=len-1;i>=0;i--){
            if(digits[i]<9){
                digits[i]++;
                return digits;
            }else{
                digits[i] = 0;
            }
        }
        int[] ret = new int[len+1];
        ret[0] = 1;
        return ret;
    }
}