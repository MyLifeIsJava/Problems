package hackerrank.datastructures.trees;

/**
 * Problem statement : https://www.hackerrank.com/challenges/tree-huffman-decoding/problem
 * 
 * @author kiran
 *
 */
public class Tree_Huffman_Decoding {

    private static class Node {
        public int frequency; // the frequency of this tree
        public char data;
        public Node left, right;
    }
    
    public static void main(String[] args) {
        Tree_Huffman_Decoding obj = new Tree_Huffman_Decoding();
        Node root = new Node();
        Node left = new Node();
        Node right = new Node();
        right.data = 'A';
        root.left = left;
        root.right = right;
        Node root2 = left;
        left = new Node();
        left.data = 'B';
        right = new Node();
        right.data='C';
        root2.left = left;
        root2.right = right;
        obj.decode("1001011", root );
    }
    static void print(char c) {
        System.out.println(c);
    }
    void decode(String S ,Node root){
        StringBuilder result = new StringBuilder();
        if(root != null && S.length() > 0) {
            Node currNode = root;
            for(int i=0; i < S.length(); i++){
//              Loop until we hit a leaf node
                currNode = S.charAt(i) == '1' ? currNode.right : currNode.left;
                if(currNode.left == null && currNode.right == null) {
                    result.append(currNode.data);
                    currNode = root;
                }
            }
        }
        System.out.print(result);
    }
}
