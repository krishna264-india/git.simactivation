package DynamicPrograming;

public class StateTransaction {
    public static void main(String[] args) {
        int n=5;
        System.out.println(climbStairs(n));
    }
    /* * You are climbing a staircase. It takes n steps to reach the top.
    * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
    * Example 1:
    * Input: n = 2
    * Output: 2
    * Explanation: There are two ways to climb to the top.
    * 1. 1 step + 1 step
    * 2. 2 steps
    * Example 2:
    * Input: n = 3
    * Output: 3
    * Explanation: There are three ways to climb to the top.
    * 1. 1 step + 1 step + 1 step
    * 2. 1 step + 2 steps
    * 3. 2 steps + 1 step
     */
    public static int climbStairs(int n){
        if(n<=2) return n;// base case
        // dp array to store the number of ways to reach each step
        int[] dp=new int[n+1];
        dp[1]=1;// 1 way to reach the first step
        dp[2]=2;// 2 ways to reach the second step
        // fill the dp array using the relation dp[i]=dp[i-1]+dp[i-2]
        for(int i=3;i<=n;i++){// for each step from 3 to n
            dp[i]=dp[i-1]+dp[i-2];// number of ways to reach the ith step
        }
        return dp[n];
    }
    public int minCostClimbingStairs(int[] cost) {
        int n=cost.length;
        // dp array to store the minimum cost to reach each step
        int[] dp=new int[n+1];
        dp[0]=0;
        dp[1]=0;
        // fill the dp array
        for(int i=2;i<=n;i++){
            dp[i]=Math.min(dp[i-1]+cost[i-1], dp[i-2]+cost[i-2]);
        }
        return dp[n];
    }
    /*
    * Alice and Bob take turns playing a game, with Alice starting first.
    * Initially, there is a number n on the chalkboard. 
    * On each player's turn, that player makes a move consisting of:
    * Choosing any x with 0 < x < n and n % x == 0.
    * Replacing the number n on the chalkboard with n - x.
    * Also, if a player cannot make a move, they lose the game.
    * Return true if and only if Alice wins the game, assuming both players play optimally.
    * Example 1:
    * Input: n = 2
    * Output: true
    * Explanation: Alice chooses 1, and Bob has no more moves.
    * Example 2:
    * Input: n = 3
    * Output: false
    * Explanation: Alice chooses 1, Bob chooses 1, and Alice has no more moves.
     */
    public static boolean divisorGame(int n) {
        if(n<=1) return false;
        return n%2==0;
    }
    /* * Given two words word1 and word2, return the minimum number of operations 
    required to convert word1 to word2.
    * You have the following three operations permitted on a word:
    * Insert a character
    * Delete a character
    * Replace a character
    * Example 1:
    * Input: word1 = "horse", word2 = "ros"
    * Output: 3
    * Explanation:
    * horse -> rorse (replace 'h' with 'r')
    * rorse -> rose (remove 'r')
    * rose -> ros (remove 'e')
    * Example 2:
    * Input: word1 = "intention", word2 = "execution"
    * Output: 5
    * Explanation:
    * intention -> inention (remove 't')
    *   inention -> enention (replace 'i' with 'e')
    *  enention -> exention (replace 'n' with 'x')
    * exention -> executtion (replace 'n' with 'c')
    * executtion -> execution (remove 't')
     */
    public static int minDistance(String word1, String word2) {
        int m=word1.length();
        int n=word2.length();
        // dp[i][j] represents the minimum edit distance between 
        // word1[0..i-1] and word2[0..j-1]
        int[][] dp=new int[m+1][n+1];
        // base case
        for(int i=0;i<=m;i++){
            dp[i][0]=i; // delete all characters from word1
        }
        for(int j=0;j<=n;j++){
            dp[0][j]=j; // insert all characters of word2
        }
        // fill the dp table
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(word1.charAt(i-1)==word2.charAt(j-1)){// if characters are the same, no operation needed
                    dp[i][j]=dp[i-1][j-1]; // no operation needed
                }else{
                    dp[i][j]=1+Math.min(dp[i-1][j-1], // replace
                                Math.min(dp[i-1][j], // delete
                                         dp[i][j-1])); // insert
                }
            }
        }
        return dp[m][n];
    }
    public int fib(int n) {
            if(n==0) return 0;
            if(n==1) return 1;  
            int a=0, b=1;
            for(int i=2;i<=n;i++){
                int sum=a+b;
                a=b;
                b=sum;
            }
        return b;
    }
    static int factorial(int n){
        if(n==0 || n==1) return 1;
        return n*factorial(n-1);
    }
}
