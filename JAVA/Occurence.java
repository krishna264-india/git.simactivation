public class Occurence {
    public static void main(String[] args){
        int[] arr={10,20,30,40,20};
        int X=20;
        System.out.println(firstOccurence(arr,X));

    }
    static int firstOccurence(int[] arr,int X){
        int count=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==X){
                count++;

            }
            
        }
        return count;

    }
}
