package hackerrank.datastructures.trees;

public class Binary_Search_Tree_Lowest_Common_Ancestor {

    public static void main(String[] args) {
        /*Node node = new Node(); node.data = 100;
        node.left = new Node(); node.left.data = 50;
        node.right = new Node();node.right.data = 150;
        node.left.left = new Node();node.left.left.data = 25;
        node.left.right = new Node();node.left.right.data = 75;
        node.right.left = new Node();node.right.left.data = 125;
        node.right.right = new Node(); node.right.right.data = 175;
        */
        
        Node rootNode = new Node(); rootNode.data = 4;
        rootNode.left = new Node(); rootNode.left.data = 2;
        rootNode.right = new Node();rootNode.right.data = 7;
        Node node = rootNode.left;
        node.left = new Node(); node.left.data = 1;
        node.right = new Node();node.right.data = 3;
        node = rootNode.right;
        node.left = new Node(); node.left.data = 6;
        
        Node lca = lca(rootNode, 1, 7);
        System.out.println(lca);
    }

    private static class Node{ 
        int data;
        Node left;
        Node right;
        public String toString() {
            return "" + data;
        }
    }

    
    static Node lca(Node root,int val1,int val2){
        if(root == null)
            return root;
        v1 = val1;
        v2 = val2;
        if(root.data == v1 || root.data == v2)
            return root;
        lca(root);
        if(v1_found && v2_found)
            return lca;
        return null;
    }
    
    private static boolean v1_found = false;
    private static boolean v2_found = false;
    private static int v1;
    private static int v2;
    private static Node lca = null;
    
    static Node lca(Node node){
//        System.out.println("Handling node: "+ node);
        if(v1_found && v2_found)
            return lca;
        
        if(node.data == v1) {
            v1_found = true;
            return node;
        }
        if(node.data == v2) {
            v2_found = true;
            return node;
        }
        
        Node lcaLeft = null;
        Node lcaRight = null;
        
//        if(v1 < node.data || v2 < node.data) {
            if(node.left != null) {
                lcaLeft = lca(node.left);
            }
//        }
//        We might find the LCA on left tree itself, then no need to go right
        if(lca != null)
            return lca;
        
//        if(v1 > node.data || v2 > node.data) {
            if(node.right != null) {
                lcaRight = lca(node.right);
            }
//        }
        if(lca == null && lcaLeft != null && lcaRight != null) {
            lca = node;
            return node;
        }
        
        return lcaLeft == null ? lcaRight : lcaLeft;
    }
}
