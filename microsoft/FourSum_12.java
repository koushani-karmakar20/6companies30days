import java.io.*;
import java.util.*;

class FourSum_12 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());

        while (tc-- > 0) {
            String[] nk = br.readLine().trim().split(" ");
            int n = Integer.parseInt(nk[0]);
            int k = Integer.parseInt(nk[1]);

            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            Solution sln = new Solution();
            ArrayList<ArrayList<Integer>> ans = sln.fourSum(a, k);
            for (ArrayList<Integer> v : ans) {
                for (int u : v) {
                    System.out.print(u + " ");
                }
                System.out.print("$");
            }
            if (ans.isEmpty()) {
                System.out.print(-1);
            }
            System.out.println();
        }
    }
}// } Driver Code Ends




class Pair{
    int first,second;
    Pair(int first,int second){
        this.first=first;
        this.second=second;
    }
}

class Solution {
    public ArrayList<ArrayList<Integer>> fourSum(int[] a, int k) {
        // code here
         int n = a.length;
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        if (n < 4) return ans;

        Arrays.sort(a);
        for (int i = 0; i < n - 3; i++) {
           

            for (int j = i + 1; j < n - 2; ++j) {
                
                int left = j + 1;
                int right = n - 1;
                while (left < right) {
                    
                    int sum = a[i] + a[j] + a[left] + a[right];
                    if (sum == k) {
                        // add to answer
                        ArrayList<Integer> al=new ArrayList<>();
                        al.add(a[i]);
                        al.add(a[j]);
                        al.add(a[left]);
                        al.add(a[right]);
                        if(!ans.contains(al))
                        ans.add(al);
                        left++;
                        right--;

                        
                    } else if (sum > k) {
                        right--;
                    } else {
                        left++;
                    }
                }
            }
        }
        return ans;
    }
}