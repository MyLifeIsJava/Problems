package others.datastructures;

import java.util.LinkedList;

/**
 * Left , Root, Right
 * 
 * @author kiran
 *
 */
public class InorderTraversal {

    public static void main(String[] args) {
        System.out.println("-------- Iterative -----");
        inorder_iterative(getTree());
        System.out.println("-------_ Recursive -----");
        inorder_recursive(getTree());
    }
    
    public static BinaryTreeNode<Integer> getTree() {
        int count = 1;
        
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(count++);
        
        BinaryTreeNode<Integer> left = new BinaryTreeNode<Integer>(count++);
        root.setLeft(left);
        BinaryTreeNode<Integer> right = new BinaryTreeNode<Integer>(count++);
        root.setRight(right);
        
        BinaryTreeNode<Integer> currNode1 = left;
        BinaryTreeNode<Integer> currNode2 = right;
        
        left = new BinaryTreeNode<Integer>(count++);
        currNode1.setLeft(left);
        right = new BinaryTreeNode<Integer>(count++);
        currNode1.setRight(right);
        
        left = new BinaryTreeNode<Integer>(count++);
        currNode2.setLeft(left);
        right = new BinaryTreeNode<Integer>(count++);
        currNode2.setRight(right);
        
        /*
        TreeNode<Integer> root = new TreeNode<>(1);
        root.setRight(new TreeNode<Integer>(2));
        root.getRight().setLeft(new TreeNode<Integer>(3));
                
        */
        
        return root;
    }

    public static <T> void inorder_recursive(BinaryTreeNode<T> node) {
        if(node == null)
            return;
        inorder_recursive(node.getLeft());
        System.out.println(node.getValue());
        inorder_recursive(node.getRight());
    }
    
    public static <T> void inorder_iterative(BinaryTreeNode<T> node) {
        if(node == null)
            return;
        LinkedList<BinaryTreeNode<T>> stack = new LinkedList<>();
        BinaryTreeNode<T> currNode = node;
        while(currNode != null) {
            stack.addFirst(currNode);
            currNode = currNode.getLeft();
        }
        
        while(!stack.isEmpty()) {
            currNode = stack.removeFirst();
            System.out.println(currNode);
            currNode = currNode.getRight();
            while(currNode != null) {
                stack.addFirst(currNode);
                currNode = currNode.getLeft();  
            }
        }
    }
}
