package coding.challenge3.huffmanCompression;

public class SearchTrie {
    private final String value;
    private final SearchTrie left;
    private final SearchTrie right;

    public SearchTrie(String value) {
        this.value = value;
        left = null;
        right = null;
    }

    public SearchTrie(String value, SearchTrie left, SearchTrie right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public String getValue() {
        return value;
    }

    public SearchTrie getLeft() {
        return left;
    }

    public SearchTrie getRight() {
        return right;
    }

    void printLevelOrder()
    {
        int h = height(this);
        int i;
        for (i = 1; i <= h; i++)
            printCurrentLevel(this, i);
    }

    // Compute the "height" of a tree -- the number of
    // nodes along the longest path from the root node
    // down to the farthest leaf node.
    int height(SearchTrie root)
    {
        if (root == null)
            return 0;
        else {

            // Compute  height of each subtree
            int lheight = height(root.left);
            int rheight = height(root.right);

            // use the larger one
            if (lheight > rheight)
                return (lheight + 1);
            else
                return (rheight + 1);
        }
    }

    // Print nodes at the current level
    void printCurrentLevel(SearchTrie root, int level)
    {
        if (root == null)
            return;
        if (level == 1) {
            try {
                Integer.valueOf(root.value);
            } catch (NumberFormatException e) {
                System.out.println(root.value + " ");
            }
        }
        else if (level > 1) {
            printCurrentLevel(root.left, level - 1);
            printCurrentLevel(root.right, level - 1);
        }
    }
    @Override
    public String toString() {
        printLevelOrder();
        return "";
    }
}
