// { Driver Code Starts
import java.util.*;
import java.io.*;
class SortedSubsequence_7 {
    public static boolean isSubSequence(ArrayList<Integer> v1, ArrayList<Integer> v2,
                                 int n, int m) {

        if (m == 0) return true;
        if (n == 0) return false;

        if (v1.get(n - 1).equals(v2.get(m - 1)))
            return isSubSequence(v1, v2, n - 1, m - 1);

        return isSubSequence(v1, v2, n - 1, m);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().trim().split(" ");
            ArrayList<Integer> a = new ArrayList<Integer>();
            for (int i = 0; i < n; i++) {
                a.add(Integer.parseInt(str[i]));
            }
            Solution g = new Solution();
            ArrayList<Integer> res = g.find3Numbers(a, n);

            // wrong format output
            if (!res.isEmpty() && res.size() != 3) {
                System.out.println(-1);
            }

            if (res.isEmpty()) {
                System.out.println(0);
            } else if ((res.get(0) < res.get(1)) && (res.get(1) < res.get(2)) &&
                       isSubSequence(a, res, n, res.size())) {
                System.out.println(1);
            } else {
                System.out.println(-1);
            }
        }
    }
}// } Driver Code Ends


/*Complete the function below*/

class Solution {
    ArrayList<Integer> find3Numbers(ArrayList<Integer> arr, int n) {
        // add code here.
        ArrayList<Integer> al=new ArrayList<>();
        int max = n - 1;
 
        // Index of minimum element
        // from left side
        int min = 0;
        int i;
 
        
        int[] smaller = new int[n];
 
        // first entry will always be -1
        smaller[0] = -1;
        for (i = 1; i < n; i++) {
            if (arr.get(i) <= arr.get(min)){
                min = i;
                smaller[i] = -1;
            }
            else
                smaller[i] = min;
        }
 
       
        int[] greater = new int[n];
 
        // last entry will always be -1
        greater[n - 1] = -1;
        for (i = n - 2; i >= 0; i--) {
            if (arr.get(i)>= arr.get(max)) {
                max = i;
                greater[i] = -1;
            }
            else
                greater[i] = max;
        }
 
        
        for (i = 0; i < n; i++) {
            if (
                smaller[i] != -1 && greater[i] != -1) {
                al.add(arr.get(smaller[i]));
                al.add(arr.get(i));
                al.add(arr.get(greater[i]));
                return al;
            }
        }
 
        
        return al;
        
    }
}
