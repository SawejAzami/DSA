class Linkedlist{

   public static class Node{
        int data;
        Node next;
        public  Node(int data){
            this.data=data;
            this.next=null;
        }
    }
   public static Node head;
   public static Node tail;
    public static void addFirst(int data){
        Node newNode=new Node(data);
        if(head==null){
            head=tail=newNode;
            return;
        }
        
            newNode.next=head;
            head=newNode;
        
    }
    public static void addLast(int data){
        Node newNode=new Node(data);
        if(head==null){
            head=tail=newNode;
            return;
        }
        
            tail.next=newNode;
            tail=newNode;
        
    }
    public static int  listSize(){
        Node temp=head;
        int count=0;
        while(temp!=null){
            count++;
            temp=temp.next;
        }
       return count;
    }
    public static void addMiddle(int index,int data){
        Node newNode=new Node(data);
        if(index==0){
            addFirst(data);
            return;
        }
        Node temp=head;
        int count=0;
        Node prev=temp;
        while(count<index-1){
            prev=temp;
            temp=temp.next;
            count++;
        }
        prev.next=newNode;
        newNode.next=temp;
    }
     public static void removeAtIndex(int index){
        
        if(head==null){
            System.out.println("linkedlist is empty");
            return;
        }
        Node temp=head;
        int count=0;
        Node prev=null;
        while(count<index-1){
            prev=temp;
            temp=temp.next;
            count++;
        }
        prev.next=temp.next;
    }
    public static void reverse(){
        Node prev=null;
        Node curr=tail=head;
        Node next;
        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        head=prev;
    }
    public static void printList(){
        if(head==null){
            System.out.print("Linkedlist is empty");
            return;
        }
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data+"->");
            temp=temp.next;
        }
            System.out.println("null");
    }

public static void main(String[] args){
    addFirst(10);
    addFirst(20);
    addFirst(30);
    addLast(12);
    addFirst(40);
    printList();
    addMiddle(3,88);
    printList();
    removeAtIndex(4);
    printList();
    reverse();
    printList();
    System.out.println(listSize());

}
}