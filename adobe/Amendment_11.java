// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*; 

class Amendment_11{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            
            
            // input n array elements
            String s = read.readLine();

            Solution ob = new Solution();
        
            System.out.println(ob.amendSentence(s));
        }
    } 
} // } Driver Code Ends


//User function Template for Java

 class Solution{
    public String amendSentence(String s){
        //code here
       int n = s.length ();
    	String res = "";
    	
    	// making the first character uppercase
    	if (s.charAt(0) >= 'A' && s.charAt(0) <= 'Z')
    		res += (char)(s.charAt(0)+32);
    	else
    		res += s.charAt(0);
        
    	for (int i = 1; i < n; ++i)
    	{
    	    // if the character is lowercase, we append it as it is.
    		if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z')
    			res += s.charAt(i);
    		
    		// if it's uppercase, we append a space and the lowercase version of that character.
    		else
    		{
    			res += " ";
    			res += (char)(s.charAt(i)+32);
    		}
    	}
    	return res;
    }
}

