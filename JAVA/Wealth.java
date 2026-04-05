public class Wealth {
    public static void main(String[] args){
        int[][] accounts={{1,3,4},
                           {2,5,7}};
                           System.out.println(wealth(accounts));
    }
    static int wealth(int[][] accounts){
          int res=0;
        for(int i=0;i<accounts.length;i++){
            int sum=0;
            for(int j=0;j<accounts[i].length;j++){
                   sum+=accounts[i][j];
            }
            res=Math.max(res,sum);
           
        }
        return res;
    }
}
