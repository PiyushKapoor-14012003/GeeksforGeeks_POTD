/*Given an input stream A of n characters consisting only of lower case alphabets. 
 * While reading characters from the stream, you have to tell which character has appeared only once in the stream upto that point. 
 * If there are many characters that have appeared only once, you have to tell which one of them was the first one to appear. 
 * If there is no such character then append '#' to the answer.

Example 1:
Input: A = "aabc"
Output: "a#bb"
Explanation: For every character first non
repeating character is as follow-
"a" - first non-repeating character is 'a'
"aa" - no non-repeating character so '#'
"aab" - first non-repeating character is 'b'
"aabc" - first non-repeating character is 'b'
Example 2:

Input: A = "zz"
Output: "z#"
Explanation: For every character first non
repeating character is as follow-
"z" - first non-repeating character is 'z'
"zz" - no non-repeating character so '#'

Your Task:
You don't need to read or print anything. Your task is to complete the function FirstNonRepeating() 
which takes A as input parameter and returns a string after processing the input stream.

Expected Time Complexity: O(n)
Expected Space Complexity: O(n)
 */
/*Implementation
Create an empty DLL. 
Also create two arrays inDLL[] and repeated[] of size 256. 
inDLL is an array of pointers to DLL nodes. repeated[] is a boolean array, repeated[x] is true if x is repeated two or more times, otherwise false. 
inDLL[x] contains pointer to a DLL node if character x is present in DLL, otherwise NULL.
Initialize all entries of inDLL[] as NULL and repeated[] as false.
To get the first non-repeating character, return character at head of DLL.
Following are steps to process a new character ‘x’ in stream.
If repeated[x] is true, ignore this character (x is already repeated two or more times in the stream)
If repeated[x] is false and inDLL[x] is NULL (x is seen first time). Append x to DLL and store address of new DLL node in inDLL[x].
If repeated[x] is false and inDLL[x] is not NULL (x is seen second time). Get DLL node of x using inDLL[x] and remove the node. 
Also, mark inDLL[x] as NULL and repeated[x] as true.
 */
//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class July_17_2023
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String A = br.readLine().trim();
            Solution ob = new Solution();
            String ans = ob.FirstNonRepeating(A);
            out.println(ans);
        }
        out.close();
    }
}

// } Driver Code Ends

class Solution
{
    public String FirstNonRepeating(String A)
    {
        // code here
        char c[]=A.toCharArray();
        int cnt[][]=new int[26][2];
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<c.length;i++)
        {
            cnt[c[i]-'a'][0]++;
            cnt[c[i]-'a'][1]=i;
            int q=-1;
            int mn=Integer.MAX_VALUE;
            for(int j=0;j<26;j++)
            {
                if(cnt[j][0]==1 && cnt[j][1]<mn)
                {
                    mn=cnt[j][1];
                    q=j;
                }
            }
            if(q==-1)
                sb.append("#");
            else
                sb.append((char)(q+'a'));
        }
        return sb.toString();
    }
}