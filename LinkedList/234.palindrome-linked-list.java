/*
 * @lc app=leetcode id=234 lang=java
 *
 * [234] Palindrome Linked List
 *
 * https://leetcode.com/problems/palindrome-linked-list/description/
 *
 * algorithms
 * Easy (55.31%)
 * Likes:    17221
 * Dislikes: 920
 * Total Accepted:    2.3M
 * Total Submissions: 4.2M
 * Testcase Example:  '[1,2,2,1]'
 *
 * Given the head of a singly linked list, return true if it is a palindrome or
 * false otherwise.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: head = [1,2,2,1]
 * Output: true
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: head = [1,2]
 * Output: false
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * The number of nodes in the list is in the range [1, 10^5].
 * 0 <= Node.val <= 9
 * 
 * 
 * 
 * Follow up: Could you do it in O(n) time and O(1) space?
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
    
    public ListNode mid(ListNode head){

        ListNode slow = head;
        ListNode fast = head;

        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode reverse(ListNode node){

        ListNode curr = node;
        ListNode prev = null;
        while(curr!=null){
            ListNode forw = curr.next;
            curr.next = prev;
            prev = curr;
            curr =forw;
        }
        return prev;

    }

    public boolean isPalindrome(ListNode head) {

        if(head==null || head.next == null) return true;

        ListNode mid = mid(head);

        ListNode forw = mid.next;
        
        mid.next = null;

        ListNode reverseHead = reverse(forw);

        ListNode curr = head;
        ListNode reverseCurr = reverseHead;

        while(curr!=null && reverseCurr!=null){

            if(curr.val!= reverseCurr.val) return false;
            curr = curr.next;
            reverseCurr =reverseCurr.next;
        }

        return true;


        
    }
}
// @lc code=end

