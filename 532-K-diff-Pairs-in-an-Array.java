532. K-diff Pairs in an Array

Given an array of integers and an integer k, you need to find the number of unique k-diff pairs in the array. Here a k-diff pair is defined as an integer pair (i, j), where i and j are both numbers in the array and their absolute difference is k.

Example 1:
Input: [3, 1, 4, 1, 5], k = 2
Output: 2
Explanation: There are two 2-diff pairs in the array, (1, 3) and (3, 5).
Although we have two 1s in the input, we should only return the number of unique pairs.

Example 2:
Input:[1, 2, 3, 4, 5], k = 1
Output: 4
Explanation: There are four 1-diff pairs in the array, (1, 2), (2, 3), (3, 4) and (4, 5).

Example 3:
Input: [1, 3, 1, 5, 4], k = 0
Output: 1
Explanation: There is one 0-diff pair in the array, (1, 1).

Note:
The pairs (i, j) and (j, i) count as the same pair.
The length of the array won't exceed 10,000.
All the integers in the given input belong to the range: [-1e7, 1e7].




思路：
1. 通过 HashMap 来存放各个元素出现的次数；
2. 遍历 HashMap ，如遍历到 key1 ，检查是否存在为 key1 + k 的 Key ，若是 count++；
3. 注意 k = 0 时，应该判断是否有出现次数大于2的 Key ，若是 count++；
4. 注意 k 小于0的情况，直接 return 0；




class Solution {
    public int findPairs(int[] nums, int k) {
        if(k<0 || nums==null){
            return 0;
        }
        
        HashMap<Integer,Integer> m = new HashMap<>();
        int count = 0;
        
        for(int num:nums){
            m.put(num,m.getOrDefault(num,0)+1);
        }
        
        for(Map.Entry<Integer,Integer> entry:m.entrySet()){
            if(0==k){
                if(entry.getValue()>1){
                    count++;
                }
            }else{
                if(m.containsKey(entry.getKey()+k)){
                    count++;
                }
            }
        }

        return count;
    }
}
