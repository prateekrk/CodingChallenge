package MyCompression;

public class HuffmanTreeNode implements HuffmanBaseNode {
    private final int weight;
    private final HuffmanBaseNode leftLeafNode;
    private final HuffmanBaseNode rightLeafNode;

    public HuffmanBaseNode getLeftLeafNode() {
        return leftLeafNode;
    }

    public HuffmanBaseNode getRightLeafNode() {
        return rightLeafNode;
    }

    public HuffmanTreeNode(int weight, HuffmanBaseNode leftLeafNode, HuffmanBaseNode rightLeafNode) {
        this.weight = weight;
        this.leftLeafNode = leftLeafNode;
        this.rightLeafNode = rightLeafNode;
    }

    @Override
    public int getWeight() {
        return weight;
    }

    @Override
    public boolean isLeaf() {
        return false;
    }
}
