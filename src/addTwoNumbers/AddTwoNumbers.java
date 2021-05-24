package addTwoNumbers;

import publicModule.ListNode;
import reverseList.ReverseList;

import java.util.List;

public class AddTwoNumbers {
    int carry = 0;

    public static void main(String[] args) {
        int[] initArr1 = new int[] {2,4,3};
        int[] initArr2 = new int[] {5,6,4};

        ListNode head1 = new ListNode(initArr1[0]);
        ListNode prev = head1;
        for (int i = 1; i < initArr1.length; i++) {
            ListNode curr = new ListNode(initArr1[i]);
            prev.next = curr;
            prev = prev.next;
        }

        ListNode head2 = new ListNode(initArr2[0]);
        prev = head2;
        for (int i = 1; i < initArr2.length; i++) {
            ListNode curr = new ListNode(initArr2[i]);
            prev.next = curr;
            prev = prev.next;
        }

        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        ListNode res = addTwoNumbers.solution(head1, head2);

        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }

    }

    public ListNode solution(ListNode l1, ListNode l2) {

        //定义结束条件
        if (l1 == null && l2 == null && carry == 0) {
            return null;
        }

        //若有一条链表为空且进位为0，直接返回另一条链表
        if (l1 == null && l2 != null && carry == 0) {
            return l2;
        } else if (l2 == null && l1 != null && carry == 0) {
            return l1;
        }

        //计算何值;
        int sum = (l1==null?0:l1.val) + (l2==null?0:l2.val) + carry;

        //计算进位
        carry = sum / 10;

        //计算节点value
        int value = sum % 10;

        //计算next指向
        ListNode node = new ListNode(value);
        node.next = solution((l1==null?null:l1.next), (l2==null?null:l2.next));

        return node;
    }


}
