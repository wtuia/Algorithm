package lint_code.reverse_linked;

import java.util.Arrays;

/**
 * <a href="https://www.lintcode.com/problem/reverse-linked-list/description">链表翻转</a>
 * <a href="https://www.lintcode.com/problem/reverse-linked-list-ii/description">链表翻转2</a>
 */
public class Solution {

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        ListNode node1 = new ListNode(1);
        head.next = node1;
        ListNode node2 = new ListNode(2);
        node1.next = node2;
        head = reverseBetween(head, 2, 3);
    }

    /**
     * 全翻转
     */
    private static ListNode reverse(ListNode head) {
        ListNode node = head;
        int[] nodeNum = new int[16];
        int index = 0, size = 16;
        while (node != null) {
            nodeNum[index++] = node.val;
            if( index >= size) {
                size <<= 1;
                nodeNum = Arrays.copyOf(nodeNum, size);
            }
            node = node.next;
        }
        node = head;
        index -= 1;
        for (int i = 0; i <= index; i++) {
            node.val = nodeNum[index - i];
            node = node.next;
        }
        return head;
    }

    /**
     * 按区间翻转
     * @param m 开始位置,  n - 结束位置
     */
    private static ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode node = head;
        int[] nodeNum = new int[16];
        int index = 0, size = 16;
        while (node != null) {
            nodeNum[index++] = node.val;
            if( index >= size) {
                size <<= 1;
                nodeNum = Arrays.copyOf(nodeNum, size);
            }
            node = node.next;
        }
        node = head;
        int max = Math.min(--index, --n);
        m--;
        for (int count = 0; count <= max; count++) {
            if (count >= m ) {
                node.val = nodeNum[max - count + m];
            }
            node = node.next;
        }
        return head;
    }
}

