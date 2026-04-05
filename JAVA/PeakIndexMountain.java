public class PeakIndexMountain {
    public static void main(String[] args){
        int[] arr={2,3,4,6,5,4,2,1};
        int target=2;
        System.out.println(peakElement(arr,target));

    }
    static int peakElement(int[] arr,int target){
        int peak=mountainElement(arr);
        int firstTry=agnosticOrderBS(arr,target,0,peak);
        if(firstTry!=0){
            return firstTry; 
        }
        return agnosticOrderBS(arr,target,peak+1,arr.length-1);

    }
    static int mountainElement(int[] arr){
             int start=0;
             int end=arr.length-1;
             while(start<end){
                  int mid=start+(end-start)/2;
                  if(arr[mid]>arr[mid+1]){
                        end=mid;
                  }else{
                    start=mid+1;
                  }
             }
             return start;
    }

    static int agnosticOrderBS(int[] arr,int target,int start,int end){
                   boolean isAsc;
                   if(arr[start]<arr[end]){
                        isAsc=true;
                   }else{
                    isAsc=false;
                   }
                   while(start<=end){
                    int mid=start+(end-start)/2;
                        if(arr[mid]==target){
                            return mid;
                        }
                        if(isAsc){
                           if(target<arr[mid]){
                               end=mid-1;
                           }else{
                            start=mid+1;
                           }
                        }else{
                            if(target>arr[mid]){
                                end=mid-1;
                            }else{
                                start=mid+1;
                            }
                        }
                    }
                    return-1;
    }
}
