/*Your task is to implement  2 stacks in one array efficiently. You need to implement 4 methods.
push1 : pushes element into first stack.
push2 : pushes element into second stack.
pop1 : pops element from first stack and returns the popped element. If first stack is empty, it should return -1.
pop2 : pops element from second stack and returns the popped element. If second stack is empty, it should return -1.

Example 1:

Input:
push1(2)
push1(3)
push2(4)
pop1()
pop2()
pop2()
Output:
3 4 -1
Explanation:
push1(2) the stack1 will be {2}
push1(3) the stack1 will be {2,3}
push2(4) the stack2 will be {4}
pop1()   the poped element will be 3 from stack1 and stack1 will be {2}
pop2()   the poped element will be 4 from stack2 and now stack2 is empty
pop2()   the stack2 is now empty hence returned -1.
Example 2:

Input:
push1(1)
push2(2)
pop1()
push1(3)
pop1()
pop1()
Output:
3 1 -1
Explanation:
push1(1) the stack1 will be {1}
push2(2) the stack2 will be {2}
pop1()   the poped element will be 1 from stack1 and stack1 will be empty
push1(3) the stack1 will be {3}
pop1()   the poped element will be 3 from stack1 and stack1 will be empty
pop1()   the stack1 is now empty hence returned -1.
Your Task:
You don't need to read input or print anything. You are required to complete the 4 methods 
push1, push2 which takes one argument an integer 'x' to be pushed into stack one and two and 
pop1, pop2 which returns the integer poped out from stack one and two. If no integer is present in the stack return -1.

Expected Time Complexity: O(1) for all the four methods.
Expected Auxiliary Space: O(1) for all the four methods.

Constraints:
1 <= Number of queries <= 104
1 <= Number of elements in the stack <= 100
The sum of elements in both the stacks < size of the given array
 */
/*Implementation
Stack1 starts from the leftmost corner of the array, the first element in stack1 is pushed at index 0 of the array. 
Stack2 starts from the rightmost corner of the array, the first element in stack2 is pushed at index (n-1) of the array. 
Both stacks grow (or shrink) in opposite directions. 
To check for overflow, all we need to check is for availability of space between top elements of both stacks.
To check for underflow, all we need to check is if the value of the top of the both stacks  is between 0 to (n-1) or not.
 */
//{ Driver Code Starts
import java.util.*;

class July_14_2023
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in); 
        int T = sc.nextInt();
        while(T>0)
        {
            July_14_2023s g = new July_14_2023s();
            int Q = sc.nextInt();
            while(Q>0)
            {
                int stack_no = sc.nextInt();
                int QueryType = sc.nextInt();

                if(QueryType == 1)
                {
                    int a = sc.nextInt();
                    if(stack_no == 1)
                        g.push1(a);
                    else if(stack_no ==2)
                        g.push2(a);
                }else if(QueryType == 2)
                {
                    if(stack_no==1)
                        System.out.print(g.pop1()+" ");
                    else if(stack_no==2)
                        System.out.print(g.pop2()+" ");
                }

                Q--;
            }
            System.out.println();
            T--;
        }
    }
}
// } Driver Code Ends
class July_14_2023s
{
    int arr[];
    int size;
    int top1, top2;
    July_14_2023s()
    {
        size = 100; 
        arr = new int[100]; 
        top1 = -1; 
        top2 = size;
    }
    //Function to push an integer into the stack1.
    void push1(int x)
    {
        //if there is space between the top of both stacks 
        //we push the element at top1+1.
        if (top1 < top2 - 1)
        {
            top1++;
            arr[top1] = x;
        }

    }
    //Function to push an integer into the stack2.
    void push2(int x)
    {
        //if there is space between the top of both stacks 
        //we push the element at top2-1.
        if (top1 < top2 - 1)
        {
            top2--;
            arr[top2] = x;
        }

    }
    //Function to remove an element from top of the stack1.
    int pop1()
    {
        //if top1==-1, stack1 is empty so we return -1 else we 
        //return the top element of stack1.
        if (top1 >= 0 )
        {
            int x = arr[top1];
            top1--;
            return x;
        }
        else
            return -1;
    }
    //Function to remove an element from top of the stack2.
    int pop2()
    {
        //if top2==size of array, stack2 is empty so we return -1 else we 
        //return the top element of stack2.
        if (top2 < size)
        {
            int x = arr[top2];
            top2++;
            return x;
        }
        else
            return -1;
    }
}