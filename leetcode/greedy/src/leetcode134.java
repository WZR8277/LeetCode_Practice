public class leetcode134 {
    class Solution {
 //    https://mp.weixin.qq.com/s?__biz=MzAxODQxMDM0Mw==&mid=2247491696&idx=1&sn=f3ddc1f4a7e07e4184aa08f295c7e02c&chksm=9bd41e78aca3976eb91901293801de23ec94923666806382ff694591c728edaa4897f20f6480&scene=178&cur_album_id=1318896187793260544#rd
        public int canCompleteCircuit(int[] gas, int[] cost) {
            int n = gas.length;
            int sum = 0;
            for(int i = 0;i < n;i++){
                sum += gas[i] - cost[i];
            }

            if(sum < 0){
                return -1;
            }
/*            用贪心思路解决这道题的关键在于以下这个结论：

            如果选择站点i作为起点「恰好」无法走到站点j，那么i和j中间的任意站点k都不可能作为起点。

            比如说，如果从站点1出发，走到站点5时油箱中的油量「恰好」减到了负数，那么说明站点1「恰好」无法到达站点5；那么你从站点2,3,4任意一个站点出发都无法到达5，因为到达站点5时油箱的油量也必然被减到负数。

            如何证明这个结论？

            假设tank记录当前油箱中的油量，如果从站点i出发（tank = 0），走到j时恰好出现tank < 0的情况，那说明走到i, j之间的任意站点k时都满足tank > 0，对吧。

            如果把k作为起点的话，相当于在站点k时tank = 0，那走到j时必然有tank < 0，也就是说k肯定不能是起点。

            拜托，从i出发走到k好歹tank > 0，都无法达到j，现在你还让tank = 0了，那更不可能走到j了对吧。*/
            int currentGas = 0;
            int start = 0;
            for(int i = 0;i < n;i++){
                currentGas += gas[i] - cost[i];
                if(currentGas < 0){
                    currentGas = 0;//重新更新 从i+1开始尝试 因为之前的j到i都不可能了
                    start = i + 1;
                }
            }
            return start;
        }
    }

}
