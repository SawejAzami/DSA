import java.util.*;
class Tree{
    public static class Range{
        int l=0;
        int r=0;
        int p=0;
// In Java, int is a primitive type and is passed by value, not by reference.
    }
    public static class Node{
        int data;
        Node left,right;
        Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }
    public static int findPosition(int in[],int target,int start,int end){
        for(int i=start;i<=end;i++){
            if(in[i]==target)return i;
        }
        return -1;
    }

public static Node treeUsingPostorderAndInoder(int post[],int in[],int start,int end,int index){
    if(start>end){
        return null;
    }
    Node newNode=new Node(post[index]);
    int pos=findPosition(in,post[index],start,end);
   newNode.right= treeUsingPostorderAndInoder(post,in,pos+1,end,index-1);
   newNode.left= treeUsingPostorderAndInoder(post,in,start,pos-1,index-(end-pos)-1);
    return newNode;
}

 public static void find(Node root,int pos,Range range){
        if(root==null){
            return ;
        }
        range.l=Math.min(range.l,pos);
        range.r=Math.max(range.r,pos);
        find(root.left,pos-1,range);
        find(root.right,pos+1,range);
        
    }
    public static void leftView(Node root){
        if(root==null)return;
        System.out.print(root.data+" ");
        if(root.left!=null){
            leftView(root.left);
        }else{
            leftView(root.right);
        }
    }

 public static void preOrderTraversal(Node root){
        Stack<Node> s=new Stack<>();
        s.push(root);
        while(!s.isEmpty()){
            Node temp=s.pop();
            System.out.print(temp.data+" ");
            //   put R first then L so that we can read L first
            if(temp.right!=null){
                s.push(temp.right);
            }
            if(temp.left!=null){
                s.push(temp.left);
            }
        }
    }
   
    
   

    public static void main(String[] arg){
        int pre[]={1,2,4,7,9,10,8,5,3,6};
        int post[]={10,9,7,8,4,5,2,6,3,1};
        int in[]={7,10,9,4,8,2,5,1,3,6};
       Node root= treeUsingPostorderAndInoder(post,in,0,post.length-1,post.length-1);
        // rightViewOfTree(root);
        
        // ArrayList<Integer> ans=boundaryView(root);
        // leftViewOfTreeByRecursion(ans,0,root);
    //    for(int i=0;i<ans.size();i++){
    //     System.out.print(ans.get(i)+" ");
    //    }
    // leftViewOfTree(root);
    leftView(root);
        //   levelOrderTravelsalBySipral(root);
        // System.out.print(sizeOfBinaryTree(root));


       
    }
}