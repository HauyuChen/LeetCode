75. Sort Colors

Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Note:
You are not suppose to use the library's sort function for this problem.


思路：
本题实质上为三元数组排序。
1. 解法一：借助辅助数组，轻松解决。虽然时间复杂度为 O(n) ，但空间复杂度也为 O(n)；
2. 解法二：不借助辅助数组，直接在原数组进行元素交换。时间复杂度 O(n) ，空间复杂度 O(1)。


class Solution {
    public void sortColors(int[] nums) {
        int len = nums.length;
        int[] ret = new int[len];
        int l = 0;
        int r = len-1;
        
        for(int i=0;i<len;i++){
            ret[i] = 1;
        }
        
        for(int i=0;i<len;i++){
            if(nums[i]==0){
                ret[l] = 0;
                l++;
            }else if(nums[i]==2){
                ret[r] = 2;
                r--;
            }
        }
        
        for(int i=0;i<len;i++){
            nums[i] = ret[i];
        }
    }
}



class Solution {
    public void sortColors(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        int index = 0;
        
        while(index<=right){
            if(nums[index]==0){
                swap(nums,left,index);
                index++;
                left++;
            }else if(nums[index]==2){
                swap(nums,index,right);
                right--;
            }else{
                index++;
            }
        }
    }
    
    private void swap(int[] nums,int l,int r){
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }
}