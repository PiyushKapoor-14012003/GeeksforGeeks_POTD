/*Given a matrix with n rows and m columns. Your task is to find the kth element which is obtained while traversing the matrix spirally.
You need to complete the method findK which takes four arguments the first argument is the matrix A and
the next two arguments will be n and m denoting the size of the matrix A and then the forth argument is an integer k.
The function will return the kth element obtained while traversing the matrix spirally.

Example 1:

Input:
n = 4, m = 4, k = 10
A[][] = {{1  2  3  4},
{5  6  7  8},
{9  10 11 12},
{13 14 15 16}}
Output:
13
Explanation:

The spiral order of matrix will look like 1->2->3->4->8->12->16->15->14->13->9->5->6->7->11->10. So the 10th element in this order is 13. 
Example 2:

Input:
n = 3, m = 3, k = 4
A[][] = {{1 2 3},
{4 5 6},
{7 8 9}}
Output:
6
Explanation:
The spiral order of matrix will look like 1->2->3->6->9->8->7->4->5. So the 4th element in this order is 6.
Your Task:
You only need to implement the given function findK(). Do not read input, instead use the arguments given in the function. 
Return the K'th element obtained by traversing matrix spirally.

Expected Time Complexity: O(n*m)
Expected Auxiliary Space: O(n*m)

Constraints:
1<=n,m<=103
1<=k<=n*m
-109 <= A[i][j] <= 109
 */
/*
 * Implementation:::
   Create an array list to store the elements of the matrix.
   Start a while loop to check the condition that we don't move outside the matrix.
   Now keep track of the row or column we are traversing-> 4 possible cases
   left column.
   right column.
   top row
   bottom row.
   create dir variable which keeps track whether we are moving 
   left to right (dir=0), 
   top to bottom(dir =1) ,
   bottom to top(dir =2) 
   right to left (dir =3).
   now traverse between left to right for first row and update top as top--(to move to next row)  and make changes in dir.
   Keep on adding the element encountered to the array list.
   perform step 4 and 5 for bottom to top, right to left and top to bottom. 
   Once we traverse the matrix, we come out of the loop. 
   Return the element at k-1th place in array list.
 */
//{ Driver Code Starts
import java.util.*;

class July_11_2023
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t > 0)
        {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int k = sc.nextInt();
            int arr[][] = new int[1000][1000];
            for(int i=0; i<n; i++)
            {
                for(int j=0; j<m; j++ )
                {
                    arr[i][j] = sc.nextInt();
                }
            }
            System.out.println(new Solution().findK(arr, n, m, k));
            t--;
        }
    }
}
// } Driver Code Ends

class Solution
{
     /*You are required to complete this method*/
    int findK(int A[][], int n, int m, int k)
    {
	// Your code here	
	    int ans = solve(A,0,0,n,m,k);
    	return ans;
    }
    int solve(int a[][], int i, int j,int n, int m, int k)
    {
        if (n < 1 || m < 1)
            return -1;
 
        /*.....If element is in outermost ring ....*/
        /* Element is in first row */
        if (k <= m)
            return a[i + 0][j + k - 1];
 
        /* Element is in last column */
        if (k <= (m + n - 1))
            return a[i + (k - m)][j + m - 1];
 
        /* Element is in last row */
        if (k <= (m + n - 1 + m - 1))
            return a[i + n - 1][j + m - 1 - (k - (m + n - 1))];
 
        /* Element is in first column */
        if (k <= (m + n - 1 + m - 1 + n - 2))
            return a[i + n - 1 - (k - (m + n - 1 + m - 1))][j + 0];
 
        return solve(a, i + 1, j + 1, n - 2,
                     m - 2, k - (2 * n + 2 * m - 4));
    }
}