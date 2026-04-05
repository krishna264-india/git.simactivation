public class Shuffle {
    public static void main(String[] args) {
        int[] nums={2,5,1,3,4,7};
        int n=3;
        System.out.println(shuffle(nums,n));
    }
    static int[] shuffle(int[] nums,int n){
       int[] ans=new int[2*n];
         for(int i=0;i<n;i++){
          if(i%2==0){
             ans[i]=nums[i/2];// for even index, take the element from the first half of the array
          }
           else{ 
           ans[i]=nums[n+(i-1)/2];// for odd index, take the element from the second half of the array
           }
         }
         return ans;
    }
}
