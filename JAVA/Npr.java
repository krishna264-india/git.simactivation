public class Npr {
    public static void main(String[] args) {
        int n=10;
        int r=4;
        int npr=1;
        for(int i=1;i<=4;i++){
             npr=npr*(n-r+i)/i;
             System.out.println((int)npr);

        }
    }
}
