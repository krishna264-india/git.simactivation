public class DLLMain{
    public static void main(String[] args){
    //     DLL list=new DLL();
    //     list.insertFirst(2);
    //     list.insertFirst(1);
    //     list.insertFirst(3);
    //     list.insertFirst(9);

    //    list.display();
    //    DLLInterviewQuestions dLL=new DLLInterviewQuestions();
       Scanner scanner=new Scanner(System.in);
       BinaryTree tree=new  BinaryTree();
       tree.populate(scanner);
       tree.display();

       
    }
}