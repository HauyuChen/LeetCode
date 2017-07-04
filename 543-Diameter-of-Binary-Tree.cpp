543. Diameter of Binary Tree

Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.

Example:
Given a binary tree 
          1
         / \
        2   3
       / \     
      4   5    
Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].

Note: The length of path between two nodes is represented by the number of edges between them.





/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    int dia=0;
    int diameterOfBinaryTree(TreeNode* root) {
        if(root==nullptr){
            return 0;
        }
        if(root->left==nullptr && root->right==nullptr){
            return 0;
        }
        DepthOfBinaryTree(root);

        return dia;
    }
private:
    int DepthOfBinaryTree(TreeNode* root){
        if(!root){
            return 0;
        }
        int left=DepthOfBinaryTree(root->left);
        int right=DepthOfBinaryTree(root->right);
        dia=max(dia, left+right);
        return 1+max(left,right);
    }
};