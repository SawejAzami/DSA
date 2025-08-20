import java.util.*;
class Tree{
    
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

//************* */ inorder morris 
public static ArrayList<Integer> morrisInOrder(Node root){

// morris method take time O(n) time complexity and O(1) space complexity


    ArrayList<Integer> ans=new ArrayList<>();
   
   while(root!=null){
    // if left part does not exist
    if(root.left==null){
         ans.add(root.data);
         root=root.right;
    }
    // if left part  exist
    else{
        Node curr=root.left;
        while(curr.right!=null && curr.right!=root){
            curr=curr.right;
        }
        // if left part does not traversed
        if(curr.right==null){
            curr.right=root;
            root=root.left;
        }
          // if left part already traversed
          else{
            curr.right=null;
            // add data
            ans.add(root.data);
            root=root.right;
          }
    }
   }
   return ans;
    
}

//*************** */ preorder morris
public static ArrayList<Integer> morrisPreOrder(Node root){

// morris method take time O(n) time complexity and O(1) space complexity


    ArrayList<Integer> ans=new ArrayList<>();
   
   while(root!=null){
    // if left part does not exist
    if(root.left==null){
         ans.add(root.data);
         root=root.right;
    }
    // if left part  exist
    else{
        Node curr=root.left;
        while(curr.right!=null && curr.right!=root){
            curr=curr.right;
        }
        // if left part does not traversed
        if(curr.right==null){
            // add data
            ans.add(root.data);
            curr.right=root;
            root=root.left;
        }
          // if left part already traversed
          else{
            curr.right=null;
            root=root.right;
          }
    }
   }
   return ans;
    
}

//*************** */ postOrder morris

public static Stack<Integer> morrisPostOrder(Node root){

// morris method take time O(n) time complexity and O(1) space complexity
// it is same as pre order 
// N R L
// then reverse it

    Stack<Integer> ans=new Stack<>();
    
   
   while(root!=null){
    // if left part does not exist
    if(root.right==null){
         ans.push(root.data);
         root=root.left;
    }
    // if right part  exist
    else{
        Node curr=root.right;
        while(curr.left!=null && curr.left!=root){
            curr=curr.left;
        }
        // if left part does not traversed
        if(curr.left==null){
            // add data
            ans.push(root.data);
            curr.left=root;
            root=root.right;
        }
          // if left part already traversed
          else{
            curr.left=null;
            root=root.left;
          }
    }
   }
   return ans;
    
}
// convert tree into linkedlist (flatten binary to linkedlist)
public static void flattenBinary(Node root){
    while(root!=null){
        // if left does not exist
        if(root.left==null){
            root=root.right;
        }
        // if left exist
        else{
            // go to right most node and link that node to root.right
            Node curr=root.left;
            while(curr.right!=null){
                curr=curr.right;
            }
            curr.right=root.right;
            root.right=root.left;
            root.left=null;
            root=root.right;
        }
    }
}

    public static void main(String[] arg){



        int pre[]={1,2,4,7,8,5,3,6};
        int post[]={7,8,4,5,2,6,3,1};
        int in[]={7,4,8,2,5,1,3,6};
       Node root= treeUsingPostorderAndInoder(post,in,0,post.length-1,post.length-1);
    //     ArrayList<Integer> ans=morrisInOrder(root);
    //    for(int i=0;i<ans.size();i++){
    //     System.out.print(ans.get(i)+" ");
    //    }

    // Stack<Integer> s=morrisPostOrder(root);
    // while(!s.isEmpty()){
    //     System.out.print(s.pop()+" ");
    // }
    flattenBinary(root);
    while(root!=null){
        System.out.print(root.data+" ");
        root=root.right;
    }
   
    }
}