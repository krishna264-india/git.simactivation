public class QueueUsingStack {
    private Stack<Integer> first;
    private Stack<Integer> second;
     
    public QueueUsingStack(){
        first = new Stack<>();
        second = new Stack<>();
    }

    public void push(int item){
        first.push(item);
    }

    public int pop()throws Exception{
        while(!first.isEmpty()){
              second.push(first.pop());
        }
        int removed= second.pop();

        while(!second.isEmpty()){
            first.push(second.pop());

        }
        return removed;

    }
    public int peek() throws Exception{
        while(!first.isEmpty()){
            second.push(frist.pop());
        }
        int peeked=second.peek();
        while(!second.isEmpty()){
            first.push(second.pop());
        }
        return peeked;
    }
    public boolean isEmpty(){
        return  first.isEmpty() && second.isEmpty();
    }
}
