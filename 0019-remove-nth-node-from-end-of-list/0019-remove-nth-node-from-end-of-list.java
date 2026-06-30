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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null)
        {
            System.out.println("Linked List is empty");
            return head;
        }
        ListNode temp = head;
        int sz = 0;
        while(temp != null)
        {
            temp = temp.next;
            sz++;
        }
        if(n == sz)
        {
            head = head.next;
            return head;
        }
        int i = 1;
        temp = head;
        while(i < (sz - n))
        {
            temp = temp.next;
            i++;
        }
        if(n == 1)
        {
            temp.next = null;
            return head;
        }
        else
        {
            temp.next = temp.next.next;
            return head;
        }
    }
}