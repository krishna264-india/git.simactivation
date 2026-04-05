interface MathOperation{
    abstract int operate(int a,int b);
}

 class MathOperations {
    public static void main(String[] args) {
        MathOperation addition=(int a,int b)->(a+b);
        System.out.println(performOperation(addition,20,10));
    }
    public static int performOperation(MathOperation operation,int a,int b){
        return operation.operate(a, b);

    }
    
}
