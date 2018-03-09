package others.datastructures;

import java.util.LinkedList;

/**
 * Root, Left, Right
 * 
 * @author kiran
 *
 */
public class PreOrderTraversal {

    public static void main(String[] args) {
        System.out.println("------- Recursive -----");
        preorder_recursive(InorderTraversal.getTree());
        System.out.println("------- Iterative -----");
        preorder_iterative(InorderTraversal.getTree());
        
    }

    public static <T> void preorder_recursive(TreeNode<T> node) {
        if(node == null)
            return;
        System.out.println(node);
        preorder_recursive(node.getLeft());
        preorder_recursive(node.getRight());
    }
    
    public static <T> void preorder_iterative(TreeNode<T> node) {
        if(node == null)
            return;
        LinkedList<TreeNode<T>> stack = new LinkedList<>();
        TreeNode<T> currNode = node;
        stack.addFirst(node);
        while(!stack.isEmpty()) {
            currNode = stack.removeFirst();
            System.out.println(currNode);
            if(currNode.getRight() != null)
                stack.addFirst(currNode.getRight());
            if(currNode.getRight() != null)
                stack.addFirst(currNode.getLeft());
        }
    }
}
