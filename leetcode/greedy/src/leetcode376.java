public class leetcode376 {
    class Solution {
        public int wiggleMaxLength(int[] nums) {
            int n = nums.length;
            if (n < 2) {
                return n;
            }
            int prevdiff = nums[1] - nums[0];//处理前端元素
            int ret = prevdiff != 0 ? 2 : 1;//如果前两个不相等 一定一个为峰 一个为谷  若相等 取其中一个即可
            for (int i = 2; i < n; i++) {
                int diff = nums[i] - nums[i - 1];
                //如果出现了「峰」或「谷」，答案加一，并更新当前序列的上升下降趋势
                // 若没有则舍去 比如如果「过渡元素」在选择的序列中小于其两侧的元素，那么「谷」一定没有在选择的序列中出现
                // 我们可以将「过渡元素」替换成「谷」
                if ((diff > 0 && prevdiff <= 0) || (diff < 0 && prevdiff >= 0)) {
                    ret++;
                    prevdiff = diff;//只在此处更新趋势 相当于拼接子序列
                }
            }
            return ret;
        }
    }
}
