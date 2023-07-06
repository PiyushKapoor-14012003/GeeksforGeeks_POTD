/*The cost of stock on each day is given in an array price[] of size n. Each day you may decide to either buy or sell the stock i at price[i], you can even buy and sell the stock on the same day, Find the maximum profit which you can get.

Note: Buying and Selling of the stock can be done multiple times, but you can only hold one stock at a time. In order to buy another stock, firstly you have to sell the current holding stock.

Example 1:

Input:
n = 4
price[] = {3, 4, 1, 5}
Output:
5
Explanation:
We can buy stock on day 1 (at price 3) and sell it on 
day 2 (at price 4) profit will be 4-3=1, 
We can buy another stock on day 3 (at price 1) and sell 
it on day 4 (at price 5) profit will be 5-1=4, 
which will give us maximum profit of 1+4=5.
Example 2:

Input:
n = 5
price[] = {1, 3, 5, 7, 9}
Output:
8
Explanation:
We can buy stock on day 1 (at price 1) and sell it on 
day 5 (at price 9), 
which will give us maximum profit of 8.
Your Task:
Complete stockBuyAndSell() function which takes an array of Prices as input and returns the maximum profit achieved as described in the problem statement.

Expected Time Complexity: O(n)
Expected Auxiliary Space: O(1)
Approach:
Use Next greater element:
 Whenever the price of the stock is increased then add the profit into the answer else skip that day. 
 Whenever we skip the days , make sure to add them up and subtract it from the next chosen profit, 
 we will finally add this difference to the profit so far.
*/
//{ Driver Code Starts
import java.io.*;
import java.util.*;
class July_5_2023
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int n;
            n = Integer.parseInt(br.readLine());
            
            
            int[] prices = July_5_2023.input(br, n);
            
            Solution obj = new Solution();
            int res = obj.stockBuyAndSell(n, prices);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends

class Solution {
    public static int stockBuyAndSell(int n, int[] prices) {
        // code here
        int ans=0;
        for(int i=1;i<n;i++) {
            if(prices[i] > prices[i-1]) {
                ans += prices[i]-prices[i-1];
            }
        }
        return ans;
    }
}
        
