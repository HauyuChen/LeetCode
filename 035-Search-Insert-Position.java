35. Search Insert Position

Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.

Here are few examples.
[1,3,5,6], 5 → 2
[1,3,5,6], 2 → 1
[1,3,5,6], 7 → 4
[1,3,5,6], 0 → 0



思路：大水题，通过二分查找实现。

注意：如果数组中找不到 target 。
1. 要么 target 比当前元素小，返回当前元素的位置（mid）。因为数组后移，当前位置存放 target ；
2. 要么 target 比当前元素大，返回当前元素的位置的后一个位置（mid+1）。



class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        int mid = 0;
        
        while(left<=right){
            mid = (left+right)/2;
            if(nums[mid]==target){
                return mid;
            }else if(nums[mid]>target){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        
        return nums[mid]>target?mid:mid+1;
    }
}