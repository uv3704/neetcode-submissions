class Solution {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null ){
            return;
        }

        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode second = slow.next;
        slow.next = null;

        ListNode prev = null;
        ListNode curr = second;

        while(curr != null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr ; 
            curr = temp;
        }

        second = prev;

        ListNode first = head;

        while(second != null){

            ListNode temp1 = first.next;
            ListNode temp2 = second.next;

            first.next = second;
            second.next = temp1;

            first = temp1;
            second = temp2;
        }
    }
}
