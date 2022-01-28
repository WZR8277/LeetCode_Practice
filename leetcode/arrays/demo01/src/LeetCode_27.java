import static java.util.Arrays.sort;

public class LeetCode_27 {
    public int removeElement(int[] nums, int val ){

        int slowIndex = 0;
        for (int fastIndex = 0; fastIndex < nums.length; fastIndex++) {
            if (val != nums[fastIndex]) {
                nums[slowIndex++] = nums[fastIndex];
            }
        }
        return slowIndex;
    }
}
