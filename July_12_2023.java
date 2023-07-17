/*
Given a number and its reverse. Find that number raised to the power of its own reverse.
Note: As answers can be very large, print the result modulo 109 + 7.

Example 1:

Input:
N = 2, R = 2
Output: 4
Explanation: The reverse of 2 is 2 and after raising power of 2 by 2 we get 4 which gives remainder as 4 when divided by 1000000007.
Example 2:

Input:
N = 12, R = 21
Output: 864354781
Explanation: The reverse of 12 is 21and 1221 when divided by 1000000007 gives remainder as 864354781.
Your Task:
You don't need to read input or print anything. You just need to complete the function pow() that takes two parameters N and R denoting the input number and its reverse and returns power of (N to R)mod(109 + 7).

Expected Time Complexity: O(LogN).
Expected Auxiliary Space: O(LogN).

Constraints:
1 <= N <= 109
 */
/*Implementation
If R==0 then return 1.
Recursively call power(N,R/2) and store the value in ans.
If R is even then return ans*ans.
Else return ans*ans*N.
Note:- Use modulo 109+7 to avoid overflow error.
 */
//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class July_12_2023 
{
    // compute reverse of a number
    public static long rev(long n)
    {
        long rev_num = 0;
        while(n > 0) 
        { 
            rev_num = rev_num*10 + n%10; 
            n = n/10; 
        } 
        return rev_num;
    }

    public static void main (String[] args) 
    {
        Scanner sc=new Scanner(System.in);
        //testcases
        int T=sc.nextInt();
        while(T-->0)
        {
            Solution obj=new Solution();
            int N;
            //input N
            N=sc.nextInt();
            int R=0;
            // reverse the given number n
            R=(int)rev(N);
            //power of the number to it's reverse
            long ans=(long)obj.power(N,R);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends
//User function Template for Java
class Solution
{
    public long modfun(long n, long  R)
    {
        // Base cases 
        if (n == 0) 
            return 0; 
        // power zero mean answer is 1
        if (R == 0)  
            return 1; 
        // If R is even 
        long y; 
        if (R % 2 == 0) { 
            // finding r/2 power as power is even then storing answer in y and if power is even like 2^4 we can simply do (2^2)*(2^2)
            y = modfun(n, R/2);  
            y = (y * y) % 1000000007; 
        } 

        // If R is odd 
        else { 
            y = n % 1000000007; 
            // reduce the power by 1 to make it even. The reducing power by one can be done if we take one n out. Like 2^3 can be written as 2*(2^2)
            y = (y * modfun(n, R - 1) % 1000000007) % 1000000007; 
        } 
        // finally return the answer (y+mod)%mod = (y%mod+mod%mod)%mod = (y%mod)%mod
        return ((y + 1000000007) % 1000000007);  
    }

    long power(int N,int R)
    {
        return modfun(N,R)%1000000007;

    }

}
