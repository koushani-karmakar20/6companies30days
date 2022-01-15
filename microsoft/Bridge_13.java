import java.util.*;
import java.io.*;
import java.lang.*;

class Bridge_13
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for(int i = 0; i < V+1; i++)
                list.add(i, new ArrayList<Integer>());
            for(int i = 0; i < E; i++)
            {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
                list.get(v).add(u);
            }
            int c = sc.nextInt();
            int d = sc.nextInt();
            
            Solution ob = new Solution();
            
            System.out.println(ob.isBridge(V,list,c,d));
        }
    }
}// } Driver Code Ends


// User function Template for Java

class Solution
{
    //Function to find if the given edge is a bridge in graph.
    static int isBridge(int V, ArrayList<ArrayList<Integer>> adj,int c,int d)
    {
        // code here
        int before=countComponents(adj,V);
        adj.get(c).remove(new Integer(d));
        adj.get(d).remove(new Integer(c));
        int after=countComponents(adj,V);
        if(after>before)
        return 1;
        return 0;
    }
    static int countComponents(ArrayList<ArrayList<Integer>> adj,int V)
    {
        boolean vis[]=new boolean[V];
        //dfsUtil(0,adj,vis);
        int component=0;
        for(int i=0;i<V;i++)
        {
            if(!vis[i])
            {
                component++;
                dfsUtil(i,adj,vis);
            }
        }
        return component;
    }
    static void dfsUtil(int i,ArrayList<ArrayList<Integer>> adj,boolean vis[])
    {
        vis[i]=true;
        for(int j:adj.get(i))
        {
            if(!vis[j])
            dfsUtil(j,adj,vis);
        }
    }
}