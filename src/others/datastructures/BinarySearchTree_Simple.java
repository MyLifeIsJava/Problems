package others.datastructures;

/**
 * A simplete binary tree implementation. 
 * The nodes on left side will have smaller values.
 * The nodes on right side will have greater values.
 * There will be no duplicate values.
 * 
 * @author kiran
 *
 */
public class BinarySearchTree_Simple<T> {

    public static void main(String[] args) {
        BinarySearchTree_Simple<Integer> tree = new BinarySearchTree_Simple(new Integer[]{4,2,3,1,7,6, 8, 2, 4, 4, 5});
        System.out.println("Traversing");
        InorderTraversal.inorder_iterative(tree.rootNode);
        
        System.out.println("Deleting 1");
        tree.deleteTreeNode(1);
        InorderTraversal.inorder_iterative(tree.rootNode);
        
        System.out.println("Deleting 4");
        tree.deleteTreeNode(4);
        InorderTraversal.inorder_iterative(tree.rootNode);
        
        System.out.println(tree.search(6));
        System.out.println(tree.search(4));
    }

    private BinaryTreeNode<T> rootNode = null;
    
    public BinarySearchTree_Simple() {
        
    }
    public BinarySearchTree_Simple(T ...data){
        if(data == null || data.length == 0)
            return;
        
        rootNode = new BinaryTreeNode<>(data[0]);
        for(int i=1; i <  data.length; i++) {
            rootNode = addTreeNode(rootNode, data[i]);
        }
    }
    
    final int compare(Object k1, Object k2) {
        return  ((Comparable)k1).compareTo((Comparable)k2);
    }
    
    public void deleteTreeNode(T value){
        rootNode = deleteTreeNode(rootNode, value);
    }
    
    private BinaryTreeNode<T> deleteTreeNode(BinaryTreeNode<T> node, T value) {
//        If node is leaf, just delete it
//        If node has only one child (left or right), then just move its child one level up
//        If node has two children, then replace the node with the leftmost (smallest value) node in the right subtree
        if(node == null)
            return null;
        int comp = compare(node.getValue(), value);
        if(comp < 0)
            node.setLeft(deleteTreeNode(node.getLeft(), value));
        else if(comp > 0)
            node.setRight(deleteTreeNode(node.getRight(), value));
        else {
//            This node's value matches
            if(node.getLeft() == null)
                return node.getRight();
            else if(node.getRight() == null)
                return node.getLeft();
            else {
                BinaryTreeNode<T> smallest = getSmallestChild(node.getRight());
                node.setValue(smallest.getValue());
                node.setRight(deleteTreeNode(node.getRight(), smallest.getValue()));
            }
            
        }
        return node;
    }
    
    private BinaryTreeNode<T> getSmallestChild(BinaryTreeNode<T> rootNode){
        BinaryTreeNode<T> currNode = rootNode;
        while(currNode.getLeft() != null) {
            currNode = currNode.getLeft();
        }
        return currNode;
    }
    
    public boolean search(T value) {
        BinaryTreeNode<T> node = search(rootNode, value);
        return node != null;
    }
    
    private BinaryTreeNode<T> search(BinaryTreeNode<T> node, T value){
        if(node == null || value == null)
            return null;
        
        int comp =compare(node.getValue() , value);
        if(comp < 0)
            return search(node.getLeft(), value);
        else if(comp > 0)
            return search(node.getRight(), value);
        else
            return node;
    }
    
    public BinaryTreeNode<T> addTreeNode(BinaryTreeNode<T> node, T newNodeValue) {
        if(node == null) {
            node = new BinaryTreeNode<>(newNodeValue);
            return node;
        }
        int comparision = compare(node.getValue(), newNodeValue);
        if(comparision < 0)
            node.setLeft(addTreeNode(node.getLeft(), newNodeValue));
        else if(comparision > 0)
            node.setRight(addTreeNode(node.getRight(), newNodeValue));
        return node;
    }
}
