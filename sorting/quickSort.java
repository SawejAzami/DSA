import java.util.*;
class Sorting{

    public static void quickSort(int arr[],int si,int ed){
        if(si>=ed){
            return;
        }
        int index=partision(arr,si,ed);
        quickSort(arr,si,index-1);
        quickSort(arr,index+1,ed);
    }
    public static int partision(int arr[],int si,int ed){
        int pivot=arr[ed];
        int i=si;
        for(int j=si;j<ed;j++){
            if(arr[j]<=pivot){
                int temp=arr[j];
                arr[j]=arr[i];
                arr[i]=temp;
                i++;
            }
        }
        int temp=arr[i];
        arr[i]=arr[ed];
        arr[ed]=temp;
        return i;
    }

    public static void main(String[] args){
        int arr[]={2,4,5,1,3,6,8};
        int n=arr.length-1;
        quickSort(arr,0,n);
        for(int i=0;i<=n;i++){
            System.out.print(arr[i]+" ");
        }
    }
}