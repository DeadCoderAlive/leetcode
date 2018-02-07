/**
 * Created by srinivaz on 2/6/18.
 */
public class TrappingRainWater {

    public static void main(String args[]){
        System.out.println(trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }

    public static int trap(int[] height) {
        int leftMax = 0;
        int rightMax = 0;
        int left = 0;
        int right = height.length-1;
        int count = 0;
        for(int i=0;i<height.length;i++){
            if(right <= i) {
                right = height.length-1;
                rightMax = 0;
            }
            while (left < i){
                if(height[left] > leftMax) leftMax = height[left];
                left++;
            }
            while(right > i) {
                if(height[right] > rightMax) rightMax = height[right];
                right--;
            }
            int currentCount = Math.min(leftMax,rightMax) - height[i];
            if(currentCount > 0) count+=currentCount;
        }
        return count;
    }
}
