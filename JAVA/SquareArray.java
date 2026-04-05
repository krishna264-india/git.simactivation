public class SquareArray {

    public static void main(String[] args) {
        int[][] arr={
                   {12,14,15},
                   {15,17,18},
                   {34,23,13}
                  };
         int[] square=new int[arr.length];
         for(int i=0;i<arr.length;i++){
            square[i]=arr[i]*arr[i];
            }
             for(int i=0;i<square.length;i++){
                System.out.println(square[i]);
             }
         }
        
    }
    

