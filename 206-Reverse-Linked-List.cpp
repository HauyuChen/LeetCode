206. Reverse Linked List

Reverse a singly linked list.







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
    ListNode* reverseList(ListNode* head) {
        ListNode* pPre=nullptr;
        ListNode* pNode=head;
        ListNode* pRet=nullptr;
        
        while(pNode!=nullptr){
            ListNode* pNext=pNode->next;
            if(pNext==nullptr){
                pRet=pNode;
            }
            pNode->next=pPre;
            pPre=pNode;
            pNode=pNext;
        }
        return pRet;
    }
};