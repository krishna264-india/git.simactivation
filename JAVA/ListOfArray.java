import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListOfArray {
    public static void main(String[] args){
        ArrayList<Integer> list=new ArrayList<>();
         list.add(10);
         list.add(20);
         list.add(50);
         list.add(70);
         list.add(60);
         list.set(0, 45);
        // Object[] array=list.toArray();
         Collections.sort(list);
         Collections.reverse(list);
         Collections.emptyList();
         int max=Collections.max(list);
         int min=Collections.min(list);
         System.out.println(max+"\t"+min);

         ArrayList<String> str=new ArrayList<>();
         str.add("hey");
         str.add("hi");
         str.add("how are");
         str.add("you!");
         Collections.reverse(str);
         System.out.println(str.toString());
    }
    
}
