import java.util.*;
class RandomPoint_10{
  public static void main(String args[])
  {
    Scanner sc=new Scanner(System.in);
    double radius,x_center,y_center;
    
    radius=sc.nextDouble();
    x_center=sc.nextDouble();
    y_center=sc.nextDouble();
    Solution ob=new Solution(radius,x_center,y_center);
    double[] param_1 = obj.randPoint();
    System.out.println(Arrays.toString(param_1));

    }
}
class Solution {
double radius,x_center,y_center;
    public Solution(double radius, double x_center, double y_center) {
        this.radius=radius;
                                                                      this.x_center=x_center;
                                                                      this.y_center=y_center;
        
    }
    
    public double[] randPoint() {
        double dist=Math.sqrt(Math.random())*radius;
        double deg=Math.random()*2*Math.PI;
        double x=x_center+dist*Math.cos(deg);
        double y=y_center+dist*Math.sin(deg);
        return new double[]{x,y};
        
    }
}