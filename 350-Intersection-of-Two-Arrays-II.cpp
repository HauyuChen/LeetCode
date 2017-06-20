350. Intersection of Two Arrays II

Given two arrays, write a function to compute their intersection.

Example:
Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].

Note:
Each element in the result should appear as many times as it shows in both arrays.
The result can be in any order.
Follow up:
What if the given array is already sorted? How would you optimize your algorithm?
What if nums1's size is small compared to nums2's size? Which algorithm is better?
What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?







class Solution {
public:
    vector<int> intersect(vector<int>& nums1, vector<int>& nums2) {
        vector<int> ret;
        if (nums1.size() == 0 || nums2.size() == 0) {
            return ret;
        }
        unordered_map<int,int> hm;
        for(int num1:nums1){
            hm[num1]++;
        }
        for(int num2:nums2){
            if(hm[num2]>0){
                ret.push_back(num2);
                hm[num2]--;
            }
        }
        return ret;
    }
};