/*
 * @lc app=leetcode id=25 lang=java
 *
 * [25] Reverse Nodes in k-Group
 *
 * https://leetcode.com/problems/reverse-nodes-in-k-group/description/
 *
 * algorithms
 * Hard (62.27%)
 * Likes:    14472
 * Dislikes: 744
 * Total Accepted:    1.2M
 * Total Submissions: 1.9M
 * Testcase Example:  '[1,2,3,4,5]\n2'
 *
 * Given the head of a linked list, reverse the nodes of the list k at a time,
 * and return the modified list.
 * 
 * k is a positive integer and is less than or equal to the length of the
 * linked list. If the number of nodes is not a multiple of k then left-out
 * nodes, in the end, should remain as it is.
 * 
 * You may not alter the values in the list's nodes, only nodes themselves may
 * be changed.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: head = [1,2,3,4,5], k = 2
 * Output: [2,1,4,3,5]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: head = [1,2,3,4,5], k = 3
 * Output: [3,2,1,4,5]
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * The number of nodes in the list is n.
 * 1 <= k <= n <= 5000
 * 0 <= Node.val <= 1000
 * 
 * 
 * 
 * Follow-up: Can you solve the problem in O(1) extra memory space?
 * 
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    
    ListNode th=null;
    ListNode tt = null;
    public int length(ListNode head){
        ListNode curr = head;
        int len=0;
        while(curr!=null){
            curr = curr.next;
            len++;
        }
        return len;
    }
    public void addFirstNode(ListNode node){

        if(th == null) {
            th = node;
            tt = node;
        }else{
            node.next=th;
            th=node;

        }
    }
    public ListNode reverseKGroup(ListNode head, int k) {

        if(head == null || head.next == null || k==1 ) return head;
        ListNode oh = null;
        ListNode ot = null;
        int length = length(head);
        ListNode curr = head;
        while(length>=k){
            
            int tempk = k;

            while(tempk-->0){
                ListNode forw = curr.next;
                curr.next = null;
                addFirstNode(curr);
                curr =forw;
            }

            if(oh == null) {
                oh = th ;
                ot = tt;
            }else{
                ot.next = th;
                ot = tt;
            }
            th=null;
            tt=null;
            length-=k;


        }
        ot.next=curr;
        return oh;



        
    }
}
// @lc code=end

