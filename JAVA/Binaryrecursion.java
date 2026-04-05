public class Binaryrecursion {
    public static void main(String[] args){
        int[] arr={23,45,24,54,67,76,89,-1};
        int target=89;
        System.out.println(recursiveBinary(arr,target,0,arr.length-1));

    }
    static int recursiveBinary(int[] arr,int target,int s,int e){
        if(s > e){
            return -1;

        }
        int m=s+(e-s)/2;
        if(arr[m]==target){
           return m;
    }
    if(arr[s]<=arr[m]){
        if(target>=arr[s] && target<=arr[m]){
           return recursiveBinary(arr,target,s,m-1);
        }else{
            return recursiveBinary(arr,target,m+1,e);
        }

    }
    if(target>=arr[m] && target<=arr[e]){
        return recursiveBinary(arr,target,m+1,e);

    }
    return recursiveBinary(arr,target,s,m-1);
    }
   
}
