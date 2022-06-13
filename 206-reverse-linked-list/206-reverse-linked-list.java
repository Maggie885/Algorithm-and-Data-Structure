class Solution{
    //Time:O(n)
    //Space:O(n)
    public ListNode reverseList(ListNode head){
        ListNode prev = null;
        ListNode cur = head;
        
        while(cur != null){
            ListNode temptNext = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temptNext;
        }
        return prev;
    }
}