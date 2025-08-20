import java.util.*;
class Tree{
    // public static class Range{
    //     int prev=Integer.MIN_VALUE;
    // }
    public static class Node{
        int data;
        Node left,right;
        Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }
     public static class Range{
        int prev=Integer.MIN_VALUE;
        int ans=Integer.MAX_VALUE;
    }
    // **************************
     public static void kSmallest(TreeNode root,ArrayList<Integer> ans){
        if(root==null)return;
        kSmallest(root.left,ans);
        ans.add(root.val);
        kSmallest(root.right,ans);
    }
    public int kthSmallest(TreeNode root, int k) {
        ArrayList<Integer> ans=new ArrayList<>();
        kSmallest(root,ans);
        return ans.get(k-1);
    }

    // ****************************************
    public static void findMinDiffInBST(Node root,Range range){
        if(root==null)return;
        find(root.left,range);
        if(range.prev!=Integer.MIN_VALUE){
            range.ans=Math.min(range.ans,root.data-range.prev);
        }
        range.prev=root.data;
        find(root.right,range);
    }
    public int minDiffInBST(Node root) {
        Range range=new Range();
        findMinDiffInBST(root,range);
        return range.ans;
    }
    // ******************
     public static boolean checkBST(Node root,Range range){
    if(root==null){
        return true;
    }
    boolean l=checkBST(root.left,range);
    if(!l){
        return false;
    }
    if(root.data<=range.prev){
        return false;
    }
    range.prev=root.data;
    return checkBST(root.right,range);
    
   
   }


    // **************************
    public static Node createTree(Node root,int data){
        if(root==null){
            Node newNode=new Node(data);
            return newNode;
        }
        if(root.data>data)
            root.left=createTree(root.left,data);
        if(root.data<data)
            root.right=createTree(root.right,data);
        return root;
    }
    public static boolean searchData(Node root,int data){
        if(root==null)return false;
        if(root.data==data)return true;
        if(root.data>data)
            return searchData(root.left,data);
        else
            return searchData(root.right,data);
        
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
    public static int swapDataOfRoot(Node root,int data){
        while(root.right!=null){
            root=root.right;
        }
        int newData=root.data;
        root.data=data;
        return newData;
    }
   
   public static Node deleteData(Node root,int data){
    if(root==null){
        return null;
    }
     if(root.data>data)
        {
            root.left=deleteData(root.left,data);
            
        }
    else if(root.data<data)
        {
            root.right=deleteData(root.right,data);
            
        }
    else{
        // leaf node
        if(root.left==null&& root.right==null){
            return null;
        }
        //1 child (right child)
        else if(root.left==null){
            return root.right;
        }
        //1 child (left child)
       else if(root.right==null){
            return root.left;
        }
        //both child
        else{
            Node temp=root.left;
            int newData=swapDataOfRoot(temp,data);
            root.data=newData;
            root.left=deleteData(root.left,data);
        }
        

    }
   return root;
    
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
   

    public static void main(String[] arg){
        int pre[]={1,2,4,7,8,5,3,6};
        int post[]={1,3,2,6,5,4,8,7};
        int in[]={1,2,3,4,5,6,7,8};
       Node root= treeUsingPostorderAndInoder(post,in,0,post.length-1,post.length-1);
      
    // Node root=null;
    // for(int i=0;i<post.length;i++){
    //     root=createTree(root,post[i]);
    // }
    //    preOrderTraversal(root);
    //    deleteData(root,6);
    Range range=new Range();
       System.out.println(checkBST(root,range));
    //    preOrderTraversal(root);
    // System.out.print(searchData(root,52));
    }
}