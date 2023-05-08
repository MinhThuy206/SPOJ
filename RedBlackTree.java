public class RedBlackTree {
    private Node root, NIL;
    private int length;
    String s;

    public RedBlackTree() {
        length = 0;
        NIL = new Node();
        root = NIL;
    }

    public int getSize() {
        return length;
    }

    public Node getRoot() {
        return root;
    }

    public String format(String s){
        String a [] =s.split(" ");
        String S  = "";
        for (String x: a){
            if(!x.equals("0")){
                S += x + " ";
            }
        }
        return S;
    }
    //----------------------------------------------------- xóa ----------------------------------------//
    public void deleteFixUp(Node currentNode) {
        Node y;
        while (currentNode != root && !currentNode.colorIsRed) {
            if (currentNode == currentNode.parent.left) {
                y = currentNode.parent.right;
                if (y.colorIsRed) {
                    y.colorIsRed = false;
                    currentNode.parent.colorIsRed = true;
                    leftRotate(currentNode.parent);
                    y = currentNode.parent.right;
                }
                if (!y.left.colorIsRed && !y.right.colorIsRed) {
                    y.colorIsRed = true;
                    currentNode = currentNode.parent;
                } else {
                    if (!y.right.colorIsRed) {
                        y.left.colorIsRed = false;
                        y.colorIsRed = true;
                        rightRotate(y);
                        y = currentNode.parent.right;
                    }
                    y.colorIsRed = currentNode.parent.colorIsRed;
                    currentNode.parent.colorIsRed = false;
                    y.right.colorIsRed = false;
                    leftRotate(currentNode.parent);
                    currentNode = root;
                }
            } else {
                y = currentNode.parent.left;
                if (y.colorIsRed) {
                    y.colorIsRed = false;
                    currentNode.parent.colorIsRed = true;
                    rightRotate(currentNode.parent);
                    y = currentNode.parent.left;
                }
                if (!y.right.colorIsRed && !y.left.colorIsRed) {
                    y.colorIsRed = true;
                    currentNode = currentNode.parent;
                } else {
                    if (!y.left.colorIsRed) {
                        y.right.colorIsRed = false;
                        y.colorIsRed = true;
                        leftRotate(y);
                        y = currentNode.parent.left;
                    }
                    y.colorIsRed = currentNode.parent.colorIsRed;
                    currentNode.parent.colorIsRed = false;
                    y.left.colorIsRed = false;
                    rightRotate(currentNode.parent);
                    currentNode = root;
                }
            }
        }
        currentNode.colorIsRed = false;
    }
    //-------------------------------------------------xoay trái---------------------------------------//
    public  void leftRotate(Node currentNode) {
        Node y = currentNode.right;  // đặt y bằng con bên phải của currentNode
        currentNode.right = y.left; // biến cây con bên trái của y thành cây con của currentNode

        if (y.left != NIL)
            y.left.parent = currentNode; // nếu tồn tại, đặt cây mẹ ở cây con bên trái là currentNode

        y.parent = currentNode.parent;  // đặt cha của y thành cha của currentNode

        if (currentNode.parent == NIL){
            root = y;
        }else if (currentNode.parent.left == currentNode){
            currentNode.parent.left = y;
        }else {
            currentNode.parent.right = y;
        }
        y.left = currentNode; // đặt currentNode bên trái của y
        currentNode.parent = y;
    }
    //-------------------------------------------------xoay phải---------------------------------------//
    public  void rightRotate(Node currentNode) {
        Node y = currentNode.left; // đặt y là con trái của currentNode
        currentNode.left = y.right; // biến cây con bên phải của y thành cây con của currentNode

        if (y.right != NIL)
            y.right.parent = currentNode; // nếu tồn tại, hãy đặt cây mẹ ở cây con bên phải thành currentNode
        y.parent = currentNode.parent;  // đặt cha của y thành cha của currentNode

        if (currentNode.parent == NIL){
            root = y;
        }else if (currentNode.parent.left == currentNode){
            currentNode.parent.left = y;
        }else {
            currentNode.parent.right = y;
        }
        y.right = currentNode;// đặt currentNode ở bên phải của y
        currentNode.parent = y;
    }

    // ---------------Chèn----------//
    public  void insert (Node currentNode){
        Node y;
        currentNode.colorIsRed = true;
        while (currentNode != root && !currentNode.parent.colorIsRed){
            if(currentNode == currentNode.parent.parent.left){
                y = currentNode.parent.parent.right;
                if(y.colorIsRed){
                        y.parent.colorIsRed = false;
                        y.colorIsRed = false;
                        currentNode = currentNode.parent.parent ;
                }else {
                    if (currentNode == currentNode.parent.right) {
                        currentNode = currentNode.parent;
                        leftRotate(currentNode);
                    }
                    currentNode.parent.colorIsRed = false;
                    currentNode.parent.parent.colorIsRed = true;
                    rightRotate(currentNode.parent.parent);
                }
            }else{
                y = currentNode.parent.parent.left;
                if(y.colorIsRed){
                    y.parent.colorIsRed = false;
                    y.colorIsRed = false;
                    currentNode = currentNode.parent.parent ;
                }else {
                    if (currentNode == currentNode.parent.left) {
                        currentNode = currentNode.parent;
                        leftRotate(currentNode);
                    }
                    currentNode.parent.colorIsRed = false;
                    currentNode.parent.parent.colorIsRed = true;
                    rightRotate(currentNode.parent.parent);
                }
            }
        }
        root.colorIsRed = false;
    }

    // ---------------Tìm kiếm----------//

    public Node search1(Node currentNode, int key) {
        currentNode = root;
        while (currentNode != NIL) {
            if (key == currentNode.value) {
                return currentNode;
            } else if (key > currentNode.value) {
                currentNode = currentNode.right;
            } else {
                currentNode = currentNode.left;
            }
        }
        return null;
    }

    //Sử dụng đệ quy
    public Node search2(Node currentNode, int key) {
        if (currentNode == NIL || key == currentNode.value) {
            return currentNode;
        }

        if (key < currentNode.value) {
            return search2(currentNode.left, key);
        }
        return search2(currentNode.right, key);
    }

}
