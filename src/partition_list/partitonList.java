package partition_list;

/**
 * Created by tianling on 17/7/9.
 * 给定一个单链表和数值x，划分链表使得所有小于x的节点排在大于等于x的节点之前。
 * 保留两部分内链表节点原有的相对顺序。
 */

public class partitonList {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public static void main(String args[]) {
        ListNode L1 = new ListNode(1);
        ListNode L2 = new ListNode(5);
        ListNode L3 = new ListNode(3);
        ListNode L4 = new ListNode(2);
        L1.next = L2;
        L2.next = L3;
        L3.next = L4;

        partitonList partition = new partitonList();
        partition.print(L1);
        System.out.println();
        ListNode head = partition.Solution(L1,3);
        System.out.println(head.toString());
        partition.print(head);
    }


    public ListNode Solution(ListNode head, int x) {
        if (head == null){
            return null;
        }

        ListNode leftDummy = new ListNode(0);
        ListNode rightDummy = new ListNode(0);
        ListNode left = leftDummy, right = rightDummy;

        while (head != null) {
            if (head.val < x) {
                left.next = head;
                left = head;
            }else {
                right.next = head;
                right = head;
            }

            head = head.next;
        }

        right.next = null;
        left.next = rightDummy.next;
        return leftDummy.next;
    }

    void print(ListNode node) {
        while (node != null) {
            System.out.print(node.val);
            System.out.print("->");
            node = node.next;
        }

        System.out.print("null");
    }

}
