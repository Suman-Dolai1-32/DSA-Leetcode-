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
    public ListNode rotateRight(ListNode head, int k) 
    {
        if(head == null || head.next == null || k == 0)
            return head;
        int c = 0;
        ListNode temp = head;
        ListNode prev = temp;
        while(temp != null)
        {
            c++;
            prev = temp;
            temp = temp.next;
        }
        k = k % c;
        if(k == 0)
            return head;
        temp = head;
        for(int i = 1;i<(c - k);i++)
            temp = temp.next;
        ListNode newHead = temp.next;
        temp.next = null;
        prev.next = head;
        return newHead;
    }
}