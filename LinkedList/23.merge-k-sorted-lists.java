/*
 * @lc app=leetcode id=23 lang=java
 *
 * [23] Merge k Sorted Lists
 *
 * https://leetcode.com/problems/merge-k-sorted-lists/description/
 *
 * algorithms
 * Hard (50.51%)
 * Likes:    19985
 * Dislikes: 739
 * Total Accepted:    2.3M
 * Total Submissions: 4.2M
 * Testcase Example:  '[[1,4,5],[1,3,4],[2,6]]'
 *
 * You are given an array of k linked-lists lists, each linked-list is sorted
 * in ascending order.
 * 
 * Merge all the linked-lists into one sorted linked-list and return it.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: lists = [[1,4,5],[1,3,4],[2,6]]
 * Output: [1,1,2,3,4,4,5,6]
 * Explanation: The linked-lists are:
 * [
 * ⁠ 1->4->5,
 * ⁠ 1->3->4,
 * ⁠ 2->6
 * ]
 * merging them into one sorted list:
 * 1->1->2->3->4->4->5->6
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: lists = []
 * Output: []
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: lists = [[]]
 * Output: []
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * k == lists.length
 * 0 <= k <= 10^4
 * 0 <= lists[i].length <= 500
 * -10^4 <= lists[i][j] <= 10^4
 * lists[i] is sorted in ascending order.
 * The sum of lists[i].length will not exceed 10^4.
 * 
 * 
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 */
  class ListNode {
    int val;
    ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
 
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        public ListNode mergeKLists(ListNode[] lists) {
            if ( lists.length == 0) return null;
    
            ListNode ans=null;
            for(int i = 0; i<lists.length; i++){
                ans = compareAndMerge(ans, lists[i]);
            }
            return ans;
            
        }
    
        public ListNode compareAndMerge(ListNode list1, ListNode list2){
    
            if (list1 == null || list2 == null)  return list1 != null ? list1:list2;
            
            ListNode finalAns= new ListNode(-1);
            ListNode prev = finalAns;
            ListNode l1Head = list1;
            ListNode l2Head = list2;
            
            
            while(l1Head!=null && l2Head!=null){
                if(l1Head.val <= l2Head.val){
                    prev.next = l1Head;
                    l1Head = l1Head.next;
                }
                else{
                    prev.next = l2Head;
                    l2Head = l2Head.next;
                } 
                prev = prev.next;
            }
    
            prev.next = l1Head == null ? l2Head : l1Head;
            return finalAns.next;
        }
        
    }
}
// @lc code=end

