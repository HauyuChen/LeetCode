26. Remove Duplicates from Sorted Array

Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.

Do not allocate extra space for another array, you must do this in place with constant memory.

For example,
Given input array nums = [1,1,2],

Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively. It doesn't matter what you leave beyond the new length.




思路：这道题比较简单，通过一个index表示结果数组（其实是同一个数组）的小标，将原数组的元素与结果数组比对，如果不同则加入结果数组，index++；如果相同则跳过。




class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
        if(nums.size()==0){
            return 0;
        }
        int index=1;
        for(int i=1;i<nums.size();i++){
            if(nums[i]!=nums[index-1]){
                nums[index] = nums[i];
                index++;
            }
        }
        return index;
    }
};