/*
 * @lc app=leetcode id=236 lang=java
 *
 * [236] Lowest Common Ancestor of a Binary Tree
 *
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/description/
 *
 * algorithms
 * Medium (59.73%)
 * Likes:    17357
 * Dislikes: 453
 * Total Accepted:    2M
 * Total Submissions: 3.1M
 * Testcase Example:  '[3,5,1,6,2,0,8,null,null,7,4]\n5\n1'
 *
 * Given a binary tree, find the lowest common ancestor (LCA) of two given
 * nodes in the tree.
 * 
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor
 * is defined between two nodes p and q as the lowest node in T that has both p
 * and q as descendants (where we allow a node to be a descendant of
 * itself).”
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * Output: 3
 * Explanation: The LCA of nodes 5 and 1 is 3.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * Output: 5
 * Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant
 * of itself according to the LCA definition.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: root = [1,2], p = 1, q = 2
 * Output: 1
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * The number of nodes in the tree is in the range [2, 10^5].
 * -10^9 <= Node.val <= 10^9
 * All Node.val are unique.
 * p != q
 * p and q will exist in the tree.
 * 
 * 
 */

// @lc code=start

//   Definition for a binary tree node.
import java.util.*;
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
 }
class Solution {
    public boolean rootToNodePath(TreeNode root, TreeNode data, List<TreeNode> ans){
        if(root == null) return false;
        if(root == data){
            ans.add(data);
            return true;
        }

        boolean res = rootToNodePath(root.left, data, ans) || rootToNodePath(root.right, data, ans);

        if(res) ans.add(root);
        return res;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        List<TreeNode> listp=new ArrayList<>();
        List<TreeNode> listq = new ArrayList<>();

        rootToNodePath(root, p , listp);
        rootToNodePath(root, q, listq);

        int i = listp.size()-1;
        int j = listq.size()-1;
        TreeNode LCA = null;

        while(i>=0 && j>=0){

            if(listp.get(i) != listq.get(j)) break;

            LCA = listp.get(i);
            i--;
            j--;
        }
        return LCA;
    }
}
// @lc code=end

