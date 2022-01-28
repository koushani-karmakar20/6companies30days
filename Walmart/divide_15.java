import java.util.*;
class divide_15{
  public static void main(String args[]){
    Scanner sc=new Scanner(System.in);
    int divisor=sc.nextInt();
    int dividend=sc.nextInt();
    Solution ob=new Solution();
    System.out.println(ob.divide(dividend,divisor));
  }

}
class Solution{
public int divide(int A, int B) {
        if (A == 1 << 31 && B == -1) return (1 << 31) - 1;
        int a = Math.abs(A), b = Math.abs(B), res = 0, x = 0;
        while (a - b >= 0) {
            for (x = 0; a - (b << x << 1) >= 0; x++);
            res += 1 << x;
            a -= b << x;
        }
        return (A > 0) == (B > 0) ? res : -res;
    }
}