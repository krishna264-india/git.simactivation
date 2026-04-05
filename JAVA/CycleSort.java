/*
 * Given an array nums containing n distinct numbers in the range [0, n],]
 *  return the only number in the range that is missing from the array.
Example 1:

Input: nums = [3,0,1]
Output: 2
Explanation: n = 3 since there are 3 numbers, so all numbers are in the range [0,3]. 
2 is the missing number in the range since it does not appear in nums.
Example 2:

Input: nums = [0,1]
Output: 2
Explanation: n = 2 since there are 2 numbers, 
so all numbers are in the range [0,2]. 2 is the missing number in the range since it does not appear in nums.
Example 3:
Input: nums = [9,6,4,2,3,5,7,0,1]
Output: 8
Explanation: n = 9 since there are 9 numbers, 
so all numbers are in the range [0,9]. 8 is the missing number in the range since it does not appear in nums.
Constraints:
n == nums.length
1 <= n <= 104
0 <= nums[i] <= n
All the numbers of nums are unique.
 

Follow up: Could you implement a solution using only O(1) extra space complexity and O(n) runtime complexity?
 */

import java.util.Arrays;

public class CycleSort {
    public static void main(String[] args) {
		int[]arr= {3,4,1,0};
		
		System.out.println(cycleSort(arr));
	}
	static int cycleSort(int[] arr) {
		int i=0;
			
            while (i<arr.length) {
                int check=arr[i];
			if(arr[i]<arr.length && arr[i]!=arr[check]) {
				swap(arr,i,check);
			}
			else {
				i++;
			}
		}
             //check which number is missing in the index
        for(int index=0;index<arr.length;index++){
            if(arr[index]!=index){
                return index;
            }

        }
        return arr.length;
    }
    
	
	private static void swap(int[] arr, int f, int s) {
		int temp=arr[f];
		arr[f]=arr[s];
		arr[s]=temp;
		
	}

    public int missingNumber(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        for(int i=0;i<n;i++){
            if (i != nums[i])
            {
				return i;
            }
        }
        return n;
    }
	public boolean isPalindrome(int x) {
		if(x<0){
			return false;
		}
		int temp=x;
		int rev=0;
		while(temp!=0){
			int rem=temp%10;
			rev=rev*10+rem;
			temp=temp/10;
		}
		return x==rev;
        
    }
	public int reverse(int x) {
		int rev=0;
		while(x!=0){
			int rem=x%10;
			rev=rev*10+rem;
			x=x/10;
		}
		return rev;
    }

	
}
