import java.util.*;
class KthLargest_13{
  public static void main(String args[])
  {
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    int k=sc.nextInt();
    int nums[]=new int[n];
    
    Solution ob=new Solution();
    System.out.println(ob.findKthLargest(nums,k));
  }
}
class Solution {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length-k];
    }
}