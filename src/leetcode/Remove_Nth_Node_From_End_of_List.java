package leetcode;

/**
 * Problem description : https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/
 * Status: Completed
 * @author kiran
 *
 */
public class Remove_Nth_Node_From_End_of_List {

    public static class ListNode {
         int val;
         ListNode next;
         ListNode(int x) { val = x; }
         public void next(ListNode next) {
             this.next = next;
         }
         public void print() {
             System.out.print(val);
             if(next != null) {
                 System.out.print("->");
                 next.print();
             }
         }
    }
    
    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode node2 = new ListNode(2); node.next = node2;
        ListNode node3 = new ListNode(3); node2.next = node3;
        ListNode node4 = new ListNode(4); node3.next = node4;
        ListNode node5 = new ListNode(5); node4.next = node5;
        node.print();
        System.out.println();
        Remove_Nth_Node_From_End_of_List obj = new Remove_Nth_Node_From_End_of_List();
        node = obj.removeNthFromEnd(node, 2);
        if(node == null) {
            System.out.println("NULL");
        }else {
            node.print();
        }
        System.out.println();
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null)
            return null;
        if(n <= 0)
            return head;
        
        ListNode nodeToRemove = head;
        ListNode parentNode = null;
        int nodeCounter = 0;
        ListNode currNode = head;
        while(currNode != null) {
            currNode = currNode.next;
            nodeCounter ++;
            if(nodeCounter > n) {
                parentNode = nodeToRemove;
                nodeToRemove = nodeToRemove.next;
            }
        }
        if(nodeToRemove != null && nodeCounter >= n) {
            if(parentNode == null) {
                head = nodeToRemove.next;
                nodeToRemove = null;
            }
            else {
                parentNode.next = nodeToRemove.next;
                nodeToRemove = null;
            }
        }
        return head;
    }
}
