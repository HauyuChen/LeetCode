349. Intersection of Two Arrays

Given two arrays, write a function to compute their intersection.

Example:
Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].

Note:
Each element in the result must be unique.
The result can be in any order.





class Solution {
public:
    vector<int> intersection(vector<int>& nums1, vector<int>& nums2) {
        unordered_set<int> s;
        vector<int> ret;
        
        for(int num1:nums1){
            if(s.count(num1)==0){
                s.insert(num1);
            }
        }
        for(int num2:nums2){
            if(s.count(num2)){
                ret.push_back(num2);
                s.erase(num2);
            }
        }
        return ret;
    }
};