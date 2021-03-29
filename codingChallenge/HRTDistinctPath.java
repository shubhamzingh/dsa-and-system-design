import java.util.HashMap;

class Node
{
    int data;
    Node left, right;
};



public class HRTDistinctPath {
    static int largestUinquePathUtil(Node node, HashMap<Integer,
                Integer> m)
    {
        /*if (node == null)
            return m.size();

        // put this node into hash
        if(m.containsKey(node.data))
        {
            m.put(node.data, m.get(node.data) + 1);
        }
        else
        {
            m.put(node.data, 1);
        }

        int max_path = Math.max(largestUinquePathUtil(node.left, m),
                largestUinquePathUtil(node.right, m));

        // remove current node from path "hash"
        if(m.containsKey(node.data))
        {
            m.put(node.data, m.get(node.data) - 1);
        }

        // if we reached a condition where all duplicate value
        // of current node is deleted
        if (m.get(node.data) == 0)
            m.remove(node.data);

        return max_path;*/
        return 0;
    }

    // A utility function to find long unique value path
    static int largestUinquePath(Node node)
    {
        if (node == null)
            return 0;

        // hash that store all node value
        HashMap<Integer,
                Integer> hash = new HashMap<Integer,
                Integer>();

        // return max length unique value path
        return largestUinquePathUtil(node, hash);
    }

    // Driver Code
    public static void main(String[] args)
    {
        // Create binary tree shown in above figure
        Node root = newNode(1);
        root.left = newNode(2);
        root.right = newNode(3);
        root.left.left = newNode(4);
        root.left.right = newNode(5);
        root.right.left = newNode(6);
        root.right.right = newNode(7);
        root.right.left.right = newNode(8);
        root.right.right.right = newNode(9);

        System.out.println(largestUinquePath(root));
    }

    private static Node newNode(int i) {
        {
            Node temp = new Node();
            temp.data = i;
            temp.left = temp.right = null;
            return temp;
        }
    }
}
