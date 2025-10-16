package LinkedList;

public class Hot27 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val,ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode p1=list1;
        ListNode p2=list2;
        ListNode dummy = new ListNode(-1,null);
        ListNode p3=dummy;
        while(p1!=null&&p2!=null){
            ListNode newNode;
            if(p1.val<=p2.val){
                newNode=new ListNode(p1.val, null);
                p1=p1.next;
            }else{
                newNode=new ListNode(p2.val, null);
                p2=p2.next;
            }
            p3.next=newNode;
            p3=p3.next;
        }
        if(p1!=null){
            p3.next=p1;
        }
        if(p2!=null){
            p3.next=p2;
        }
        return dummy.next;

    }
}
