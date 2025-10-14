package LinkedList;

import java.util.HashSet;
import java.util.Set;

public class Hot22 {
    public class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val=x;
            next=null;
        }
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {  //O(m+n) O(m)
        if(headA==null||headB==null)
            return null;
        Set<ListNode> set= new HashSet<>();
        ListNode cur=headA;
        while(cur!=null){
            set.add(cur);
            cur=cur.next;
        }
        cur=headB;
        while(cur!=null){
            if(set.contains(cur))
                return cur;
            cur=cur.next;
        }
        return null;
    }

}
