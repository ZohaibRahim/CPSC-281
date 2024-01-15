package Q2;

class TreeNode {
    char data;
    int frequency;
    TreeNode left, right;

    public TreeNode(char data, int frequency) {
        this.data = data;
        this.frequency = frequency;
        this.left = this.right = null;
    }
}
