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
    
    public static TreeNode<Integer> getTree() {
        int count = 1;
        
        TreeNode<Integer> root = new TreeNode<>(count++);
        
        TreeNode<Integer> left = new TreeNode<Integer>(count++);
        root.setLeft(left);
        TreeNode<Integer> right = new TreeNode<Integer>(count++);
        root.setRight(right);
        
        TreeNode<Integer> currNode1 = left;
        TreeNode<Integer> currNode2 = right;
        
        left = new TreeNode<Integer>(count++);
        currNode1.setLeft(left);
        right = new TreeNode<Integer>(count++);
        currNode1.setRight(right);
        
        left = new TreeNode<Integer>(count++);
        currNode2.setLeft(left);
        right = new TreeNode<Integer>(count++);
        currNode2.setRight(right);
        
        /*
        TreeNode<Integer> root = new TreeNode<>(1);
        root.setRight(new TreeNode<Integer>(2));
        root.getRight().setLeft(new TreeNode<Integer>(3));
                
        */
        
        return root;
    }

    public static <T> void inorder_recursive(TreeNode<T> node) {
        if(node == null)
            return;
        inorder_recursive(node.getLeft());
        System.out.println(node.getValue());
        inorder_recursive(node.getRight());
    }
    
    public static <T> void inorder_iterative(TreeNode<T> node) {
        if(node == null)
            return;
        LinkedList<TreeNode<T>> stack = new LinkedList<>();
        TreeNode<T> currNode = node;
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
