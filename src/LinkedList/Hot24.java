package LinkedList;

public class Hot24 {
    public class ListNode{
        int val;
        ListNode next;
        ListNode(){}
        ListNode(int val){
            this.val=val;
        }
        ListNode (int val, ListNode next){
            this.val = val;
            this.next = next;
        }
    }
    public boolean isPalindrome(ListNode head){            // O(n²)超时
//        if(head==null)
//            return false;
//        int len = 0;
//        ListNode p = head;
//        while(p.next!=null){
//            len = len+1;
//            p=p.next;
//        }
//        p = head;
//        int index=0;
//        while(p.next!=null&&index<=len/2){
//            ListNode q=head;
//            int j=len-index;
//            while(j>0){
//                q=q.next;
//                j--;
//            }
//            if(p.val!=q.val)
//                return false;
//            p=p.next;
//            index++;
//        }
//        return true;
        //快慢指针定位
        if(head==null)
            return true;
        ListNode firstHalfEnd = endOfFirstHalf(head);
        ListNode secondHalfStart = reverseList(firstHalfEnd.next);
        ListNode p1 = head;
        ListNode p2 = secondHalfStart;
        while(p2!=null){
            if(p1.val!= p2.val)
                return false;
            p1=p1.next;
            p2=p2.next;
        }
        firstHalfEnd.next=reverseList(secondHalfStart);
        return true;
    }
    public ListNode endOfFirstHalf(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next!=null&&fast.next.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public ListNode reverseList(ListNode head) {
        if(head==null)
            return null;
        ListNode p = head;
        ListNode q = head.next;
        p.next=null;
        while(q!=null){
            ListNode tmp =q.next;
            q.next=p;
            p=q;
            q=tmp;
        }
        return p;
    }
}
