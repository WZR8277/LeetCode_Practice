import java.util.ArrayList;
import java.util.List;

public class leetcode77 {
    class Solution {
        List<Integer> temp = new ArrayList<Integer>();
        List<List<Integer>> ans = new ArrayList<List<Integer>>();

        public List<List<Integer>> combine(int n, int k) {
            dfs(1, n, k);
            return ans;
        }

        public void dfs(int cur, int n, int k) {
            // 剪枝：temp 长度加上区间 [cur, n] 的长度小于 k，不可能构造出长度为 k 的 temp
            if (temp.size() + (n - cur + 1) < k) {
                return;
            }
            // 记录合法的答案
            if (temp.size() == k) {
                ans.add(new ArrayList<Integer>(temp));
                return;
            }
            // 考虑选择当前位置 dfs算法cur相当于层数 每次节点都有选与不选两个状态 每次都是确定该位0 1状态
            //按编码表述比如 11111 01111（4个） 00011（2个）.... 00000等全部被遍历到
            temp.add(cur);//1
            dfs(cur + 1, n, k);
            temp.remove(temp.size() - 1);//0
            // 考虑不选择当前位置
            dfs(cur + 1, n, k);
        }
    }

}
