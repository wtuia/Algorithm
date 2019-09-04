package algorithm.linkedList;

import java.util.Objects;

/**
 * 基于链表的缓存淘汰算法 <br/>
 *
 * 常见的缓存淘汰策略：
 *  FIFO 先进先出
 *  LFU 最少使用
 *  LRU 最近最少使用
 */
public class LRU {

    private Node firstNode;
    private int size; // 计数
    private int maxSize = 3;// 设置大小
    private Node lastNode;

    public static void main(String[] args) {

    }

    public void add(String value) {
        if (firstNode == null) {
            firstNode = new Node(value);
            size = 1;
            lastNode = firstNode;
        }
        Node node = firstNode;
        Node valueNode;
        while (node!=null) {
            // 若存在相同值
            if (Objects.equals(node.getValue(), value)) {
                valueNode = node;
                setValueNode(valueNode);
                break;
            }
            node = node.getNext();
        }
        // 若超出容量，首部添加，尾部删除
        if (size == maxSize) {
            addFirst(value);
            // 否则尾部添加
        } else {
            append(value);
        }
    }

    private void setValueNode (Node valueNode) {
        Node node = firstNode;
        while (node != null) {
            // 若下一位是含当前值的节点
            if (node.getNext() == valueNode) {
                node.setNext(valueNode.getNext());
                valueNode.setNext(firstNode);
                firstNode = valueNode;
                break;
            }
            node = node.getNext();
        }
    }

    private void addFirst(String value) {
        Node node = firstNode;
        while (node!=null) {
            // 删除最后一位
            if (node.getNext() == lastNode) {
                node.setNext(null);
                lastNode = node;
            }
            node = firstNode.getNext();
        }
        // 最前面添加
        Node newNode = new Node(value);
        newNode.setNext(firstNode);
        firstNode = newNode;
    }

    private void append(String value) {
        Node node = new Node(value);
        lastNode.setNext(node);
        lastNode = node;
    }


}
