/**
 * Created by srinivaz on 2/7/18.
 */
public class SingleNumber {

    //xor a^a = 0, a^b^a = b
    public int singleNumber(int[] nums) {
        int bit = nums[0];
        for(int i=1;i<nums.length;i++){
            bit^=nums[i];
        }
        return bit;
    }
}
