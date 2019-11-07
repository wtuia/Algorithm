package geektime.data_and_algorithm.skip_list;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 跳表
 * 每两位抽出一位向上一级索引
 */
public class SkipList {

    public SkipList() {
    }

    private Node node;
    private int index;
    private List<Node> nodeIndex = new ArrayList<>();

    public SkipList(Node node) {
        this.node = node;
        createIndex(node);

    }

    public List<Node> getNodeIndex() {
        return nodeIndex;
    }

    /*
     * 创建索引
     */
    private void createIndex(Node node) {
        if (node == null) return;
        while (true) {
            Node index = new Node(node.getValue());
            Node indexNext = index;
            int skipCount = 0;
            do {
                for (int i = 0; i < 3; i++) {   // 索引节点抽取间隔
                    if (node.getNext() != null) {
                        node = node.getNext();
                    }
                }
                Node nodeTemp = new Node(node.getValue());
                indexNext.setNext(nodeTemp);
                indexNext = nodeTemp;
                skipCount++;
            } while (node.getNext() != null);
            nodeIndex.add(index);
            if (skipCount <= 2) break; // 单索引长度< 3时结束, 只作为结束条件，不保证尾索引的长度一定 > 3
            node = index;
       }
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        Node node8 = new Node(8);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);
        node5.setNext(node6);
        node6.setNext(node7);
        node7.setNext(node8);

        Node next = node1;
        while (next != null) {
            System.out.println(next.getValue());
            next = next.getNext();
        }
        SkipList skipList = new SkipList(node1);
        List<Node> index = skipList.getNodeIndex();
        System.out.printf("index size: %d%n", index.size());
        for (int i = 1; i <= index.size(); i++) {
            System.out.printf("%d级索引%n", i);
            System.out.println("------------");
            next = index.get(i - 1);
            while (next != null) {
                System.out.println(next.getValue());
                next = next.getNext();
            }
        }

    }
}
