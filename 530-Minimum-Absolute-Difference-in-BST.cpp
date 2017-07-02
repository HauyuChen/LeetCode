530. Minimum Absolute Difference in BST

Given a binary search tree with non-negative values, find the minimum absolute difference between values of any two nodes.

Example:

Input:

   1
    \
     3
    /
   2

Output:
1

Explanation:
The minimum absolute difference is 1, which is the difference between 2 and 1 (or between 2 and 3).
Note: There are at least two nodes in this BST.




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
    vector<int> ret;
    int getMinimumDifference(TreeNode* root) {
        travPush(root);
        sort(ret.begin(),ret.end());
        int dis = ret[1]-ret[0];
        for(int i=2;i<ret.size();i++){
            dis = min(dis,ret[i]-ret[i-1]);
        }
        return dis;
    }
    
private:
    void travPush(TreeNode* root){
        if(root==NULL){
            return ;
        }
        ret.push_back(root->val);
        travPush(root->left);
        travPush(root->right);
    }
};