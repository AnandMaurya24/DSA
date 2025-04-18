/*
 * @lc app=leetcode id=863 lang=java
 *
 * [863] All Nodes Distance K in Binary Tree
 *
 * https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/description/
 *
 * algorithms
 * Medium (63.94%)
 * Likes:    11414
 * Dislikes: 249
 * Total Accepted:    545.4K
 * Total Submissions: 827.5K
 * Testcase Example:  '[3,5,1,6,2,0,8,null,null,7,4]\n5\n2'
 *
 * Given the root of a binary tree, the value of a target node target, and an
 * integer k, return an array of the values of all nodes that have a distance k
 * from the target node.
 * 
 * You can return the answer in any order.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, k = 2
 * Output: [7,4,1]
 * Explanation: The nodes that are a distance 2 from the target node (with
 * value 5) have values 7, 4, and 1.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: root = [1], target = 1, k = 3
 * Output: []
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * The number of nodes in the tree is in the range [1, 500].
 * 0 <= Node.val <= 500
 * All the values Node.val are unique.
 * target is the value of one of the nodes in the tree.
 * 0 <= k <= 1000
 * 
 * 
 */

// @lc code=start
import java.util.*;
//  Definition for a binary tree node.
  class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
}
class Solution {
    public boolean rootToNodePath(TreeNode root, TreeNode node, List<TreeNode> ans ){
        if(root == null) return false;

        if(root == node){
            ans.add(node);
            return true;
        }

       boolean res =  rootToNodePath(root.left, node, ans) || rootToNodePath(root.right, node, ans);

       if(res) ans.add(root);

       return res;
    }

    public void printKDown(TreeNode node, int depth, TreeNode block, List<Integer> ans){
        if(node == null || depth < 0 || node == block) return;
        if(depth == 0){
            ans.add(node.val);
            return;
        }

        printKDown(node.left, depth-1, block, ans);
        printKDown(node.right, depth-1, block, ans);

    }

    
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {

        List<TreeNode> list = new ArrayList<>();
        rootToNodePath(root, target,list);

        List<Integer> ans = new ArrayList<>();
        TreeNode blockNode = null;
        for(int i = 0; i<list.size(); i++){
            printKDown(list.get(i),k-i,blockNode,ans);
            blockNode = list.get(i);
        }
        return ans;
        
    }
}
// @lc code=end

