169. Majority Element

Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

You may assume that the array is non-empty and the majority element always exist in the array.






class Solution {
public:
    int majorityElement(vector<int>& nums) {
        int major=nums[0];
        int cnt=1;
        for(int num:nums){
            if(num==major){
                ++cnt;
            }else{
                --cnt;
            }
            if(cnt==0){
                ++cnt;
                major = num;
            }
        }
        return major;
    }
};