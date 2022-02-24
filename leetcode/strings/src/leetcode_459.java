import java.util.Arrays;

public class leetcode_459 {

    public boolean repeatedSubstringPattern(String s) {
        return kmp(s);
    }

    public boolean kmp(String pattern) {
        int n = pattern.length();
        int[] fail = new int[n];
        Arrays.fill(fail, -1);
        for (int i = 1; i < n; ++i) {
            int j = fail[i - 1];
            while (j != -1 && pattern.charAt(j + 1) != pattern.charAt(i)) {
                j = fail[j];
            }
            if (pattern.charAt(j + 1) == pattern.charAt(i)) {
                fail[i] = j + 1;
            }
        }
        return fail[n - 1] != -1 && n % (n - fail[n - 1] - 1) == 0;
    }//想象两个子串 原字符串是1前缀+后尾 或者2前头+后缀 2前移刚好和前缀重合 只需前头=后尾
    // 如果是题目描述字符串 后尾是len约束 就可递推每len(后尾）子串都各自相等 画图


}
