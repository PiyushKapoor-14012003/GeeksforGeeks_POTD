/*Given a stack, delete the middle element of the stack without using any additional data structure.
Middle element:- ceil((size_of_stack+1)/2) (1-based indexing) from bottom of the stack.

Note: The output shown by the compiler is the stack from top to bottom.

Example 1:

Input: 
Stack = {10, 20, 30, 40, 50}
Output:
ModifiedStack = {10, 20, 40, 50}
Explanation:
If you print the stack the bottom-most element will be 10 and the top-most element will be 50. 
Middle element will be element at index 3 from bottom, which is 30. Deleting 30, stack will look like {10 20 40 50}.
Example 2:

Input: 
Stack = {10 20 30 40}
Output:
ModifiedStack = {10 30 40}
Explanation:
If you print the stack the bottom-most element will be 10 and the top-most element will be 40. 
Middle element will be element at index 2 from bottom, which is 20. Deleting 20, stack will look like {10 30 40}.
Your Task:
You don't need to read input or print anything. Complete the function deleteMid() 
which takes the stack and its size as input parameters and modifies the stack in-place.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)

Constraints:
2 ≤ size of stack ≤ 105

 */
/*
 * Implementation
 * We will make a recursive function deleteMid_util(stack , sizeofstack , current) 
where the stack will passed by reference and there will be another two parameters the size of the stack and current variable 
which stores how many elements we already popped from the stack .
 * The base case of the function will be if the current == sizeofstack/2 , that means we have popped out the half of the elements from the stack .
 * Now the top element of the stack will be the middle element of the stack
 * Now we will pop the middle element and return 
 * If current != sizeofstack/2 then we  have to remove more elements
 * We will store the top element in a variable 
 * pop the top element
 * increment the current variable 
 * call the recursive function again deleteMid_util(stack,sizeofstack,current+1)
 * when we get back we will push the popped element again 
 * We will call the deleteMid_util function where current will be 0
 */
//{ Driver Code Starts
//Initial template for Java

import java.io.*;
import java.util.*;

class July_15_2023
{
    public static void main (String[] args) 
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();

        while(t-->0)
        {
            int sizeOfStack =sc.nextInt();
            Stack <Integer> myStack=new Stack<>();

            //adding elements to the stack
            for(int i=0;i<sizeOfStack;i++)
            {
                int x=sc.nextInt();
                myStack.push(x);

            }
            Solution obj=new Solution();
            obj.deleteMid(myStack,sizeOfStack);

            while(!myStack.isEmpty())
            {
                System.out.print(myStack.peek()+" ");
                myStack.pop();
            }
            System.out.println();
        }

    }
}
// } Driver Code Ends

//User function Template for Java
class Solution
{
    //Function to delete middle element of a stack.
    public void deleteMid_util(Stack<Integer>s,int sizeOfStack,int current)
    {
        //if current pointer is half of the size of stack then we 
        //are accessing the middle element of stack.
        if(current==sizeOfStack/2)
        {
            s.pop();
            return;
        }
        //storing the top element in a variable and popping it.
        int x=s.peek();
        s.pop();
        current+=1;

        //calling the function recursively.
        deleteMid_util(s,sizeOfStack,current);

        //pushing the elements (except middle element) back 
        //into stack after recursion calls.
        s.push(x);
    } 

    public void deleteMid(Stack<Integer>s,int sizeOfStack)
    {
        deleteMid_util(s,sizeOfStack,0);
    }
}