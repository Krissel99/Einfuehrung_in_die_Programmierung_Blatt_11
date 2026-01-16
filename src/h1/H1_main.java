package h1;

public class H1_main {
    public static void main(String[] args) {
        Node e = new Node(null);
        Node d = new Node(e);
        Node c = new Node(d);
        Node b = new Node(c);
        Node a = new Node(b);
        Node x = a;
        Node y = a;
        System.out.println("Der Abstand von "+x+" und "+y+" ist "+distance(x, y));
    }

    public static int distance(Node x, Node y) {
        if (x == y) {
            return 0;
        }
        if (x.getNext() == y) {
            return 1;
        }
        return 1+distance(x.getNext(), y);

    }

}