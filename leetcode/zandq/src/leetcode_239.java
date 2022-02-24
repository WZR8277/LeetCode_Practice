import java.util.Deque;
import java.util.LinkedList;
/*单调队列也可以存值，题解中存的是下标。
如果存值的话，每次只有新元素 大于 队列尾部的元素时，才去移除队列尾部的元素
窗口左侧移出去的元素如果等于队列头部的元素，则removeFirst。
举个例子： "543321" ，k=3

队列存值的情况下，如果不将两个3都加入，当第一个3被移出时，会导致321的最大值变为2，因为3已经被移出了，因此存值的话，需要新的元素大于队列尾部元素再去移除队列尾部的元素。
队列存下标的情况下，就可以只存一个3（存第二个），因为通过下标就能判断出移出的是第一个3还是第二个3。*/
public class leetcode_239 {

    class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            int[] res = new int[nums.length - k + 1];
            Deque<Integer> deque = new LinkedList<>();
            for (int i = 0; i < nums.length; i++) {
                while (!deque.isEmpty() && deque.peekLast() < nums[i]) {//注意：此处是小于号
                    deque.removeLast();
                }
                deque.addLast(nums[i]);
                if (i >= k && nums[i - k] == deque.peekFirst()) {
                    deque.removeFirst();
                }
                if (i >= k - 1) {
                    res[i - k + 1] = deque.peekFirst();
                }
            }
            return res;
        }
    }

}
