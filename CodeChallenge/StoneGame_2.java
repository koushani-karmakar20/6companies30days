import java.util.*;
class StoneGame{
  public static void main(String args[]){
    Scanner sc=new Scanner(System.in);
    Solution ob=new Solution();
    int b=sc.nextInt();
    int piles[]=new int[b];
    for(int i=0;i<b;i++)
    piles[b]=sc.nextInt();
    System.out.println(ob.stoneGame(piles));

  }
}
class Solution {
    public boolean stoneGame(int[] piles) {
        return true;}
}