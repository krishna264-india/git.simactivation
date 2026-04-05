public class QuickSort {
    public static  void main(String[] args){
        int[] num={10,80,60,70,5,8,9};
        quickSort(num,0,num.length-1);
        for(int arr:num){
            System.out.print(arr+" ");

        }

    }
    public static void quickSort(int[] num,int low,int high){
        if(low<=high){
            int pi=partition(num,low,high);
            quickSort(num,low,pi-1);
            quickSort(num,pi+1,high);
        }
    }
    private static int partition(int[] num,int low ,int high){
        int pivot=num[low];
        int s=low;
        int e=high;

        while(s<e){
            while(num[s]<=pivot){
               s++;
            }
            while(num[e]>pivot){
               e--;
            }
            if(s<e){
                int temp=num[s];
                num[s]=num[e];
                num[e]=temp;
            }

        }
        int temp=num[low];
        num[low]=num[e];
        num[e]=temp;
          return e;
    }
}
