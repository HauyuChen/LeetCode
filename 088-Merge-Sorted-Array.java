88. Merge Sorted Array

Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

Note:
You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2. The number of elements initialized in nums1 and nums2 are m and n respectively.



思路：从后往前遍历两个数组，分别比较，大的放在数组 nums1 后面，直到两个数组都遍历完毕。注：如果从前往后遍历的话，数组合并时需要将元素后移，效率低。


class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index = m+n-1;
        int i1 = m-1;
        int i2 = n-1;
        
        while(i1>=0&&i2>=0){
            if(nums1[i1]>=nums2[i2]){
                nums1[index] = nums1[i1];
                i1--;
            }else{
                nums1[index] = nums2[i2];
                i2--;
            }
            index--;
        }
        while(i1>=0){
            nums1[index] = nums1[i1];
            i1--;
            index--;
        }
        while(i2>=0){
            nums1[index] = nums2[i2];
            i2--;
            index--;
        }
    }
}