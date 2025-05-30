/*
 * @lc app=leetcode id=199 lang=java
 *
 * [199] Binary Tree Right Side View
 *
 * https://leetcode.com/problems/binary-tree-right-side-view/description/
 *
 * algorithms
 * Medium (62.07%)
 * Likes:    12572
 * Dislikes: 1055
 * Total Accepted:    1.7M
 * Total Submissions: 2.6M
 * Testcase Example:  '[1,2,3,null,5,null,4]'
 *
 * Given the root of a binary tree, imagine yourself standing on the right side
 * of it, return the values of the nodes you can see ordered from top to
 * bottom.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: root = [1,2,3,null,5,null,4]
 * 
 * Output: [1,3,4]
 * 
 * Explanation:
 * 
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: root = [1,2,3,4,null,null,null,5]
 * 
 * Output: [1,3,4,5]
 * 
 * Explanation:
 * 
 * 
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: root = [1,null,3]
 * 
 * Output: [1,3]
 * 
 * 
 * Example 4:
 * 
 * 
 * Input: root = []
 * 
 * Output: []
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * The number of nodes in the tree is in the range [0, 100].
 * -100 <= Node.val <= 100
 * 
 * 
 */

// @lc code=start

//  Definition for a binary tree node.
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
 }
 
class Solution {
    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;

        LinkedList<TreeNode> que= new LinkedList<>();
        que.addLast(root);
        while(que.size()!=0){
            int size = que.size();
            ans.add(que.getLast().val);
            while(size-->0){
                TreeNode rn = que.remove();
                if(rn.left != null) que.addLast(rn.left);
                if(rn.right != null) que.addLast(rn.right);
            }
        }

        return ans;
        
        
    }
}
// @lc code=end

