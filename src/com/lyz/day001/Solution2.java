package com.lyz.day001;

public class Solution2 {


    /**
     * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
     *
     * 请你将两个数相加，并以相同形式返回一个表示和的链表。
     *
     * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/add-two-numbers
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * 1.递归函数交付给上层什么？
     * 没错，交付的是两节点相加后的值（sum%10）
     * 2.递归函数的终止条件是什么？
     * 当指针都为Null 且 进位carry为0时 return null
     *
     * 作者：hai-tao-23
     * 链接：https://leetcode-cn.com/problems/add-two-numbers/solution/javaliang-shu-xiang-jia-di-gui-xie-fa-ji-aytg/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @return
     */
    static int carry = 0 ; //记录进位
    public static ListNode addTwoNumbers(ListNode l1 , ListNode l2) {
        //终止条件 l1 l2 都为null, 且进位 为 0 -> null
        if (l1 == null && l2 == null && carry == 0) return null;

        // 当有一条链表 为 null 且 进位 为 0 时, next 指针直接 指向 另一个 链表 返回
        if (l1 != null && l2 == null && carry == 0) return  l1;
        else if (l2 != null && l1 == null && carry ==0 ) return l2;

        // sum =
        int sum = (l1 == null ? 0 :l1.val) + (l2 == null? 0: l2.val) + carry;
        // 计算进位
        carry = sum / 10;
        // 计算value
        int value = sum % 10;
        ListNode node = new ListNode(value);

        node.next = addTwoNumbers((l1==null? null:l1.next),(l2==null? null: l2.next));

        return node;
    }

    public static void main(String[] args) {
        ListNode l11 = new ListNode(2);
        ListNode l12 = new ListNode(4);
        ListNode l13 = new ListNode(3);
        l11.next = l12;
        l12.next = l13;

        ListNode l21 = new ListNode(5);
        ListNode l22 = new ListNode(6);
        ListNode l23 = new ListNode(4);
        l21.next = l22;
        l22.next = l23;

        ListNode result_node = addTwoNumbers(l11,l21);
        ListNode current = result_node;
        while(current != null){
            System.out.println("node:"+current.val);
            current = current.next;
        }
    }
}
