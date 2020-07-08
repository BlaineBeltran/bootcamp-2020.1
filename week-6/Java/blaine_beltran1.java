
/**
 * PROMPT: 
 * 1. Find Maximum Difference Between a Node and its Descendants in a Binary Tree. 
 * NOTE: Use AtomicInteger class to update int value automatically 
 */
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created Structure to store BT node
 */
class Node {
    int num;
    Node left = null, right = null;

    Node(int num) {
        this.num = num;
    }
}

public class blaine_beltran1 {

    /**
     * This is a helper function to solve max diff between node and ALL descendants
     * 
     * @param root
     * @param diff
     * @return
     */
    public static int maxDiff(Node root, AtomicInteger diff) {
        if (root == null) { // This is case zero
            return Integer.MAX_VALUE;
        }

        int left = maxDiff(root.left, diff);
        int right = maxDiff(root.right, diff);
        int differ = root.num - Math.min(left, right);
        diff.set(Math.max(diff.get(), differ));
        return Math.min(Math.min(left, right), root.num);
    }

    public static int maxDiff(Node root) {
        AtomicInteger diff = new AtomicInteger(Integer.MIN_VALUE);
        maxDiff(root, diff);
        return diff.get();
    }

    public static void main(String[] args) {
        /**
         * Create Tree
         */

        Node root = new Node(6);
        root.left = new Node(3);
        root.right = new Node(8);
        root.right.left = new Node(2);
        root.right.right = new Node(4);
        root.right.left.left = new Node(1);
        root.right.left.right = new Node(7);

        System.out.println((maxDiff(root)));

    }
}