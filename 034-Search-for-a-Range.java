34. Search for a Range

Given an array of integers sorted in ascending order, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

For example,
Given [5, 7, 7, 8, 8, 10] and target value 8,
return [3, 4].



思路：本题要求时间复杂度为O(logn)，自然应该想到二分查找，先找到target的位置，再分别从前从后找首尾位置即可，这是简单明了的解法。注：在找到target后继续二分查找首尾出现的位置效率会更高一些。



class Solution {
    public int[] searchRange(int[] nums, int target) {
        int ret[] = {-1,-1};
        int left=0,right=nums.length-1;
        int mid;
        
        while(left<=right){
            mid = (right+left)/2;
            if(nums[mid]==target){
                int l=mid,r=mid;
                while(l>=0 && nums[l]==target){
                    l--;
                }
                while(r<=nums.length-1 && nums[r]==target){
                    r++;
                }
                ret[0] = l+1;
                ret[1] = r-1;
                return ret;
            }else{
                if(nums[mid]<target){
                    left = mid+1;
                }else{
                    right = mid-1;
                }
            }
        }
        
        return ret;
    }
}