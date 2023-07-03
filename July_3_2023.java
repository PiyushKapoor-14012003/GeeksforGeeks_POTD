/*Given an array arr[] of n positive integers. The task is to find the maximum of j - i subjected to the constraint of arr[i] <= arr[j].

Example 1:

Input:
n = 9
arr[] = {34, 8, 10, 3, 2, 80, 30, 33, 1}
Output: 
6
Explanation: 
In the given array arr[1] < arr[7]  satisfying 
the required condition (arr[i] <= arr[j])  thus 
giving the maximum difference of j - i which is
6(7-1).
Example 2:

Input:
N = 2
arr[] = {18, 17}
Output: 
0
Explanation: 
We can either take i and j as 0 and 0 
or we cantake 1 and 1 both give the same result 0.
Your Task:
Complete the function maxIndexDiff() which takes array arr and size n, as input parameters and returns an integer representing the answer. You don't to print answer or take inputs. 

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)

Constraints:
1 ≤ N ≤ 106
0 ≤ Arr[i] ≤ 109
*/
/* Approch:
 * Create a suffix max array from right to left of the array i.e, Rmax[i] = max(Rmax[i+1],arr[i]) and Rmax[n-1] = arr[n-1].
 *Create a prefix min array from left to right of the array i.e, Lmin[i] = min(Lmin[i-1],arr[i]) and Lmin[0] = arr[0].
 *Then use two-pointer approach where loop the ith pointer from (i = 0 to i < N).
 *For every iteration check if this condition holds (Lmin[i] <= Rmax[j]) then just take this index as the farthest point for that ith element and keep a global max value and update it with (j-i) and increase the right index(j).
 *Else increase the left index(i).
 *Return the global max value.
 */
//{ Driver Code Starts
import java.io.*;
import java.util.*;

class July_3_2023 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int arr[] = new int[n];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            System.out.println(new Solution().maxIndexDiff(arr, n));
        }
    }
}
// } Driver Code Ends


class Solution {

    int maxIndexDiff(int arr[], int n) {
        // code here
        if (n == 1) {
            return 0;
        }
        int RM[] = new int[n];
        int LMin[] = new int[n];
        LMin[0] = arr[0];
        for (int i = 1; i < n; ++i) LMin[i] = Integer.min(arr[i], LMin[i - 1]);
        RM[n - 1] = arr[n - 1];
        for (int j = n - 2; j >= 0; --j)
            RM[j] = Integer.max(arr[j], RM[j + 1]);
        int i = 0, j = 0, maxDiff = -1;
        while (j < n && i < n) {
            if (LMin[i] <= RM[j]) {
                maxDiff = Integer.max(maxDiff, j - i);
                j++;
            } else
                i++;
        }
        return maxDiff;
    }
}