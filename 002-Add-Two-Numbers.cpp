2. Add Two Numbers

You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8

思路：
注意两个链表长度可能不同；
注意最后一个节点相加后产生的进位；


/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        ListNode* node1=l1;
        ListNode* node2=l2;
        ListNode* Node = new ListNode(0);
        ListNode* p = Node;
        
        int num=0;
        
        while(node1!=NULL || node2!=NULL){
            if(node1!=NULL){
                num+=node1->val;
                node1 = node1->next;
            }
            if(node2!=NULL){
                num+=node2->val;
                node2 = node2->next;
            }
            p->next = new ListNode(num%10);
            p = p->next;
            num/=10;
        }
        
        if(num==1){
            p->next=new ListNode(1);
        }
        return Node->next;
    }
};