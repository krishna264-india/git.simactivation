public class InfiniteNumber {
    public static void main(String[] args){
      int[] arr={2,3,4,56,10,2,3,4,20,23,25,27,48,50,60};
      int target=27;
      System.out.println(ans(arr,target));
    }
    static int ans(int[] arr,int target){
         int start=0;
         int end=1;
         while(target>arr[end]){
            int newStart=end+1;
            end=end+(end-start+1)*2;
              start=newStart;
         }
         return binarySearch(arr,target,start,end);
    }
    static int binarySearch(int[] arr,int target,int start,int end){
           while(start<=end){
            int mid=start+(end-start)/2;
                if(target<arr[mid]){
                     end=mid-1;
                }
                else if(target>arr[mid]){
                         start=mid+1;
                }else{
                    return mid;
                }
           }
           return -1;
    }
}
