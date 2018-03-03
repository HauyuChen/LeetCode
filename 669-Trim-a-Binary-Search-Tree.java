669. Trim a Binary Search Tree

Given a binary search tree and the lowest and highest boundaries as L and R, trim the tree so that all its elements lies in [L, R] (R >= L). You might need to change the root of the tree, so the result should return the new root of the trimmed binary search tree.

Example 1:
Input: 
    1
   / \
  0   2

  L = 1
  R = 2

Output: 
    1
      \
       2
Example 2:
Input: 
    3
   / \
  0   4
   \
    2
   /
  1

  L = 1
  R = 3

Output: 
      3
     / 
   2   
  /
 1
 
 
 
 
 思路：
 递归实现。
 1. 如果根节点大于最大值，舍去右子树，左子树为新的树，继续对新的树递归；
 2. 如果根节点小于最小值，舍去左子树，右子树为新的树，继续对新的树递归；
 3. 如果根节点在范围内，则对左右子树重复步骤 1 、 2 。
 
 /**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode trimBST(TreeNode root, int L, int R) {
        if(root==null){
            return null;
        }
        
        if(root.val>R){
            root = trimBST(root.left,L,R);
        }else if(root.val<L){
            root = trimBST(root.right,L,R);
        }else{
            root.left = trimBST(root.left,L,R);
            root.right = trimBST(root.right,L,R);  
        }
        
        return root;
    }
}