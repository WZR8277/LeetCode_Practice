
import static java.util.Arrays.sort;

public class Demo01Array {
    public int searchInsert(int[] nums, int target) {
        sort(nums);
        int left=0;
        int right=nums.length-1;
        while(left<=right){
            if(target<nums[(left+right)/2]){
                right=((left+right) /2)-1;
            } else if (target>nums[(left+right)/2]){
                    left=((left+right) /2) +1;
            }else {
                return (left + right) / 2;
            }
        }
        return right+1;
    }
}
