public class MergeArray {

    public static void main(String[] args) {
        int[][] arr={{2,4,6},{5,3,7},{1,8,9}};
        int[][] arr1={{9,7,5},{8,6,4},{2,1,0}};

        int[][] sum=new int[3][3];
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                System.out.print(i+" "+j);
                sum[i][i]=arr[i][j]+arr1[i][j];

            }

        }
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                   System.out.print(sum[i][j]+" ");
                   sum[i][j]=arr[i][j]+arr1[i][j];
            }
            System.out.println("-------------------");
        }
        
    }
    public void merge(int[] nums1, int m, int[] nums2, int n) {
            int i=m-1;
            int j=n-1;
            int k=m+n-1;
            while(i>=0 && j>=0){
                if(nums1[i]> nums2[j]){
                    nums1[k--]= nums1[i--];
                }
                else{
                    nums1[k--]=nums2[j--];
                }
            }
            while(j>=0){
                nums1[k--]=nums2[j--];
            }
            return nums1;
    }
    /*merger intervals

     */
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        List<int[]> result=new ArrayList<>();
        int[] currentInterval=intervals[0]; 
        result.add(currentInterval);
        for(int[] interval:intervals){
            // compare currentInterval and interval
            int currentEnd=currentInterval[1];// used
            int nextBegin=interval[0];// not used
            int nextEnd=interval[1];// used
            // check for overlap
            if(currentEnd>=nextBegin){// overlap
                currentInterval[1]=Math.max(currentEnd,nextEnd);// merge
            }
            else{
                // no overlap
                currentInterval=interval;// no overlap
                result.add(currentInterval);// add to the result
            }
        }
// convert list to array
        return result.toArray(new int[result.size()][]);

    }
    
}
