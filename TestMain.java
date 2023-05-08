public class TestMain {
    public static void main(String[] args) {
        RedBlackTree redBlackTree = new RedBlackTree();
        int[] values = { 5, 3, 7, 2, 4, 6, 8 };
        for (int value : values) {
            redBlackTree.insert(new Node(value));
        }

    }
}
