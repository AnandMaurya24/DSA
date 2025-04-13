/*
 * @lc app=leetcode id=61 lang=java
 *
 * [61] Rotate List
 *
 * https://leetcode.com/problems/rotate-list/description/
 *
 * algorithms
 * Medium (39.52%)
 * Likes:    10324
 * Dislikes: 1494
 * Total Accepted:    1.2M
 * Total Submissions: 3.1M
 * Testcase Example:  '[1,2,3,4,5]\n2'
 *
 * Given the head of a linked list, rotate the list to the right by k
 * places.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: head = [1,2,3,4,5], k = 2
 * Output: [4,5,1,2,3]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: head = [0,1,2], k = 4
 * Output: [2,0,1]
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * The number of nodes in the list is in the range [0, 500].
 * -100 <= Node.val <= 100
 * 0 <= k <= 2 * 10^9
 * 
 * 
 */



class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

class Solution {
    public int length(ListNode node){
        if(node==null) return 0;

        int length =1;
        while(node.next != null){
            node = node.next;
            ++length;
        }

        return length;
    }

    public ListNode rotateRight(ListNode head, int k) {


        if(head == null || head.next == null || k==0 ) return head;
        ListNode node = head;
        int len = length(head);
        k = k%len ;
        if(k == 0) return head;
        int rotateVal = len - k;

        

        ListNode temp = head;
        while(rotateVal-->1){
            temp = temp.next;
        }

        ListNode newHead = temp.next;
        temp.next = null;
        ListNode newTemp = newHead;
        
        while(newTemp!=null && newTemp.next != null){
            newTemp = newTemp.next;

        }
       newTemp.next = head;

        return newHead;
        
    }
}
// @lc code=end

