import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
//https://leetcode-cn.com/problems/permutations/solution/quan-pai-lie-by-leetcode-solution-2/
public class leetcode46 {
    class Solution {
        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> res = new ArrayList<List<Integer>>();

            List<Integer> output = new ArrayList<Integer>();
            for (int num : nums) {
                output.add(num);
            }

            int n = nums.length;
            backtrack(n, output, res, 0);
            return res;
        }

        public void backtrack(int n, List<Integer> output, List<List<Integer>> res, int first) {
            // 所有数都填完了
            if (first == n) {
                res.add(new ArrayList<Integer>(output));
            }
            for (int i = first; i < n; i++) {
                //注意i=first 0-first-1为已经填好位置的数组 这个循环遍历的是同一个位置的所有可能
                // 后续需要添加first-n的位置 而这部分都是没有被填过的
                // 动态维护数组
                Collections.swap(output, first, i);
                // 继续递归填下一个数
                backtrack(n, output, res, first + 1);
                // 撤销操作,回溯，回溯是因为上一节点 是父节点是一致的 还有其他情况
                Collections.swap(output, first, i);
            }
        }
    }
}
