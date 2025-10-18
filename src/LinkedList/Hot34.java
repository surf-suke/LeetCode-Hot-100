
package LinkedList;

public class Hot34 {
    // 单链表节点定义
    public class ListNode{
        int val;
        ListNode next;
        ListNode() {}
        ListNode (int val){
            this.val =val;
        }
        ListNode (int val, ListNode next){
            this.val=val;
            this.next=next;
        }
    }

    /**
     * 自底向上的归并排序（适用于链表）
     * 时间复杂度 O(n log n)，空间复杂度 O(1)（不计递归栈）
     *
     * 思路：
     * 1. 先计算链表长度 length。
     * 2. 使用 dummyHead 简化头指针处理。
     * 3. 以子段长度 subLength 从 1 开始，每轮翻倍（1,2,4,...）。
     *    在每轮中，从链表头依次取出两个长度为 subLength 的子链表 head1 和 head2，
     *    将它们合并后接回到 prev（上次合并结果的尾部），然后继续处理下一个区间。
     * 4. 重复直到 subLength >= length。
     */
    public ListNode sortList(ListNode head) {           //自底向上归并排序O(n*lgn) 空间复杂度O(1)
        if (head == null) {
            return head;
        }
        // 计算链表长度
        int length = 0;
        ListNode node = head;
        while (node != null) {
            length++;
            node = node.next;
        }

        // 哨兵节点，方便操作头部连接
        ListNode dummyHead = new ListNode(0, head);

        // subLength 表示当前要合并的子链表长度，每次翻倍
        for (int subLength = 1; subLength < length; subLength <<= 1) {
            ListNode prev = dummyHead;      // prev 指向已处理部分的最后一个节点（用于接回合并后的子链表）
            ListNode curr = dummyHead.next; // curr 指向本次未处理部分的起点

            // 遍历整条链表，按两个子链表一组进行合并
            while (curr != null) {
                // head1 指向第一个子链表的起点
                ListNode head1 = curr;

                // 将 curr 移动到第一个子链表的末尾（长度为 subLength）
                // 注意这里循环 i 从 1 开始，因为 head1 已经是第 1 个节点
                for (int i = 1; i < subLength && curr.next != null; i++) {
                    curr = curr.next;
                }

                // head2 指向第二个子链表的起点（可能为 null）
                ListNode head2 = curr.next;
                // 断开第一个子链表
                curr.next = null;
                // curr 移动到 head2，准备处理第二个子链表
                curr = head2;

                // 将 curr 移动到第二个子链表的末尾（长度为 subLength）
                for (int i = 1; i < subLength && curr != null && curr.next != null; i++) {
                    curr = curr.next;
                }

                // next 保存本次处理后剩余部分的起点（用于下一轮合并）
                ListNode next = null;
                if (curr != null) {
                    next = curr.next; // 保存后续起点
                    curr.next = null; // 断开第二个子链表
                }

                // 合并 head1 和 head2，得到有序链表 merged
                ListNode merged = merge(head1, head2);
                // 将合并结果接回到 prev（上次处理的末尾）
                prev.next = merged;

                // 将 prev 移动到合并后子链表的末尾，为下一次接回做准备
                // 通过遍历直到 prev.next 为 null，prev 指向合并段的最后一个节点
                while (prev.next != null) {
                    prev = prev.next;
                }

                // curr 指向下一段未处理的起点，继续循环
                curr = next;
            }
        }
        // 返回排序后链表的头节点
        return dummyHead.next;
    }

    /**
     * 合并两个有序链表，返回合并后的头结点
     */
    public ListNode merge(ListNode head1, ListNode head2) {
        ListNode dummyHead = new ListNode(0);
        ListNode temp = dummyHead, temp1 = head1, temp2 = head2;

        // 经典的两个有序链表合并
        while (temp1 != null && temp2 != null) {
            if (temp1.val <= temp2.val) {
                temp.next = temp1;
                temp1 = temp1.next;
            } else {
                temp.next = temp2;
                temp2 = temp2.next;
            }
            temp = temp.next;
        }

        // 将剩余节点接上（只会存在一个非空）
        if (temp1 != null) {
            temp.next = temp1;
        } else if (temp2 != null) {
            temp.next = temp2;
        }

        return dummyHead.next;
    }
}