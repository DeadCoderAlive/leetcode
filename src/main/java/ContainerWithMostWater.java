/**
 * Created by srinivaz on 2/14/18.
 */
public class ContainerWithMostWater {

    public  int maxArea(int[] height){
        int max = 0;
        int left = 0;
        int right = height.length-1;
        int maxArea = 0;
        while (left < right){
            //can be written as
            //maxArea = Math.max(maxArea,Math.min(height[left],height[right]*(right-left)))
            int area = Math.min(height[left],height[right])*(right-left);
            if(area>maxArea) maxArea = area;
            //just see which is greater no need to store prevviuos max state using max
            //just if(height[left] > height[right]) should suffice
            if(height[left] >= height[right] && height[left] >= max){
                max=height[left];
                right--;
            }
            else {
                max=height[right];
                left--;
            }
        }
        return maxArea;
    }
}
