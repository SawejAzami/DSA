import java.util.*;

class Tree{
    static class Node{
        int data;
        Node left;
        Node right;
         Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }
   static class BinaryTree{
    static int index=-1;
    public static Node buildTree(int nodes[]){
         index++;
        if(nodes[index]==-1){
            return null;
        }
        Node newNode=new Node(nodes[index]);
        newNode.left=buildTree(nodes);
        newNode.right=buildTree(nodes);

        return newNode;
    }
    
   }
    public static void preOrderTrvel(Node root){
        if(root==null){
            System.out.print("-1 ");
            return ;
        }
        System.out.print(root.data+" ");
        preOrderTrvel(root.left);
        preOrderTrvel(root.right);
    }
    public static void inOrderTrvel(Node root){
        if(root==null){
            System.out.print("-1 ");
            return;
        }
        inOrderTrvel(root.left);
        System.out.print(root.data+" ");
        inOrderTrvel(root.right);
    }
    public static void postOrderTrvel(Node root){
        if(root==null){
            System.out.print("-1 ");
            return;
        }
        postOrderTrvel(root.left);
        postOrderTrvel(root.right);
        System.out.print(root.data+" ");
    }
    public static void levelOrderTravelsal(Node root){
        if(root==null){
            return;
        }
        Queue<Node> q=new LinkedList<>();
        q.add(root);
        q.add(null);
        while(!q.isEmpty()){
            Node newNode=q.remove();
            if(newNode==null){
                System.out.println();
                if(q.isEmpty()){
                    break;
                }
                else{
                    q.add(null);
                }
            }
            else{
                System.out.print(newNode.data+" ");
                if(newNode.left!=null){
                     q.add(newNode.left);
                }
                if(newNode.right!=null){
                     q.add(newNode.right);
                }
            }
        }
    }
    public static int countNode(Node root){
        if(root==null){
            return 0;
        }
        return countNode(root.left)+countNode(root.right)+1;
    }
    public static int sumOfNode(Node root){
        if(root==null){
            return 0;
        }
        return sumOfNode(root.left)+sumOfNode(root.right)+root.data;
    }
    public static int heightOfTree(Node root){
        if(root==null){
            return 0;
        }
        int left=heightOfTree(root.left);
        int right=heightOfTree(root.right);
        return left>right?left:right+1;
    }
    public static int diameterOfTree(Node root){
        // its time complexcity is O(n^2)
        if(root==null){
            return 0;
        }
        int diam1=diameterOfTree(root.left);
        int diam2=diameterOfTree(root.right);
        int diam3=heightOfTree(root.left)+heightOfTree(root.right)+1;
        int max= Math.max(diam1,Math.max(diam2,diam3));

        return max;
        
    }
    public static int dia(Node root,int res[]){
        if(root==null)return 0;
        int l=dia(root.left,res);
        int r=dia(root.right,res);
        res[0]=Math.max(res[0],l+r);
        // res[0] is use to store diameter of tree 
        //  in above part it will give time limit exceed
        return 1+ Math.max(l,r);
    }
    public static class treeInfo{
        int ht;
        int dim;
        treeInfo(int ht,int dim){
            this.ht=ht;
            this.dim=dim;
        }
    }
    public static treeInfo diameter2(Node root){
        if(root==null){
           return new treeInfo(0,0);
        }
        treeInfo left=diameter2(root.left);
        treeInfo right=diameter2(root.right);

        int height=Math.max(left.ht,right.ht)+1;

        int diam1=left.dim;
        int diam2=right.dim;
        int diam3=left.ht+right.ht+1;

        int mydiam=Math.max(diam1,Math.max(diam2,diam3));

        treeInfo myinfo=new treeInfo(height,mydiam);
        return myinfo;


    }
    public static boolean isIdentical(Node root,Node subRoot){
        if(root==null && subRoot==null){
            return true;
        }
        if(root==null || subRoot==null){
            return false;
        }
        if(root.data==subRoot.data){
            return isIdentical(root.left,subRoot.left)&&isIdentical(root.right,subRoot.right);
        }
        return false;
    }
    public static boolean isSubtree(Node root,Node subRoot){
        if(subRoot==null){
            return true;
        }
        if(root==null){
            return false;
        }
        if(root.data==subRoot.data){
            if(isIdentical(root,subRoot)){
                return false;
            }
        }
        return isSubtree(root.left,subRoot)||isSubtree(root.right,subRoot);
    }
    public static void main(String[] args){
        int nodes[]={1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        int nodes2[]={3,-1,6,-1,-1};
        BinaryTree tree=new BinaryTree();

       Node root= tree.buildTree(nodes);
    //    Node root= buildTree(nodes,0);
    //    Node root2= buildTree(nodes2,0);
        System.out.println(root.data);
        preOrderTrvel(root);
        System.out.println();
        postOrderTrvel(root);
        System.out.println();
        inOrderTrvel(root);
        System.out.println();
        levelOrderTravelsal(root);
        int count=countNode(root);
        int sum=sumOfNode(root);
        int height=heightOfTree(root);
        int diameter=diameterOfTree(root);
        System.out.println("Number of nodes: "+count);
        System.out.println("Sum of nodes: "+sum);
        System.out.println("height of tree: "+height);
        System.out.println("diameter of tree: "+diameter);
        System.out.println("diameter2 of tree: "+diameter2(root).dim);
        // System.out.println(isSubtree(root,root2));
    }
}