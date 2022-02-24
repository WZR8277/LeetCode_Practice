import java.util.ArrayList;
import java.util.List;

public class leetcode501 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public class Solution {
        List<Integer> answer = new ArrayList<Integer>();
        int base, count, maxCount;

        public int[] findMode(TreeNode root) {
            dfs(root);
            int[] mode = new int[answer.size()];
            for (int i = 0; i < answer.size(); ++i) {
                mode[i] = answer.get(i);
            }
            return mode;
        }

        public void dfs(TreeNode o) {
            if (o == null) {
                return;
            }
            dfs(o.left);
            update(o.val);
            dfs(o.right);
            //保证遍历顺序\{ -1, 0, 0, 1, 2, 2 \}
        }

        public void update(int x) {
            if (x == base) {//base是当前数
                ++count;
            } else {
                count = 1;//由中序遍历特点知道 众数都连续出现 否则下个数一定第一次出现
                base = x;
            }
            if (count == maxCount) {//众数即使多个 count也一定都相等 否则下个if 之前的都不是众数
                answer.add(base);
            }
            if (count > maxCount) {
                maxCount = count;
                answer.clear();
                answer.add(base);
            }
        }
    }

}
