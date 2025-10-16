package LinkedList;

public class Hot28 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p1=l1;
        ListNode p2=l2;
        ListNode dummy= new ListNode(-1,null);
        ListNode p3=dummy;
        ListNode newNode;
        int sum;
        int quotient=0;
        int reminder;
        while(p1!=null && p2!=null){
            sum=p1.val+p2.val+quotient;
            reminder= sum % 10;
            newNode = new ListNode(reminder,null);
            p3.next=newNode;
            p3=p3.next;
            quotient= sum/10;
            p1=p1.next;
            p2=p2.next;
        }
        while(p1!=null){
            sum=p1.val+quotient;
            reminder=sum %10;
            newNode = new ListNode(reminder,null);
            p3.next= newNode;
            p1=p1.next;
            p3=p3.next;
            quotient=sum/10;
        }
        while(p2!=null){
            sum=p2.val+quotient;
            reminder=sum %10;
            newNode = new ListNode(reminder,null);
            p3.next= newNode;
            p2=p2.next;
            p3=p3.next;
            quotient=sum/10;
        }
        if(quotient!=0){
            newNode = new ListNode(quotient,null);
            p3.next=newNode;
        }
        return dummy.next;
    }
}
