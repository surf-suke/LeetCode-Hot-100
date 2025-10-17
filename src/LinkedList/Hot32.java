package LinkedList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Hot32 {
    class Node{
        int val;
        Node next;
        Node random;
        public Node(int val){
            this.val=val;
            this.next=null;
            this.random=null;
        }

    }
    public Node copyRandomList(Node head) {   //O(N) time and O(N) space
//        if(head==null)
//            return null;
//        Map<Node,Node> map = new HashMap<>();
//        Node p=head;
//        while(p!=null){
//            map.put(p,new Node(p.val));
//            p=p.next;
//        }
//        p=head;
//        while(p!=null){
//            map.get(p).next=map.get(p.next);
//            map.get(p).random=map.get(p.random);
//            p=p.next;
//        }
//        return map.get(head);
        if(head==null) return null;
        Node p = head;
        Node q = p.next;
        Node postP;
        while(q!=null){
            postP=new Node(p.val);
            p.next=postP;
            postP.next=q;
            p=q;
            q=q.next;
        }
        postP=new Node(p.val);
        p.next=postP;
        postP.next=q;

        p=head;
        while(p!=null){
            q=p.next;              //深拷贝节点
            if(p.random!=null){
                if (q != null) {
                    q.random=p.random.next;
                }
            }else{
                if (q != null) {
                    q.random=null;
                }
            }
            if (q != null) {
                p=q.next;
            }
        }
        p=head;
        q=p.next;
        Node copyHead=q;
        while(q.next!=null){
            p.next=q.next;
            p=q.next;
            q.next=p.next;
            q=q.next;
        }
        p.next=null;
        return copyHead;
    }
}
