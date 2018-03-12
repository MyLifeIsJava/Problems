package others.datastructures;

import java.util.HashSet;
import java.util.LinkedList;

/**
 * Left, Right, Root
 * 
 * @author kiran
 *
 */
public class PostOrderTraversal {

    public static void main(String[] args) {
        System.out.println("------- Recursive -----");
        postorder_recursive(InorderTraversal.getTree());
        System.out.println("------- Iterative -----");
        postorder_iterative(InorderTraversal.getTree());
        
    }

    public static <T> void postorder_recursive(BinaryTreeNode<T> node) {
        if(node == null)
            return;
        postorder_recursive(node.getLeft());
        postorder_recursive(node.getRight());
        System.out.println(node);
    }
    
    public static <T> void postorder_iterative(BinaryTreeNode<T> node) {
        if(node == null)
            return;
        HashSet<BinaryTreeNode<T>> traversedNodes = new HashSet<>();
        LinkedList<BinaryTreeNode<T>> stack = new LinkedList<>();
        BinaryTreeNode<T> currNode = node;
        stack.addFirst(node);
        while(!stack.isEmpty()) {
            currNode = stack.getFirst();
            boolean traversed = traversedNodes.remove(currNode);
            if(!traversed) {
                traversedNodes.add(currNode);
                if(currNode.getRight() != null)
                    stack.addFirst(currNode.getRight());
                if(currNode.getLeft() != null)
                    stack.addFirst(currNode.getLeft());
            }else {
                stack.removeFirst();
                System.out.println(currNode);
            }
        }
    }
}
