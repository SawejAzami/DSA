import java.util.*;
class Tree{
    public static class Range{
        int t=0;
        Node burnNode=null;
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

// ************* Burnnig tree
 
    public static int burning(Node root,Range time,int target){
    // it ask two question
    // i) if node burn then return time
    // ii) if node not burn then return height
    // i am returning negative value if node burn
    if(root==null){
        return 0;
    }
    if(root.data==target){
        return -1;
    }
    int left=burning(root.left,time,target);
    int right=burning(root.right,time,target);
    if(left<0){
        time.t=Math.max(time.t,Math.abs(left)+right);
        return left-1;
    }
    if(right<0){
        time.t=Math.max(time.t,Math.abs(right)+left);
        return right-1;
    }
    return 1+Math.max(left,right);
    
}
public static void findBurnNode(Node root,int target,Range range){
    if(root==null)return;
    if(root.data==target){
        range.burnNode=root;
        return;
    }
    findBurnNode(root.left,target,range);
    findBurnNode(root.right,target,range);
}
public static int heightOfBurnNodr(Node root){
    if(root==null)return 0;
    return 1+Math.max(heightOfBurnNodr(root.left),heightOfBurnNodr(root.right));
}


    public static void main(String[] arg){
        int pre[]={1,2,4,7,8,5,3,6};
        int post[]={7,8,4,5,2,6,3,1};
        int in[]={7,4,8,2,5,1,3,6};
       Node root= treeUsingPostorderAndInoder(post,in,0,post.length-1,post.length-1);
       Range range=new Range();
        int target=1;
         burning(root,range,target);
         int time=range.t;
         
         
         findBurnNode(root,target,range);
         int h=heightOfBurnNodr(range.burnNode)-1;
         int maxTime= Math.max(h,time);
         System.out.print(maxTime);
       
    }
}

