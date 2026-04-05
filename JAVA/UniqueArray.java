public class UniqueArray {
    public static void main(String[] args){
        int[] arr= {1,3,5,6,7,8,9};
        int[] arr1={2,4,5,6,8,10};
        unique(arr,arr1);
    

    }
    static void unique(int[] arr, int[] arr1){
        for(int i=0;i<arr.length;i++){
            int flag=1;
            for(int j=0;j<arr1.length;j++){
                if(arr[i]==arr1[j]){
                    flag=0;
                    break;
                }
            }
            if(flag==1){
                System.out.println(arr[i]);
            }
        }
        for(int i=0;i<arr1.length;i++){
            int flag=1;
            for(int j=0;j<arr1.length;j++){
                if(arr1[i]==arr[j]){
                    flag=0;
                    break;
                }
            }
            if(flag==1){
                System.out.println(arr1[i]);
            }
        }
    }
    public static int[] findUnique(int[] arr){
        int[] result=new int[arr.length];
        for(int i=0;i<arr.length;i++){
            result[i]=arr[i];
        }
        return result;
    }
}
