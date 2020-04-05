package tree;

public class PrintingTreeInZigZag {

    public static void main(String[] args) {
        Node n1 = new Node(1);
        n1.left = new Node(2);
        n1.right = new Node(3);
        n1.left.left = new Node(4);
        n1.left.right = new Node(5);
        n1.right.left = new Node(6);
        n1.right.right = new Node(7);
        n1.left.right.left = new Node(8);
        n1.left.right.right = new Node(9);

        System.out.println(n1.hashCode());
        System.out.println(n1.key);
    }

    public static class Node{
        int key;
        Node left, right;

        public Node(int item){
            key =item;
            left =right =null;
        }

    }

}

