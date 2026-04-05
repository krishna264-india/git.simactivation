
import java.util.ArrayList;
public class LinearRecursive {
    public static void main(String[] args){
        int[] arr={1,3,5,7,8,9};
        // ArrayList<Integer> list=new ArrayList<>();
        ArrayList<Integer> ans=findSearch1(arr,5,0);
        System.out.println(ans);
        
    }
    static boolean sorted(int[] arr,int index){
        if(index==arr.length-1){
            return true;

        }
        return arr[index]<arr[index+1] && sorted(arr,index+1);

    }

          static boolean linearSearch(int[] arr,int target,int index){
            if(index==arr.length){
                return true;

            }
             return arr[index]==target || linearSearch(arr,target,index+1);

          }

          
          static int findIndex(int[] arr,int target,int index){
            if(index==arr.length){
               return -1;
            }
            if(arr[index]==target){
                return (index);

            }
            else{
            return findIndex(arr,target,index+1);
            }

          }
    
          static int findIndex1(int[] arr,int target,int index){
            if(index==-1){
                return -1;
            }
            if(arr[index]==target){
                return index;
            }else{
                return findIndex1(arr,target,index-1);
            }


          }

          static ArrayList<Integer> findSearch(int[] arr,int target,int i,ArrayList<Integer> list){
            if(i==arr.length){
               return list;
            }
            if(arr[i]==target){
                 list.add(i);
            }
            return findSearch(arr,target,i+1,list);

          }

          static ArrayList<Integer> findSearch1(int[] arr,int target,int index){
            ArrayList<Integer> list=new ArrayList<>();
            if(index==arr.length){
                  return list;
            }
            if(arr[index]==target){
                list.add(index);
            }
            ArrayList<Integer> ansFromBelowcells=findSearch1(arr,target,index+1);
            list.addAll(ansFromBelowcells);

            return list;

          }    
}
