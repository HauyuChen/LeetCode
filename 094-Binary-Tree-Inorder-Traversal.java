94. Binary Tree Inorder Traversal

Given a binary tree, return the inorder traversal of its nodes' values.

For example:
Given binary tree [1,null,2,3],
   1
    \
     2
    /
   3
return [1,3,2].

思路：
二叉树的中序遍历，这里直接用递归的方法求解。

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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<Integer>();
        inorder(root,ret);
        return ret;
    }
    
    public void inorder(TreeNode root, List<Integer> ret){
        if(root==null){
            return ;
        }
        inorder(root.left,ret);
        ret.add(root.val);
        inorder(root.right,ret);
    }
}