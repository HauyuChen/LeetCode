328. Odd Even Linked List

Given a singly linked list, group all odd nodes together followed by the even nodes. Please note here we are talking about the node number and not the value in the nodes.

You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.

Example:
Given 1->2->3->4->5->NULL,
return 1->3->5->2->4->NULL.

Note:
The relative order inside both the even and odd groups should remain as it was in the input. 
The first node is considered odd, the second node even and so on ...


思路：
本题通过一次遍历便可实现。设置指针 odd 指向奇数链的链尾，设置指针 even 指向偶数链的链尾，以此遍历，每次更新指针 odd 和 even。
因为最后要将偶数链接在奇数链的后面，所以一开头应设置指针 even_head 指向偶数链的第一个元素。
最终，返回 head 。

注：在整个流程中， head 始终指向奇数链头， even_head 始终指向偶数链头；奇数链尾 odd 和偶数链尾 even 随着遍历不断更新。



/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head==null){
            return null;
        }

        ListNode odd = head;
        ListNode even = head.next;
        ListNode even_head = even;

        while(even!=null&&even.next!=null){
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = even_head;
        
        return head;
    }
}