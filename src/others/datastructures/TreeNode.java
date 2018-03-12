package others.datastructures;

import java.util.ArrayList;
import java.util.List;

public class TreeNode <T>{
    T value;
    List<TreeNode<T>> children;
    
    public T getValue() {
        return value;
    }
    public void setValue(T value) {
        this.value = value;
    }
    public List<TreeNode<T>> getChildren() {
        return children;
    }
    public void setChildren(List<TreeNode<T>> children) {
        this.children = children;
    }
    public void addChild(TreeNode<T> node) {
        if(children == null)
            children = new ArrayList<>();
        children.add(node);
    }
}
