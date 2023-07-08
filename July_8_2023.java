/*Given an array arr[] of n integers. Check whether it contains a triplet that sums up to zero. 

Note: Return 1, if there is at least one triplet following the condition else return 0.

Example 1:

Input: n = 5, arr[] = {0, -1, 2, -3, 1}
Output: 1
Explanation: 0, -1 and 1 forms a triplet
with sum equal to 0.
Example 2:

Input: n = 3, arr[] = {1, 2, 3}
Output: 0
Explanation: No triplet with zero sum exists. 

Your Task:
You don't need to read input or print anything. Your task is to complete the boolean function findTriplets() which takes the array arr[] and the size of the array (n) as inputs and print 1 if the function returns true else print 0 if the function returns false. 

Expected Time Complexity: O(n2)
Expected Auxiliary Space: O(1)

Constrains:
1 <= n <= 104
-106 <= Ai <= 106
 */
/*
 * Approach:
 * For every element of the array check if there is a pair(by using two pointer approach) whose sum is equal to the negative value of that element.
 * Note:- First sort the array so that we can use two pointer approach to find a pair. 
 * Sort the array in ascending order.
 * Traverse the array from start to end.
 * For every index i, create two variables l = i + 1 and r = n – 1 and run a loop until l is less than r
 * Check if the sum of array[i], array[l] and array[r] is equal to zero then return true as we found the triplet.
 * If the sum is less than zero then increment the value of l by 1, by increasing the value of l the sum will increase as the array is sorted, so array[l+1] > array [l]
 * If the sum is greater than zero then decrement the value of r, by decreasing the value of r the sum will decrease as the array is sorted, so array[r-1] < array [r].
 * In the end, if a triplet is not found then return false.
 */
//{ Driver Code Starts
import java.util.*;
class July_8_2023
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int[] a=new int[n];
            for(int i=0;i<n;i++){
                a[i]=sc.nextInt();
            }
            Solution g=new Solution();
            if(g.findTriplets(a,n))
                System.out.println("1");
            else
                System.out.println("0");

        }
    }
}
// } Driver Code Ends

/*Complete the function below*/

class Solution
{
    // arr[]: input array
    // n: size of the array
    //Function to find triplets with zero sum.
    public boolean findTriplets(int arr[] , int n)
    {
        //add code here.
        //Sorting the elements.
        Arrays.sort(arr);

        //Traversing the array elements.
        for(int i=0;i<n-2;i++){
            //Taking two pointers. One at element after ith index and another
            //at the last index.
            int l=i+1;
            int r=n-1;
            int x=arr[i];

            //Using two pointers over the array which helps in checking if
            //the triplet sum is zero.
            while(l<r){

                //If sum of elements at indexes i, l and r is 0, we return true.
                if(x+arr[l]+arr[r]==0)
                    return true;
                //Else if the sum is less than 0, it means we need to 
                //increase the sum so we increase the left pointer l.
                else if(x + arr[l] + arr[r] < 0)
                    l++;
                //Else the sum is more than 0 and we need to decrease the
                //sum so we decrease the right pointer r.
                else
                    r--;
            }
        }
        //returning false if no triplet with zero sum is present.
        return false;
    }
}