package reverseList;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ReverseList {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) {this.val = val;}
        ListNode(int val, ListNode next) {this.val = val; this.next = next;}
    }

    public static void main(String[] args) {
        int[] initArr = new int[] {1,2,3,4,5};

        int i = 1;
        ListNode head = new ListNode(initArr[0]);
        ListNode pref = head;
        while (i < initArr.length) {
            ListNode next = new ListNode();
            next.val = initArr[i];
            pref.next = next;
            pref = next;
            i++;
        }

        ListNode node = head;
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }

        ReverseList reverseList = new ReverseList();
        ListNode newHead = reverseList.solution(head);
        node = newHead;

        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

    public ListNode solution(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    public ListNode solutionByRecursion(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode p = solutionByRecursion(head);
        head.next.next = head;
        head.next = null;
        return p;
    }
}
