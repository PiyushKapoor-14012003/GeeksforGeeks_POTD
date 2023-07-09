/*You are given an array arr[] of N integers including 0. The task is to find the smallest positive number missing from the array.

Example 1:

Input:
N = 5
arr[] = {1,2,3,4,5}
Output: 6
Explanation: Smallest positive missing 
number is 6.
Example 2:

Input:
N = 5
arr[] = {0,-10,1,3,-20}
Output: 2
Explanation: Smallest positive missing 
number is 2.
Your Task:
The task is to complete the function missingNumber() which returns the smallest positive missing number in the array.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(1).

Constraints:
1 <= N <= 106
-106 <= arr[i] <= 106*/
/*
 * The idea is to use array elements as an index. 
 * To mark the presence of an element x, change the value at the index x to negative. 
 * But this approach doesn’t work if there are non-positive (-ve and 0) numbers. 
 * So segregate positive from negative numbers as the first step and then apply the approach.

Example:
Input array: [2,-1,-3,4,4,7]

Array after segregation: [2,4,4,7]. We ignore the negative integers.
To mark the presence of integer 2 we do arr[2-1]=-arr[2-1]. We do this only if arr[in] is positive initially. 
For 4 we do arr[4-1]=-arr[4-1].
Array after all operations = [2, -4, 4, -7]
So, the value at index 0 is positive. So 1 is the minimum positive number not present in the array. 
 */
//{ Driver Code Starts
import java.util.*;

// } Driver Code Ends
class July_9_2023
{
    //Function to find the smallest positive number missing from the array.
    static int segregate (int arr[], int size)
    {
        int j = 0, i;
        for(i = 0; i < size; i++)
        {
            if (arr[i] <= 0)  
            {
                int temp;
                //changing the position of negative numbers and 0.
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                //incrementing count of non-positive integers.
                j++;  
            }
        } 
        return j;
    }

    //Finding the smallest positive missing number in an array 
    //that contains only positive integers.
    static int findMissingPositive(int arr[], int size)
    {
        int i;
        //marking arr[i] as visited by making arr[arr[i] - 1] negative. 
        //note that 1 is subtracted because indexing starts from 0 and 
        //positive numbers start from 1.
        for(i = 0; i < size; i++)
        {
            if(Math.abs(arr[i]) - 1 < size && arr[Math.abs(arr[i]) - 1] > 0)
                arr[Math.abs(arr[i]) - 1] = -arr[Math.abs(arr[i]) - 1];
        }

        for(i = 0; i < size; i++)
        {
            if (arr[i] > 0)
            {
                //returning the first index where value is positive.
                // 1 is added because indexing starts from 0.
                return i+1;
            }
        }
        return size+1;
    }

    //Function to find the smallest positive number missing from the array.
    static int missingNumber(int arr[], int size)
    {
        //first separating positive and negative numbers. 
        int shift = segregate (arr, size);

        int arr2[] = new int[size-shift];
        int j=0;
        //shifting the array to access only positive part.
        for(int i=shift;i<(size);i++)
        {
            arr2[j] = arr[i];
            j++;
        }

        //calling function to find result and returning it.
        return findMissingPositive(arr2, j);
    }
}

//{ Driver Code Starts.
class Main
{   
    public static void main (String[] args) 
    {

        Scanner sc=new Scanner(System.in);

        //taking testcases
        int t=sc.nextInt();
        while(t-->0){

            //input number n
            int n=sc.nextInt();
            int[] arr=new int[n];

            //adding elements to the array
            for(int i=0;i<n;i++)
                arr[i]=sc.nextInt();

            July_9_2023 obj = new July_9_2023();

            //calling missingNumber()
            int missing = obj.missingNumber(arr,n);
            System.out.println(missing);
        }
    }
}

// } Driver Code Ends