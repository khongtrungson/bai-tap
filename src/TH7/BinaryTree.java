package TH7;

public class BinaryTree {
    class TreeNode {
        String value;
        TreeNode left, right;

        public TreeNode(String value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
        public boolean isLeaf() {
            return left == null && right == null;
        }

    }
    private TreeNode root;

    public BinaryTree(TreeNode root) {
        this.root = root;
    }
    public int evaluate(TreeNode node) {
        if (node == null) {
            throw new IllegalArgumentException("Node is null");
        }
        if (node.isLeaf()) {
            return Integer.parseInt(node.value);
        }

        int leftValue = evaluate(node.left);
        int rightValue = evaluate(node.right);

        switch (node.value) {
            case "+": return leftValue + rightValue;
            case "-": return leftValue - rightValue;
            case "*": return leftValue * rightValue;
            case "/": return rightValue != 0 ? leftValue / rightValue : 0;
            default: throw new IllegalArgumentException("Invalid operator: " + node.value);
        }
    }
    public void traverse(TreeNode node, String order) {
        if (node == null) return;

        switch (order) {
            case "preorder":
                System.out.println(node.value);
                traverse(node.left, order);
                traverse(node.right, order);
                break;
            case "inorder":
                traverse(node.left, order);
                System.out.println(node.value);
                traverse(node.right, order);
                break;
            case "postorder":
                traverse(node.left, order);
                traverse(node.right, order);
                System.out.println(node.value);
                break;
            default:
                throw new IllegalArgumentException("Invalid traversal order");
        }
    }
}
