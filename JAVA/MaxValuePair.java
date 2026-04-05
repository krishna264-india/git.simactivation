public class MaxValuePair {
    
    public static void main(String[] args){
        int[] arr= {1,2,3,4,5};
        int max= maxValuePair(arr);
        System.out.println("Maximum value pair is :"+ max);
    }
    static int maskBit(int[] arr,int mask){
        int count=0;
        for(int i=0;i<arr.length;i++){
            if((mask & arr[i])==mask){
                count++;
            }
        }
        return count;

    }
    static int maxValuePair(int[] arr){
        int res=0;
        int mask=0;
        for(int i=31;i>=0;i--){
            mask=1<<i|res;
            int count=maskBit(arr,mask);
            if(count>=2){
                res=res|mask;
            }
        }
        return res;
}
}
