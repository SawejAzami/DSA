class linkedList{
  public static class Node{
        int data;
        Node next;
         Node(int data){
            this.data=data;
            this.next=null;
        }
    }
   public static Node head;
   public static Node tail;
    public static void addLast(int data){
        Node newnode=new Node(data);
        if(head==null){
           tail= head=newnode;
            return;
        }
        tail.next=newnode;
        tail=newnode;
    }
    public static void addFirst(int data){
        Node newnode=new Node(data);
        if(head==null){
           tail= head=newnode;
            return;
        }
        newnode.next=head;
        head=newnode;
    }
    public static void deleteAtMiddle(int index){
         if(head==null){
            System.out.println("Linkedlist is Empty!");
            return;
        }
        Node curr=head;
        Node prev=null;
        while(index>1){
            index--;
            prev=curr;
            curr=curr.next;
        }
        prev.next=curr.next;
    }
    public static void reverse(){
         if(head==null){
            System.out.println("Linkedlist is Empty!");
            return;
        }
        Node prev=null;
        Node curr=head;
        Node next;
           
        while(curr!=null){
            // System.out.print(curr.data+" ");
            next=curr.next;
            // System.out.print(next.data+" ");
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        head=prev;
    }
    public static void slowFast(){
        Node slow=head;
        Node fast=head;
        while(fast!=null &&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        System.out.println(slow.data);
        
    }
    public static void Print(){
        if(head==null){
            System.out.println("Linkedlist is Empty!");
            return;
        }
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data+"->");
            temp=temp.next;
        }
            System.out.println("null");
    }
    public static void main(String...a){
        addLast(10);
        addLast(20);
        addLast(30);
        addLast(40);
        addLast(50);
        addLast(60);
        addLast(70);
        Print();
        slowFast();
        
    }
}