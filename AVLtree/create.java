import java.util.*;
class AVL{
   static class Node{
        int data;
        Node left,right;
        int height;
        Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
            this.height=1;
        }
    }
    public static int getHeight(Node root){
        if(root==null){
            return 0;
        }
        return root.height;
    }
    public static int getBalance(Node root){
        return getHeight(root.left)-getHeight(root.right);
    }

    public static Node rightRotation(Node root){
        Node child=root.left;
        Node childRight=child.right;

        child.right=root;
        root.left=childRight;
        // update height
        root.height=1+Math.max(getHeight(root.left),getHeight(root.right));
        child.height=1+Math.max(getHeight(child.left),getHeight(child.right));
        return child;
    }
    public static Node leftRotation(Node root){
        Node child=root.right;
        Node childLeft=child.left;

        child.left=root;
        root.right=childLeft;

         root.height=1+Math.max(getHeight(root.left),getHeight(root.right));
        child.height=1+Math.max(getHeight(child.left),getHeight(child.right));
    return child;
    }

    public static Node create(Node root,int data){
        Node newNode=new Node(data);
        // if root is null
        if(root==null){
            return newNode;
        }
        // if root exist
        if(data<root.data){//left side
            root.left=create(root.left,data);
        }
        else if(data>root.data){//right side
            root.right=create(root.right,data);
        }
        else{//if equal
            return root;
        }
        // update height
        root.height=1+Math.max(getHeight(root.left),getHeight(root.right));

        // 
        int balance=getBalance(root);

        //  left left case
        if(balance>1 && data<root.left.data){
          return  rightRotation(root);
        }
        // right right case
        else if(balance<-1 && data>root.right.data){
           return leftRotation(root);
        }
        //left right case
        else if(balance>1 && data>root.left.data){
           root.left= leftRotation(root.left);
           return rightRotation(root);

        }
        // right left case
        else if(balance<-1 && data<root.right.data){
           root.right= rightRotation(root.right);
           return leftRotation(root);
        }
        // no unbalance
        else {
            return root;
        }

    }
public static void preOrder(Node root){
    if(root==null){
        return ;
    }
    System.out.print(root.data+"  ");
    preOrder(root.left);
    preOrder(root.right);
}

    public static void main(String[] args){
// dublicates elements are not allowed
    Node root=null;

    root=create(root,10);
    root=create(root,20);
    root=create(root,5);
    root=create(root,50);
    root=create(root,60);
    preOrder(root);

    }
}