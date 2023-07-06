/*
Quick Sort is a Divide and Conquer algorithm. It picks an element as a pivot and partitions the given array around the picked pivot.
Given an array arr[], its starting position is low (the index of the array) and its ending position is high(the index of the array).

Note: The low and high are inclusive.

Implement the partition() and quickSort() functions to sort the array.

Example 1:

Input: 
N = 5 
arr[] = { 4, 1, 3, 9, 7}
Output:
1 3 4 7 9
Example 2:

Input: 
N = 9
arr[] = { 2, 1, 6, 10, 4, 1, 3, 9, 7}
Output:
1 1 2 3 4 6 7 9 10
Your Task: 
You don't need to read input or print anything. Your task is to complete the functions partition()  and quickSort() which takes the array arr[], low and high as input parameters and partitions the array. Consider the last element as the pivot such that all the elements less than(or equal to) the pivot lie before it and the elements greater than it lie after the pivot.

Expected Time Complexity: O(N*logN)
Expected Auxiliary Space: O(logN)

Constraints:
1 <= N <= 103
1 <= arr[i] <= 104

*/
//{ Driver Code Starts
import java.util.*;
class July_6_2023
{
    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }

    // Driver program
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while(T>0)
        {
            int n = sc.nextInt();
            int arr[] = new int[n];
            for(int i=0;i<n;i++)
                arr[i] = sc.nextInt();

            new Solution().quickSort(arr,0,n-1);
            printArray(arr);
            T--;
        }
    } 
}
// } Driver Code Ends

class Solution
{
    //Function to sort an array using quick sort algorithm.
    static void quickSort(int arr[], int low, int high)
    {
        // code here
        if (low < high)
        {

            //pi is partitioning index, arr[pi] is now at right place.
            int p = partition(arr, low, high);
            //Separately sorting elements before and after partitioning index.
            quickSort(arr, low, p-1);
            quickSort(arr, p+1, high);
        }

    }

    static int partition(int arr[], int low, int high)
    {
        // your code here
        int pivot = arr[high];
        //Index of smaller element and indicates the right position of 
        //pivot found so far.
        int i = (low-1); 
        for (int j=low; j<=high-1; j++)
        {
            //If current element is smaller than or equal to pivot we increment
            //the value of i and swap the values at ith and jth index.
            if (arr[j] <= pivot)
            {
                i++;
                //Swapping of values at ith and jth index.
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        //At last, swapping of value at ith and the last index which was
        //selected as pivot.
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;

        //returning the partitioning index. 
        return i+1;

    } 
}