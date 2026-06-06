import java.util.*;
public class LevelOrderTraversalBinaryTree {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }

    }

    static class BinaryTrees{
        static int idx = -1;
        public static Node BuildTree(int Nodes[]){
            idx++;
            if(Nodes[idx] == -1){
                return null;
            }
            Node newNode = new Node(Nodes[idx]);
            newNode.left = BuildTree(Nodes);
            newNode.right = BuildTree(Nodes);

            return newNode;
        }
    }
    public static void preorder(Node root){
        if(root == null){
            return;
        }
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }
    public static void LevelOrder(Node root){
        if(root == null){
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while(!q.isEmpty()){
            Node CurrNode = q.remove();
            if(CurrNode == null){
                System.out.println();
                if(q.isEmpty()){
                    break;
                }
                else{
                    q.add(null);
                }
            }
            else{
                System.out.print(CurrNode.data + " ");
                if(CurrNode.left != null){
                    q.add(CurrNode.left);
                }
                if(CurrNode.right != null){
                    q.add(CurrNode.right);
                }
            }
        }
    }
    public static void main(String[] args) {
        int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        BinaryTrees Tree = new BinaryTrees();
        Node root = BinaryTrees.BuildTree(nodes);
        // System.out.println(root.data);
        LevelOrder(root);    
        
    }
}
