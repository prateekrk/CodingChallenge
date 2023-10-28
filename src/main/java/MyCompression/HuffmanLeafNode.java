package MyCompression;

public class HuffmanLeafNode implements HuffmanBaseNode{
    private final char element;
    private final int weight;

    HuffmanLeafNode(char element, int weight) {
        this.element = element;
        this.weight = weight;
    }

    public char getElement() {
        return element;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public boolean isLeaf() {
        return true;
    }
}
