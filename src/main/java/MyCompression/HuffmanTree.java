package MyCompression;

public class HuffmanTree implements  Comparable<HuffmanTree> {
    private final HuffmanBaseNode root;

    public HuffmanTree(char element, int weight) {
        this.root = new HuffmanLeafNode(element,weight);

    }

    public HuffmanTree(HuffmanBaseNode left, HuffmanBaseNode right, int weight) {
        this.root = new HuffmanTreeNode(weight, left, right);
    }

    int getWeight() {
        return root.getWeight();
    }

    public HuffmanBaseNode getRoot() {
        return root;
    }

    @Override
    public int compareTo(HuffmanTree o) {
        return Integer.compare(root.getWeight(), o.getWeight());
    }
}

