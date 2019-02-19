package dependencyTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Node {
    private static Integer counter=0;
    public Integer NodeId;
    public String NodeName;
    public HashMap<String, String> NodeInfo = new HashMap<String, String>();
    public List<Node> children=new ArrayList<>();
    public List<Node> parent=new ArrayList<>();

    public void Nodecreate(String name, HashMap<String, String> NodeInfo) {
        this.NodeId=counter++;
        this.NodeName=name;
        this.NodeInfo=NodeInfo;
        System.out.println("Node created.");
    }
    public List<Node> getparent() {
        if(this.parent.isEmpty()) {
            System.out.println("No parent exist for the node.");
        }
        return this.parent;
    }
    public List<Node> getchildren() {
        if(this.parent.isEmpty()) {
            System.out.println("No children exist for the node.");
        }
        return this.children;
    }
    public List<Node> getancestors(){
        Node node=this;
        List<Node> ancestors=new ArrayList<>();
        if(node==null) {
            System.out.println("Null Node Exception.");
            return ancestors;
        }
        if(node.parent==null) {
            System.out.println("Reached node with no parent.");
            return ancestors;
        }
        for(Node i : node.parent) {
            ancestors.add(i);
            ancestors.addAll(i.getancestors());

        }

        return ancestors;
    }
    public List<Node> getdescendants(){
        Node node=this;
        List<Node> descendants=new ArrayList<>();
        if(node==null){
            System.out.println("Null Node Exception.");
            return descendants;
        }
        if(node.children==null) {
            System.out.println("Reached node with no children.");
            return descendants;
        }
        for(Node i : node.children) {
            descendants.add(i);
            descendants.addAll(i.getdescendants());
        }
        return descendants;
    }
    public void AddDependency(Node child) {
        System.out.println("Hello...creating dependency");
        child.parent.add(this);

        this.children.add(child);
        System.out.println("Dependency created.");
        return;

    }
    public void deleteDependency(Node child) {
        System.out.println("Hello...deleting dependency");
        child.parent.remove(this);
        this.children.remove(child);
        System.out.println("Dependency deleted.");
        return;
    }
    public void deleteNode() {
        System.out.println("Hello...deleting nodes");

        for(Node i: this.parent) {
            i.children.remove(this);
        }
        this.parent.clear();
        for(Node i:this.children) {
            i.parent.remove(this);
        }
        this.children.clear();

        System.out.println("Node deleted.");
        return;
    }
}
