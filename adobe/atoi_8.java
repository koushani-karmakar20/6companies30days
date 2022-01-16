// { Driver Code Starts
//Initial template for JAVA

import java.util.Scanner;

class atoi_8
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		sc.nextLine();
		while(t>0)
		{
			String str = sc.nextLine();
			
			Solution obj = new Solution();
			System.out.println(obj.atoi(str));
		t--;
		}
	}
}// } Driver Code Ends


//User function template for JAVA

/*You are required to complete this method */
class Solution
{
    int atoi(String str) {
	// Your code here
	for(int i=0;i<str.length();i++)
	{
	    char c=str.charAt(i);
	    if((c>='a'&&c<='z')||(c>='A'&&c<='Z'))
	    return -1;
	}int res=0;
	boolean minus=false;
	if(str.charAt(0)=='-')
	{minus=true;str=str.substring(1);}
	for(int i=0;i<str.length();i++)
	{int c=str.charAt(i)-'0';
	    res=res*10+c;
	}
	if(minus)return (0-res);
	return res;
    }
}
