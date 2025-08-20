// maximum path sum between two special node 
// special node means which are connected to only one node
// leaf node are special
// root can be special when it is connected to only one node

import java.util.*;
class Tree{
    public static class Range{
        int sum=0;
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

public static int maxPathSum(Node root,Range sum){
    if(root==null)return 0;
    // leaf node
    if(root.left==null && root.right==null)
        return root.data;
    
    int left=maxPathSum(root.left,sum);
    int right=maxPathSum(root.right,sum);
    // if both exist
    if(root.left!=null&&root.right!=null){
        sum.sum=Math.max(sum.sum,root.data+left+right);
        return root.data+Math.max(left,right);
    }
    // only left exist
    if(root.left!=null)
        return root.data+left;
    
    // only right exist
    if(root.right!=null)
        return root.data+right;
    return 0;
}



    public static void main(String[] arg){
        int pre[]={1,2,4,7,8,5,3,6};
        int post[]={7,8,4,5,2,6,3,1};
        int in[]={7,4,8,2,5,1,3,6};
       Node root= treeUsingPostorderAndInoder(post,in,0,post.length-1,post.length-1);
       Range range=new Range();
       int val=maxPathSum(root,range);
    //    val is used when root is special
       int sum=range.sum;
       if(root.left!=null&&root.right!=null){
        System.out.println("sum"+sum);
       }
       else{
        System.out.println("val"+Math.max(sum,val));

       }

       
    }
}

