package others.datastructures;

import java.util.LinkedList;

/**
 * Level order
 * 
 * @author kiran
 *
 */
public class BFSTraversal {

    public static void main(String[] args) {
         System.out.println("------- Recursive -----");
         levelorder_recursive(InorderTraversal.getTree());
        System.out.println("------- Iterative -----");
        levelorder_iterative(InorderTraversal.getTree());

    }

    public static <T> void levelorder_recursive(TreeNode<T> node) {
        LinkedList<TreeNode<T>> queue = new LinkedList<>();
        queue.add(node);
        levelorder_recursive(queue);
    }
    
    public static <T> void levelorder_recursive(LinkedList<TreeNode<T>> queue) {
        if(queue.isEmpty())
            return;
        LinkedList<TreeNode<T>> queue2 = new LinkedList<>();
        while(!queue.isEmpty()) {
            TreeNode<T> node = queue.removeFirst();
            System.out.println(node);
            if(node.getLeft() != null)
                queue2.addLast(node.getLeft());
            if(node.getRight() != null)
                queue2.addLast(node.getRight());
        }
        levelorder_recursive(queue2);
    }
    
    public static <T> void levelorder_iterative(TreeNode<T> node) {
        if(node == null)
            return;
        LinkedList<TreeNode<T>> queue = new LinkedList<>();
        TreeNode<T> currNode = node;
        queue.addFirst(node);
        while(!queue.isEmpty()) {
            currNode = queue.removeFirst();
            System.out.println(currNode);
            if(currNode.getLeft() != null)
                queue.addLast(currNode.getLeft());
            if(currNode.getRight() != null)
                queue.addLast(currNode.getRight());
        }
    }
}
