/**
 * You are given two linked list representing two non-negative numbers.
 * The digits are stored in reverse order and each node contains single digit.
 * Add the two numbers and return it as a linked list.
 */
 
// Recursive solution. Linear complexity
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return addHelper(l1, l2, 0);
    }
    
    private ListNode addHelper(ListNode l1, ListNode l2, int carry) {
        if (l1 == null && l2 == null){
            if (carry != 0) return new ListNode(carry);
            else return null;
        } 
        
        if (l1 != null) {
            carry += l1.val;
            l1 = l1.next;
        }
        if (l2 != null) {
            carry += l2.val;
            l2 = l2.next;
        }
        
        ListNode node = new ListNode(carry % 10);
        node.next = addHelper(l1, l2, carry / 10);
        return node;
    }
}
