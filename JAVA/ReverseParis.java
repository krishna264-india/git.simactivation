import java.util.ArrayList;
import java.util.List;

public class ReverseParis {
    public static void main(String[] args){
        int[] nums={1,3,2,3,1};
        int ans=reversePairs(nums);
        System.out.println(ans);

    }
    public static int reversePairs(int[] nums) {
        if(nums==null || nums.length<2){
            return 0;
        }
       return mergeAndCount(nums,0,nums.length-1);
    }
    public static int mergeAndCount(int[] nums,int start,int end){
        if(start>=end){
            return 0;
        }
        int mid=(start+end)/2;
         // Count reverse pairs in the left half, right half, and across the halves
        int count=mergeAndCount(nums,start,mid)+ mergeAndCount(nums,mid+1,end);
         // Count reverse pairs that span the two halves
         count+=reversParis(nums, start,mid,end);
         // Merge the two halves
         merge(nums,start,mid,end);

         return count;
    }
    private static int reversParis(int[] nums,int start,int mid,int end){
        int count=0;
        int j=mid+1;// index of the right half
        for(int i=start;i<=mid;i++){
            // if the left half is larger than the right half
            while(j<=end && nums[i]>2L*nums[j]){
                j++;
            }
            count+=j-(mid+1);
        }
        return count;

    }
    private static void merge(int[] nums,int start, int mid, int end){
        int[] temp=new int[end-start+1];
        int i=start,j=mid+1,k=0;
        // Merge the two halves
        while(i<=mid && j<=end){
            if(nums[i]<=nums[j]){
                temp[k++]=nums[i++];
            }else{
                temp[k++]=nums[j++];
            }
        }
        while(i<=mid){
            temp[k++]=nums[i++];
        }
        while(j<=end){
            temp[k++]=nums[j++];
        }
         // Copy the sorted array back to original
         System.arraycopy(temp,0,nums,start,k);
    }

     public List<Integer> majorityElement(int[] nums) {
        List<Integer> result=new ArrayList<>();
        if(nums==null || nums.length==0){
            return result;
        }
        int count1=0, count2=0, candidate1=0,candidate2=0;
        for(int num:nums){
            if(num==candidate1){
                count1++;
            }
            else if(num==candidate2){
                count2++;
            }
            else if(count1==0){
                candidate1=num;
                count1=1;
            }
            else if(count2==0){
                candidate2=num;
                count2=1;
            }
            else{
                count1--;
                count2--;
            }
            if(count1<0) count1=0;
            if(count2<0) count2=0;
        } 
        // Second pass: Verify the counts of candidate1 and candidate2
        count1=0;
        count2=0;
        for(int num:nums){
            if(num==candidate1) count1++;
            else if(num==candidate2) count2++;
        } 
        // If the counts are more than n / 3, add to result
        if(count1>nums.length/3) result.add(candidate1);
        if(count2>nums.length/3) result.add(candidate2);

        return result;
    }
    
}
