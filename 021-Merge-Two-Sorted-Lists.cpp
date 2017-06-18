21. Merge Two Sorted Lists

Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.




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
    ListNode* mergeTwoLists(ListNode* l1, ListNode* l2) {
        if(l1==nullptr&&l2==nullptr)
            return nullptr;
        if(l1==nullptr || l2==nullptr)
            return (l1==nullptr)?l2:l1;
            
        ListNode* newhead=nullptr;
        if((l1->val)<=(l2->val)){
            newhead=l1;
            newhead->next = mergeTwoLists(l1->next,l2);
        }else{
            newhead=l2;
            newhead->next = mergeTwoLists(l1,l2->next);
        }
        return newhead;
    }
};