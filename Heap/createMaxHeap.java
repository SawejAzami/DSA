
 class MaxHeap{
        int size;
        int totalsize;
        int arr[];
        MaxHeap(int n){
            size=0;
            totalsize=n;
            arr=new int[n];
        }
         void insert(int data){
        if(size==totalsize){
            System.out.println("heap overflow");
            return;
        }
        int index=size;
        arr[size]=data;
        size++;
        // place data at right place
        while(index>=0&&arr[index]>arr[(index-1)/2]){
            int temp=arr[index];
            arr[index]=arr[(index-1)/2];
            arr[(index-1)/2]=temp;
            index=(index-1)/2;
        }
    }
         void printHeap(){
        if(size==0){
            System.out.println("heap is underflow");
            return;
        }
        for(int i=0;i<size;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    void heapify(int i){
        int l=i*2+1;
        int r=i*2+2;
        int largest=i;
        if(l<size&&arr[i]<arr[l]){
            largest=l;
        }
        if(r<size&&arr[largest]<arr[r]){
            largest=r;
        }
        if(i!=largest){
            int temp=arr[i];
            arr[i]=arr[largest];
            arr[largest]=temp;
            heapify(largest);
        }
    }
    void deleteHeap(){
        if(size==0){
            System.out.println("heap is underflow");
            return;
        }
        arr[0]=arr[size-1];
        size--;
        heapify(0);
    }
    public static void main(String[] arg){
        MaxHeap H=new MaxHeap(8);
        H.insert(15);
        H.insert(16);
        H.insert(10);
        H.insert(5);
        H.insert(45);
        H.insert(30);
        H.insert(20);
        H.insert(40);
        H.printHeap();
        H.deleteHeap();
        H.printHeap();
    }
    }
