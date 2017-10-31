238. Product of Array Except Self

Given an array of n integers where n > 1, nums, return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

Solve it without division and in O(n).

For example, given [1,2,3,4], return [24,12,8,6].

Follow up:
Could you solve it with constant space complexity? (Note: The output array does not count as extra space for the purpose of space complexity analysis.)




思路：注意陷阱，要考虑完全。
1. nums数组全为0；
2. nums数组只有一个元素为0；
3. nums数组有两个以上元素为0；
4. nums数组全不为0。

这里用count来计数，分别处理不同的情况。



class Solution {
    public int[] productExceptSelf(int[] nums) {
        int p = 1;
        int count = 0;
        int len = nums.length;
        int t[] = new int[len];
        
        for(int num:nums){
            if(num!=0){
                p *= num;
            }else{
                count++;
            }
        }
        if(count==len){
            return nums;
        }
        
        for(int i=0;i<len;i++){
            if(nums[i]==0){
                t[i] = count>1?0:p;
                return t;
            }
            nums[i] = p/nums[i];
        }
        
        return nums;
    }
}