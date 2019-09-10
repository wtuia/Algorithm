package algorithm.linkedList;

/**
 * 约瑟夫问题
 */
public class JosephusProblem {

    private int max;
    private Node linked;
    private Node lastNode;

    // 初始化长度
    public JosephusProblem(int max) {
        this.max = max;
        Node node;
        for (int i = 1; i <= max ; i++) {
            node = new Node(i);
            if (this.linked == null) {
                linked = node;
                lastNode = linked;
            } else {
                lastNode.setNext(node);
                lastNode = node;
            }
        }
        if (lastNode != null){
            lastNode.setNext(linked);
        }
    }

    // 约瑟夫问题的测试
    public static void main(String[] args) {
        JosephusProblem problem = new JosephusProblem(6);
        Node node = problem.selectN(problem.getLinked(),6);
        problem.nodeToString(node);
    }

    /**
     *  按N查找, 遇N删除，返回最后一个
    */
    public Node selectN(Node node, int n) {
        Node next; // 判断下一位
        if (n == 1) { // 按序删除， 返回最后一位
            next = node.getNext();
            if(next == null) { // 有且仅有一个
                return node;
            }
            while (next != node){
                if (next.getNext().getIndex() == node.getIndex()){
                    next.setNext(null);
                    return next;
                }
                next = node.getNext();
            }
        }
        int i = 2;// 直接从第二位开始
       // 从首位开始判断下一位，方便移除
        next = node;
        // 是本身闭环，则只含有一个元素
        while (next.getNext().getIndex() != next.getIndex()) {
            if(i == n) {
                next.setNext(next.getNext().getNext());
                i = 1;
            }
            next = next.getNext();
            i++;
        }
        //next.setNext(null); // 删除指向本身的闭环
        return next;
    }

    public void nodeToString(Node node) {
        Node next = node;
        int i = 0;
       do {
           System.out.println(next);
           if (next.getNext() == null) {
               return;
           }
            next = next.getNext();
            i++;
        }while (next != node);
    }

    public int getMax() {
        return max;
    }

    public Node getLinked() {
        return linked;
    }

    public Node getLastNode() {
        return lastNode;
    }

}
