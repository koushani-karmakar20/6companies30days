// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class PrereqTasks_2 {
	public static void main(String args[]) throws IOException
	{
	    Scanner sc = new Scanner(System.in);
	    int t = sc.nextInt();
		while(t>0)
		{
		    int N = sc.nextInt();
		    int P = sc.nextInt();
		    int prerequisites[][] = new int[P][2];
		    for(int i=0;i<P;i++)
		    {
		        for(int j=0;j<2;j++)
		        {
		            prerequisites[i][j] = sc.nextInt();
		        }
		    }
			Solution ob = new Solution();
			if(ob.isPossible(N,prerequisites))
			{
			    System.out.println("Yes");
			}
			else{
			    System.out.println("No");
			}
			t--;
		}
	}
	
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    public boolean isPossible(int N, int[][] prereq)
    {
        // Your Code goes here
        ArrayList<ArrayList<Integer>> graph=makeGraph(prereq,N);
        if(dfsUtil(graph,N))//contains cycle
        return false;
        return true;
        
        
        
    }
    boolean dfsUtil( ArrayList<ArrayList<Integer>> graph,int N)
    {
        boolean vis[]=new boolean[N];
        boolean dfsvis[]=new boolean[N];
        for(int i=0;i<N;i++)
        {
            if(!vis[i])
            {
                if(hasCycle(graph,vis,dfsvis,i))
                return true;
            }
        }
        return false;
        
    }
    boolean hasCycle( ArrayList<ArrayList<Integer>> graph,boolean vis[],boolean dfsvis[],int i)
    {
        vis[i]=true;
        dfsvis[i]=true;
        for(int j:graph.get(i))
        {
            if(vis[j]&&dfsvis[j])
            return true;
            else if(!vis[j])
            {
                if(hasCycle(graph,vis,dfsvis,j)==true)
                return true;
            }
        }
        //all adjacents of i has been visited
        dfsvis[i]=false;
        return false;
    }
    ArrayList<ArrayList<Integer>> makeGraph(int prereq[][],int N)
    {
        ArrayList<ArrayList<Integer>> graph=new ArrayList<>();
        for(int i=0;i<N;i++)
        graph.add(new ArrayList<>());
        for(int p[]:prereq)
        {
            graph.get(p[1]).add(p[0]);
        }
        return graph;
    }
   
}