27. Remove Element

Given an array and a value, remove all instances of that value in place and return the new length.

Do not allocate extra space for another array, you must do this in place with constant memory.

The order of elements can be changed. It doesn't matter what you leave beyond the new length.

Example:
Given input array nums = [3,2,2,3], val = 3

Your function should return length = 2, with the first two elements of nums being 2.




思路：设置index=0；从头开始遍历，当前元素不为val，则将当前元素存在在index位置，index++；

class Solution {
public:
    int removeElement(vector<int>& nums, int val) {
        int index=0;
        for(int j=0;j<nums.size();j++){
            if(nums[j]!=val){
                nums[index]=nums[j];
                index++;
            }
        }
        return index;
    }
};