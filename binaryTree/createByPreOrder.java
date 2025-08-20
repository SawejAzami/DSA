
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
     public static class Range{
        int l=0;
        int r=0;
        int p=0;
// In Java, int is a primitive type and is passed by value, not by reference.
    }

    public static Node createByPreOrder(){
        System.out.println("Enter value");
        Scanner sc=new Scanner(System.in);
        int val=sc.nextInt();
        if(val==-1){
            return null;
        }
        Node newNode=new Node(val);
        newNode.left=createByPreOrder();
        newNode.right=createByPreOrder();
        return newNode;

    }
    public static void printByPreorder(Node temp){
        if(temp==null){
            return;
        }
        System.out.print(" "+temp.data);
        printByPreorder(temp.left);
        printByPreorder(temp.right);
    }
    public static void printByLevelOrder(Node root){
      Queue<Node> q=new LinkedList<>();
      q.add(root);
      while(!q.isEmpty()){
        Node temp=q.remove();
            System.out.println(temp.data+" ");
        if(temp.left!=null){
            q.add(temp.left);
        }
        if(temp.right!=null){
            q.add(temp.right);
        }
      }
    }
     public static int sumOfBinaryTree(Node root){
        if(root==null){
            return 0;
        }
        return root.data+sumOfBinaryTree(root.left)+sumOfBinaryTree(root.right);
    }
    public static int sizeOfBinaryTree(Node root){
        if(root==null){
            return 0;
        }
        return 1+sizeOfBinaryTree(root.left)+sizeOfBinaryTree(root.right);
    }
    public static int numberLeafOfBinaryTree(Node root){
        if(root==null){
            return 0;
        }
        if(root.left==null&& root.right==null){
            return 1;
        }
        return numberLeafOfBinaryTree(root.left)+numberLeafOfBinaryTree(root.right);
    }
    public static int numberNonLeafOfBinaryTree(Node root){
        if(root==null){
            return 0;
        }
        if(root.left==null&& root.right==null){
            return 0;
        }
        return 1+numberLeafOfBinaryTree(root.left)+numberLeafOfBinaryTree(root.right);
    }
    public static boolean isIdentical(Node r1,Node r2){
        if(r1==null && r2==null) return true;
        if((r1==null && r2!=null)||(r1!=null && r2==null)){
            return false;
        }
        if(r1.data!=r2.data){
            return false;
        }
        return isIdentical(r1.left,r2.left) && isIdentical(r1.right,r2.right);
    }
    public static void mirrorTree(Node root){
        if(root==null){
            return ;
        }
        Node temp=root.left;
        root.left=root.right;
        root.right=temp;
        mirrorTree(root.left);
        mirrorTree(root.right);

    }
     public static int checkHeight(Node root,int valid[]){
        if(root==null) return 0;

        int l=checkHeight(root.left,valid);
        int r=checkHeight(root.right,valid);
        if((l-r)>1 ||(l-r)<-1){
            valid[0]=0;
        }
        return 1+Math.max(l,r);
    }
    public static int checkBalance(Node root){
        int valid[]={1};
        checkHeight(root,valid);
        return valid[0];
    }
   
    public static void levelOrderTravelsalBySipral(Node root){
        Stack<Node> s1=new Stack<>();//R-L
        Stack<Node> s2=new Stack<>();//L-R
        s1.push(root);
        while(!s1.isEmpty() || !s2.isEmpty()){
            while(!s1.isEmpty()){
                Node temp=s1.pop();
                if(temp!=null){
                    System.out.println(temp.data+" ");
                }
                if(temp.right!=null){
                    s2.add(temp.right);
                }
                if(temp.left!=null){
                    s2.add(temp.left);
                }
            }
            while(!s2.isEmpty()){
                Node temp=s2.pop();
                if(temp!=null){
                    System.out.println(temp.data+" ");
                }
                if(temp.left!=null){
                    s1.add(temp.left);
                }
                if(temp.right!=null){
                    s1.add(temp.right);
                }
            }
        }

    }
    public static boolean sameParent(Node root,int a,int b){
        if(root==null){
            return false;
        }
        if(root.left!=null && root.right!=null){
            if(root.left.data==a && root.right.data==b)return true;
            if(root.right.data==a && root.left.data==b)return true;
        }
        return sameParent(root.left,a,b)||sameParent(root.right,a,b);
    }
    public static boolean isCousin(Node root,int a,int b){
        Queue<Node> q=new LinkedList<>();
        q.add(root);
        int l1=-1,l2=-1;
        int level=0;
        while(!q.isEmpty()){
            int n=q.size();
            while(n>0){
                n--;
                Node temp=q.remove();
                if(temp.data==a){
                    l1=level;
                }
                if(temp.data==b){
                    l2=level;
                }
                if(temp.left!=null){
                    q.add(temp.left);
                }
                if(temp.right!=null){
                    q.add(temp.right);
                }
            }
            level++;
            if(l1!=l2){
                return false;
            }
            if(l1!=-1) break;
        }
        return !sameParent(root,a,b);
    }
    // left view 
    public static void leftView(Node root){
        if(root==null)return;
        System.out.print(root.data+" ");
        if(root.left!=null){
            leftView(root.left);
        }else{
            leftView(root.right);
        }
    }
    public static void leftViewOfTree(Node root){
        Queue<Node> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int n=q.size();
            System.out.println(q.peek().data+" ");
            while(n>0){
                n--;
                Node temp=q.remove();
                if(temp.left!=null)q.add(temp.left);
                if(temp.right!=null)q.add(temp.right);
            }
        }
    }
    public static void leftViewOfTreeByRecursion(ArrayList<Integer> ans,int level,Node root){
        // level will  be zero in function during calling
        if(root==null)return;
        if(level==ans.size()){
            ans.add(root.data);
        }
        leftViewOfTreeByRecursion(ans,level+1,root.left);
        leftViewOfTreeByRecursion(ans,level+1,root.right);
    }
    // right view
     public static void rightViewOfTree(Node root){
        Queue<Node> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int n=q.size();
            System.out.println(q.peek().data+" ");
            while(n>0){
                n--;
                Node temp=q.remove();
                if(temp.right!=null)q.add(temp.right);
                if(temp.left!=null)q.add(temp.left);
            }
        }
    }

    // top view
    public static void find(Node root,int pos,Range range){
        if(root==null){
            return ;
        }
        range.l=Math.min(range.l,pos);
        range.r=Math.max(range.r,pos);
        find(root.left,pos-1,range);
        find(root.right,pos+1,range);
        
    }
    public static int[] topView(Node root){
        Range range=new Range();
        find(root,0,range);
        int l=range.l,r=range.r;
        int[] ans=new int[r-l+1];
        int[] check=new int[r-l+1];
        Queue<Node> q=new LinkedList<>();
        Queue<Integer> index=new LinkedList<>();
        q.add(root);
        index.add(-1*l);
        while(!q.isEmpty()){
            Node temp=q.remove();
            int pos=index.remove();
            if(check[pos]==0){
                ans[pos]=temp.data;
                check[pos]=1;
            }
            if(temp.left!=null){
                q.add(temp.left);
                index.add(pos-1);
            }
            if(temp.right!=null){
                q.add(temp.right);
                index.add(pos+1);
            }
        }
        return ans;

    }
// method 2 top view 
    public static void Tview(Node root,int pos,int[] ans,int[] level,int l){
        if(root==null){
            return;
        }
        if(level[pos]>l){
            ans[pos]=root.data;
            level[pos]=l;
        }
        Tview(root.left,pos-1,ans,level,l+1);
        Tview(root.right,pos+1,ans,level,l+1);
    }

    public static int[] topView2(Node root){
        Range range=new Range();
        find(root,0,range);
        int l=range.l,r=range.r;
        int ans[]=new int[r-l+1];
        int level[]=new int[r-l+1];
        Arrays.fill(level,Integer.MAX_VALUE);
        Tview(root,-1*l,ans,level,0);
        return ans;
    }

    // bottom view
    public static void Bview(Node root,int pos,int[] ans,int[] level,int l){
        if(root==null){
            return;
        }
        if(level[pos]<l){
            ans[pos]=root.data;
            level[pos]=l;
        }
        Bview(root.left,pos-1,ans,level,l+1);
        Bview(root.right,pos+1,ans,level,l+1);
    }
    public static int[] bottomView(Node root){
        Range range=new Range();
        find(root,0,range);
        int l=range.l,r=range.r;
        int ans[]=new int[r-l+1];
        int level[]=new int[r-l+1];
        Arrays.fill(level,Integer.MIN_VALUE);
        Bview(root,-1*l,ans,level,0);
        return ans;
    }

    // traversal without recursion
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
     public static void postOrderTraversal(Node root,Stack<Integer> ans){
        Stack<Node> s=new Stack<>();
        s.push(root);
        // postorder follow L-R-N if i reverse the postorder then it will be 
        // N-R-L so print N then go R then go l
        //  put L first then R so that we can read R first
        // after getting ans reverse it
        while(!s.isEmpty()){
            Node temp=s.pop();
            // System.out.print(temp.data+" ");
            ans.push(temp.data);
            if(temp.left!=null){
                s.push(temp.left);
            }
            if(temp.right!=null){
                s.push(temp.right);
            }
        }
    }

    public static void inOrderTraversal(Node root,ArrayList<Integer> ans){
        Stack<Node> s=new Stack<>();
        Stack<Integer> visit=new Stack<>();
        s.push(root);
        visit.push(0);
        while(!s.isEmpty()){
            Node temp=s.pop();
            int v=visit.pop();
            if(v==0){
                // right 
                if(temp.right!=null){
                    s.push(temp.right);
                    visit.push(0);
                }
                // root
                s.push(temp);
                visit.push(1);
                // left
                if(temp.left!=null){
                    s.push(temp.left);
                    visit.push(0);
                }
            }
            else{
                ans.add(temp.data);
            }
        }
    }

// creating tree using preOrder and inorder
public static int findPosition(int in[],int target,int start,int end){
    for(int i=start;i<=end;i++){
        if(in[i]==target)return i;
    }
    return -1;
}
public static Node treeUsingPreorderAndInoder(int pre[],int in[],int start,int end,int index){
    // end should be pre.length-1 index=0
    if(start>end){
        return null;
    }
    Node newNode=new Node(pre[index]);
    int pos=findPosition(in,pre[index],start,end);
   newNode.left= treeUsingPreorderAndInoder(pre,in,start,pos-1,index+1);
   newNode.right= treeUsingPreorderAndInoder(pre,in,pos+1,end,index+(pos-start)+1);
    return newNode;
}
// creating tree using postOrder and inorder
public static Node treeUsingPostorderAndInoder(int post[],int in[],int start,int end,int index){
    // end=post.length-1 and index=post.length-1
    if(start>end){
        return null;
    }
    Node newNode=new Node(post[index]);
    int pos=findPosition(in,post[index],start,end);
   newNode.right= treeUsingPostorderAndInoder(post,in,pos+1,end,index-1);
   newNode.left= treeUsingPostorderAndInoder(post,in,start,pos-1,index-(end-pos)-1);
    return newNode;
}

// traversal by vertical
public static ArrayList<Integer> verticalTraversal(Node root){
    Range range=new Range();
    // Range is class which contain values like l and r;
    find(root,0,range);
    int l=range.l;
    int r=range.r;
        ArrayList<ArrayList<Integer>> positiveVal = new ArrayList<>();
        ArrayList<ArrayList<Integer>> negativeVal = new ArrayList<>();

        // Initialize outer lists to required size
        for (int i = 0; i <= r; i++) {
            positiveVal.add(new ArrayList<>());
        }
        for (int i = 0; i <= Math.abs(l); i++) {
            negativeVal.add(new ArrayList<>());
        }
    Queue<Node> q=new LinkedList<>();
    Queue<Integer> index=new LinkedList<>();
    q.add(root);
    index.add(0);
    while(!q.isEmpty()){
        Node temp=q.remove();
        int pos=index.remove();
        if (pos >= 0) {
            positiveVal.get(pos).add(temp.data);
        } else {
            negativeVal.get(Math.abs(pos)).add(temp.data);
        }
        if(temp.left!=null){
            q.add(temp.left);
            index.add(pos-1);
        }
        if(temp.right!=null){
            q.add(temp.right);
            index.add(pos+1);
        }
    }
    ArrayList<Integer> ans=new ArrayList<>();
    for(int i=negativeVal.size()-1;i>0;i--){
        for(int j=0;j<negativeVal.get(i).size();j++){
            ans.add(negativeVal.get(i).get(j));
        }
    }
    for(int i=0;i<positiveVal.size();i++){
        for(int j=0;j<positiveVal.get(i).size();j++){
            ans.add(positiveVal.get(i).get(j));
        }
    }
    return ans;

}

// diagonal traversal 
public static void findDiagonal(Node root,ArrayList<ArrayList<Integer>> ans,int l,int r){
        if(root==null){
            return ;
        }
        ans.get(l).add(root.data);
        findDiagonal(root.left,ans,l+1,r);
        findDiagonal(root.right,ans,l,r+1);
    }
    public static ArrayList<Integer> diagonal(Node root){
        Range range=new Range();
        find(root,0,range);
        int l=Math.abs(range.l)+1;
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        for(int i=0;i<l;i++){
            ans.add(new ArrayList<>());
        }
        findDiagonal(root,ans,0,0);
        ArrayList<Integer> arr=new ArrayList<>();
        for(int i=ans.size()-1;i>=0;i--){
            for(int j=0;j<ans.get(i).size();j++){
                arr.add(ans.get(i).get(j));
            }
        }
        return arr;
    }

    // boundary traversal
     public static void addLeftNode(Node root,ArrayList<Integer> ans){
        if(root==null || (root.left==null&& root.right==null)){
            return;
        }
        ans.add(root.data);
        if(root.left!=null){
            addLeftNode(root.left,ans);
        }
        else{
            addLeftNode(root.right,ans);
        }
    }
    public static void addRightNode(Node root,ArrayList<Integer> ans){
        if(root==null || (root.left==null&& root.right==null)){
            return;
        }
        if(root.right!=null){
            addRightNode(root.right,ans);
        }
        else{
            addRightNode(root.left,ans);
        }
        ans.add(root.data);
    }

    public static void addleafNode(Node root,ArrayList<Integer> ans){
        if(root==null) return;
        if(root.left==null&& root.right==null){
            ans.add(root.data);
            return;
        }
        addleafNode(root.left,ans);
        addleafNode(root.right,ans);
    }

    public static ArrayList<Integer> boundaryView(Node root){
        ArrayList<Integer> ans=new ArrayList<>();
        // Add root node to ans
        ans.add(root.data);
        // add all left subtree to ans except leaf Node
        addLeftNode(root.left,ans);
        // add all laef node
        addleafNode(root,ans);
        // add all right subtree to ans except leaf node
        addRightNode(root.right,ans);
        return ans;
    }



    public static void main(String[] arg){
        // Node root =createByPreOrder();
        // printByPreorder(root);
        // printByLevelOrder(root);
        int pre[]={1,2,4,7,8,5,3,6};
        int in[]={7,4,8,2,5,1,3,6};
    //    Node root= treeUsingPreorderAndInoder(pre,in,0,pre.length-1,0);
    //    ArrayList<Integer> ans=verticalTraversal(root);
    //    for(int i=0;i<ans.size();i++){
    //         System.out.print(ans.get(i)+" ");
    //    }
    }
}