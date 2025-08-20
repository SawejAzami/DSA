
import java.util.*;
class Tree{
    public static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }
    public static Node root;
   public static void createByLevel(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the root value");
        int val=sc.nextInt();
        Queue<Node> q=new LinkedList<>();
        Node newNode=new Node(val);
        root=newNode;
        q.add(newNode);
        while(!q.isEmpty()){
            Node temp=q.remove();
            System.out.println("enter the value for left node");
            int leftVal=sc.nextInt();
            if(leftVal!=-1){
                temp.left=new Node(leftVal);
                q.add(temp.left);
            }
            System.out.println("enter the value for right node");
            int rightVal=sc.nextInt();
            if(rightVal!=-1){
                temp.right=new Node(rightVal);
                q.add(temp.right);
            }
        }
    }
    public static void printByPreorder(Node temp){
        if(temp==null){
            return;
        }
        System.out.print(""+temp.data);
        printByPreorder(temp.left);
        printByPreorder(temp.right);
    }
   


    public static void main(String[] arg){
        createByLevel();
        printByPreorder(root);
    }
}