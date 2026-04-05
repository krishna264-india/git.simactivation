import java.util.*;
public class Permutations {
    public static void main(String[] args){
        int[] nums={1,2,3};
        List<Integer> result=new ArrayList<>();
        permute(nums,0,nums.length-1,result);
        permutation(" ","abc");

    //    ArrayList<String> ans=permutationList(" ","abc");
    //    System.out.println(ans);
    }
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res= new ArrayList<>();
        backtrack(res,new ArrayList<>(),nums);
        return res;
    }
    public static void backtrack(List<List<Integer>> res,List<Integer> tempList,int[] nums){
        if(tempList.size()== nums.length){
            res.add(new ArrayList<>(tempList));
            return;
        }
        for(int num:nums){
            if(tempList.contains(num)) // skip duplicates
            continue;
            tempList.add(num);// add to current permutation 
            backtrack(res,tempList,nums);
            tempList.remove(tempList.size()-1);
    }
}
    static void permutation(String p,String up){
        if(up.isEmpty()){
             System.out.println(p);
             return;
        }
        char ch=up.charAt(0);
        for(int i=0;i<p.length();i++){
            String f=p.substring(0,i);
            String s=p.substring(i,p.length());

            permutation(f+ch+s,up.substring(1));
        }
    }
    static ArrayList<String> permutationList(String p,String up){
        if(up.isEmpty()){
            ArrayList<String> list=new ArrayList<>();
           list.add(p);
            return list;
       }
       char ch=up.charAt(0);

       ArrayList<String> ans=new ArrayList<>();

       for(int i=0;i<p.length();i++){
           String f=p.substring(0,i);
           String s=p.substring(i,p.length());

          ans.addAll(permutationList(f+ch+s,up.substring(1)));
       }

       return ans;
    }
    // most asked permutation questions in interviews
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res= new ArrayList<>();
        Arrays.sort(nums);
        backtrackUnique(res,new ArrayList<>(),nums,new boolean[nums.length]);
        return res;
    }
    public void backtrackUnique(List<List<Integer>> res,List<Integer> tempList,int[] nums,boolean[] used){
        if(tempList.size()== nums.length){
            res.add(new ArrayList<>(tempList));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(used[i] || (i>0 && nums[i]==nums[i-1] && !used[i-1])) // skip duplicates
            continue;
            used[i]=true;
            tempList.add(nums[i]);// add to current permutation 
            backtrackUnique(res,tempList,nums,used);
            used[i]=false;
            tempList.remove(tempList.size()-1);
    }
    public void nextPermutation(int[] nums) {
        for(int i=nums.length-2;i>=0;i--){// find the first decreasing element from the right
            // find the first decreasing element from the right
            if(nums[i]<nums[i+1]){
                for(int j=nums.length-1;j>i;j--){// find the just larger element
                    // find the just larger element
                    if(nums[j]>nums[i]){
                        swap(nums,i,j);
                        break;
                    }
                }
                // reverse the suffix
                reverse(nums,i+1,nums.length-1);
                return;
            }
        }
        // if no such i found, that means we are at the last permutation
        reverse(nums,0,nums.length-1);
    }
    static void swap(int[] nums,int first,int second){
        int temp=nums[first];
         nums[first]=nums[second];
         nums[second]=temp;
    }
    static void reverse(int[] nums,int start,int end){
        while(start<end){
            swap(nums,start,end);
            start++;
            end--;
        }
    }
    public int nextGreaterElement(int n) {
        // Find the next greater element with the same digits
        char[] digits = String.valueOf(n).toCharArray();// Convert number to char array
        int i = digits.length - 2;
        while (i >= 0 && digits[i] >= digits[i + 1]) {
            i--;
        }
        if (i == -1) return -1;
        int j = digits.length - 1;
        while (digits[j] <= digits[i]) {
            j--;
        }
        swap(digits, i, j);
        reverse(digits, i + 1, digits.length - 1);
        long result = Long.parseLong(new String(digits));
        return result > Integer.MAX_VALUE ? -1 : (int) result;
    }
    private void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    private void reverse(char[] arr, int start, int end) {
        while (start < end) {
            swap(arr, start, end);
            start++;
            end--;
        }
    }
     public int getMinSwaps(String num, int k) {
        String target = getKthPermutation(num, k);
        return countMinSwaps(num, target);
    }
    private String getKthPermutation(String num, int k) {
        char[] arr = num.toCharArray();
        for (int i = 0; i < k; i++) {
            nextPermutation(arr);
        }
        return new String(arr);
    }
    private void nextPermutation(char[] arr) {
        int i = arr.length - 2;
        while (i >= 0 && arr[i] >= arr[i + 1]) {
            i--;
        }
        if (i >= 0) {
            int j = arr.length - 1;
            while (arr[j] <= arr[i]) {
                j--;
            }
            swap(arr, i, j);
        }
        reverse(arr, i + 1, arr.length - 1);
    }
    private int countMinSwaps(String source, String target) {
        char[] srcArr = source.toCharArray();
        char[] tgtArr = target.toCharArray();
        int swaps = 0;
        for (int i = 0; i < srcArr.length; i++) {
            if (srcArr[i] != tgtArr[i]) {
                int j = i + 1;
                while (j < srcArr.length && srcArr[j] != tgtArr[i]) {
                    j++;
                }
                while (j > i) {
                    swap(srcArr, j, j - 1);
                    swaps++;
                    j--;
                }
            }
        }
        return swaps;
    }

}

