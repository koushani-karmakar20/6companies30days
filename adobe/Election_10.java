// { Driver Code Starts
import java.io.*;
import java.util.*;

class Election_10
{
    public static void main (String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            String arr[] = new String[n];
            
            for(int i = 0; i < n; i++)
                arr[i] = sc.next();
            
            Solution obj = new Solution();    
            String result[] = obj.winner(arr, n);
            System.out.println(result[0] + " " + result[1]);
            
           
        }
        
    }
}
// } Driver Code Ends


//User function Template for Java


class Solution
{
    //Function to return the name of candidate that received maximum votes.
    public static String[] winner(String arr[], int n)
    {
        // add your code
        TreeMap<String, Integer> mp = new TreeMap<>();
        
        //storing the frequency of names in the map.
        for(int i = 0; i < n; i++)
        {
            String key = arr[i];
            if(mp.containsKey(key) == true)
            {
                int freq = mp.get(key);
                freq++;
                mp.put(key, freq);
            }else
            {
                mp.put(key, 1);
            }
        }
        
        int maxx = 0; 
        String answer = ""; 
        
        //iterating through the map to find the name with highest frequency.
        for (Map.Entry<String,Integer> entry : mp.entrySet()) 
        { 
            String key  = entry.getKey(); 
            Integer val = entry.getValue();
            
            if (val > maxx) 
            { 
                maxx = val; 
                answer = key; 
            } 
            
        } 
        
        //storing name with highest votes and the number of votes in a list.
        String result[] = {answer,maxx+""};
        
        //returning the list.
        return result;
    }
}

