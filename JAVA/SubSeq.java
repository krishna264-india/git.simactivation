import java.util.*;
public class SubSeq {
    public static void main(String []args){
       // subSeq("","abc");
       //subSeqAsci("","abc");
        System.out.println(subSeqRetAsci("","abc"));

    }
    /*
     * o/p:- abc
    ab
    ac
    a
    bc
    b
    c
     */
    
    static void subSeq(String p,String up){
        if(up.isEmpty()){ 
            System.out.println(p);
            return;
        }
        char ch=up.charAt(0);
        subSeq(p+ch, up.substring(1));
        subSeq(p,up.substring(1));

    }
    /*
     * O/p: [abc, ab, ac, a, bc, b, c, ]
     */
   
    static ArrayList<String> subSeqRet(String p,String up){
        if(up.isEmpty()){
          ArrayList<String> list=new ArrayList<>();
          list.add(p);
          return list;
        }
        char ch=up.charAt(0);
        ArrayList<String> left=subSeqRet(p+ch ,up.substring(1));
        ArrayList<String> right=subSeqRet(p,up.substring(1));
        left.addAll(right);
        return left;

    }
    static ArrayList<String> subSeqRetAsci(String p,String up){
        if(up.isEmpty()){
          ArrayList<String> list=new ArrayList<>();
          list.add(p);
          return list;
        }
        char ch=up.charAt(0);
        ArrayList<String> first=subSeqRetAsci(p+ch ,up.substring(1));
        ArrayList<String> second=subSeqRetAsci(p,up.substring(1));
        ArrayList<String> third=subSeqRetAsci(p+(ch+0),up.substring(1));

        first.addAll(second);
        first.addAll(third);
        return first;

    }

    static void subSeqAsci(String p,String up){
        if(up.isEmpty()){ 
            System.out.println(p);
            return;
        }
        char ch=up.charAt(0);
        subSeqAsci(p+ch, up.substring(1));
        subSeqAsci(p,up.substring(1));
        subSeqAsci(p+(ch+0) ,up.substring(1));

    }
}
