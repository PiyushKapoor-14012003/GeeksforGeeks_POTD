/*Given two sorted arrays arr1[] and arr2[] of sizes n and m in non-decreasing order. Merge them in sorted order without using any extra space. Modify arr1 so that it contains the first N elements and modify arr2 so that it contains the last M elements.

Example 1:

Input: 
n = 4, arr1[] = [1 3 5 7] 
m = 5, arr2[] = [0 2 6 8 9]
Output: 
arr1[] = [0 1 2 3]
arr2[] = [5 6 7 8 9]
Explanation:
After merging the two 
non-decreasing arrays, we get, 
0 1 2 3 5 6 7 8 9.
Example 2:

Input: 
n = 2, arr1[] = [10 12] 
m = 3, arr2[] = [5 18 20]
Output: 
arr1[] = [5 10]
arr2[] = [12 18 20]
Explanation:
After merging two sorted arrays 
we get 5 10 12 18 20.
Your Task:
You don't need to read input or print anything. You only need to complete the function merge() that takes arr1, arr2, n and m as input parameters and modifies them in-place so that they look like the sorted merged array when concatenated.

Expected Time Complexity:  O((n+m) log(n+m))
Expected Auxilliary Space: O(1)

Constraints:
1 <= n, m <= 105
0 <= arr1i, arr2i <= 107
*/
/* APPROACH:
 Intuition
Use Gap Method:- We start comparing elements that are far from each other rather than adjacent. For every pass, we calculate the gap and compare the elements towards the right of the gap. Every pass, the gap reduces to the ceiling value of dividing by 2.

Implementation
Initially take the gap as (m+n+1)/2.
Take as a i = 0 and j = gap.
Run a loop from i &  j to  m+n and whenever arr[i]<arr[j] , just swap those.
After completion of the loop reduce the gap as gap=ceil(gap/2).
Repeat the process until gap>0.
 */

//{ Driver Code Starts
//Initial Template for Java
import java.util.*;
import java.io.*;
import java.io.*;

public class July_7_2023
{
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
        while(t-->0){
            String inputLine[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int m = Integer.parseInt(inputLine[1]);
            long arr1[] = new long[n];
            long arr2[] = new long[m];
            inputLine = br.readLine().trim().split(" ");
            for(int i=0; i<n; i++){
                arr1[i] = Long.parseLong(inputLine[i]);
            }
            inputLine = br.readLine().trim().split(" ");
            for(int i=0; i<m; i++){
                arr2[i] = Long.parseLong(inputLine[i]);
            }
            Solution ob = new Solution();
            ob.merge(arr1, arr2, n, m);

            StringBuffer str = new StringBuffer();
            for(int i=0; i<n; i++){
                str.append(arr1[i]+" ");
            }
            for(int i=0; i<m; i++){
                str.append(arr2[i]+" ");
            }
            System.out.println(str);
        }
    }
}

// } Driver Code Ends

//User function Template for Java
class Solution
{
    //Function to merge the arrays.
    public static void merge(long arr1[], long arr2[], int n, int m) 
    {
        // code here 
        int i, j, gap = n + m;
        long tmp;

        for(gap = nextGap(gap); gap > 0; gap = nextGap(gap)) {

            //Comparing elements in the first array itself with difference in 
            //index equal to the value of gap.
            for(i = 0; i + gap < n; i++){
                if(arr1[i] > arr1[i + gap]){

                    //If element at ith index is greater than element at
                    //(i+gap)th index, we swap them.
                    tmp = arr1[i];
                    arr1[i] = arr1[i + gap];
                    arr1[i+gap] = tmp;
                }
            }

            //Now comparing elements in both arrays with help of two pointers.
            //The loop stops whenever any pointer exceeds the size of its array
            for(j = gap > n ? gap-n : 0 ; i < n&&j < m; i++, j++){

                //If element in the first array is greater than element in
                //second array, we swap them.
                if(arr1[i] > arr2[j]){
                    tmp = arr1[i];
                    arr1[i] = arr2[j];
                    arr2[j] = tmp;
                }
            }

            if(j < m) {
                //At last, comparing elements in the second array itself with 
                //difference in index equal to the value of gap.
                for (j = 0; j + gap < m; j++){

                    //If element at jth index is greater than element at
                    //(j+gap)th index, we swap them.
                    if(arr2[j] > arr2[j + gap]){
                        tmp = arr2[j];
                        arr2[j] = arr2[j + gap];
                        arr2[j + gap] = tmp;
                    }
                }
            }
        }
    }
    //Function to find next gap.
    public static int nextGap(int gap) {

        //It returns the ceil value of gap/2 or 0 if gap is 1.
        if(gap <= 1) return 0; 
        return (gap / 2) + (gap % 2); 
    }
}
