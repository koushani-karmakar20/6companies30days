import java.util.*;
class ColoredPieces_3 {
  public static void main(String[] args) {
    //System.out.println("Hello world!");
    Scanner sc=new Scanner(System.in);
    String colors=sc.next();
    Solution obj=new Solution();
    System.out.println(obj.winnerOfGame(colors));
  }}
  class Solution {
    public boolean winnerOfGame(String colors) {
        int a=0,b=0;
        for(int i=1;i<colors.length()-1;i++)
        {
            if(colors.charAt(i)==colors.charAt(i-1)&&colors.charAt(i)==colors.charAt(i+1))
            {   
                if(colors.charAt(i)=='A')
                    a++;
                else
                    b++;
            }
        }
        return a>b;
    }
}
