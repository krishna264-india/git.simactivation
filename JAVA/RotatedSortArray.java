public class RotatedSortArray {
    public static void main(String[] args){
        int[] nums={4,5,6,7,2,1,0};
        System.out.println(search(nums));

    }
}
static int search(int[] nums){
    int start=0;
    int end=nums.length-1;
    while(start<=end){
       int mid=start+(end-start)/2;
       if(mid < end && nums[mid]>nums[mid+1]){
        return mid;

       }
       if(mid > end && nums[mid]<nums[mid-1]){
            return mid-1;
       }
       if(nums[mid]==nums[start] && nums[mid]==nums[end]){
        if(nums[start]>nums[start+1]){
            return start;

        }
        start++;
        if(nums[end]<nums[end-1]){
           return end-1;
        }
      
        end--;
        if(nums[stat]<arr[mid]|| nums[start]==nums[mid] && nums[mid]>nums[end]){
               start=mid+1;
        }else{
            end=mid-1;
        }

       }
       return -1;
    }

}
