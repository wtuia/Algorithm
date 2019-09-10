package algorithm.linkedList;

public class Node {

    private String value;
    private int index;
    private Node next;
    private Node prev;

    public Node() {
    }

    public Node(String value) {
        this.value = value;
    }

    public Node(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getPrev() {
        return prev;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }

    @Override
    public String toString() {
        String nextIndex = next == null ? "null" : String.valueOf(next.getIndex());
        String prevIndex = prev == null ? "null" : String.valueOf(prev.getIndex());
        return "Node{" +
                "value='" + value + '\'' +
                ", index=" + index +
                ", next=" + nextIndex +
                ", prev=" + prevIndex +
                '}';
    }
}
