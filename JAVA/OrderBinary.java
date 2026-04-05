public class OrderBinary {
    public static void main(String[] args) {
        int[] arr={99,88,77,66,22,11,10,6,3,2};
        int target=3;
        int ans=orderAgnosticBinary(arr,target);  
        System.out.println(ans);
    }
    static int orderAgnosticBinary(int[] arr,int target){
        int start=0;
        int end=arr.length-1;

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
                }
                 else{
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
