523. Continuous Subarray Sum

Given a list of non-negative numbers and a target integer k, write a function to check if the array has a continuous subarray of size at least 2 that sums up to the multiple of k, that is, sums up to n*k where n is also an integer.

Example 1:
Input: [23, 2, 4, 6, 7],  k=6
Output: True

Explanation: Because [2, 4] is a continuous subarray of size 2 and sums up to 6.

Example 2:
Input: [23, 2, 6, 4, 7],  k=6
Output: True

Explanation: Because [23, 2, 6, 4, 7] is an continuous subarray of size 5 and sums up to 42.

Note:
The length of the array won't exceed 10,000.
You may assume the sum of all the numbers is in the range of a signed 32-bit integer.




思路：暴力解之。注意k为0时应单独考虑，判断相邻的元素是否为0，若是返回true，否则返回false。

注：此题有O(n)的解法，不过该方法不通用。






解法1：暴力

class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        if(k==0){
            return checkzero(nums);
        }
        
        int len = nums.length; 
        for(int i=0;i<len-1;i++){
            int sum=0;
            for(int j=i;j<len;j++){
                sum+=nums[j];
                if(sum%k==0 && j-i>0){
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean checkzero(int[] nums){
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]==0 && nums[i+1]==0){
                return true;
            }
        }
        return false;       
    }
}

解法2：时间复杂度 O(n)

class Solution {
public:
    bool checkSubarraySum(vector<int>& nums, int k) {
        int n = nums.size(), sum = 0, pre = 0;
        unordered_set<int> modk;
        for (int i = 0; i < n; ++i) {
            sum += nums[i];
            int mod = k == 0 ? sum : sum % k;
            if (modk.count(mod)) return true;
            modk.insert(pre);
            pre = mod;
        }
        return false;
    }
};