import org.junit.Test;

public class jianzhi_05 {
    @Test
    public void replaceSpace() {
        String s ="We are happy.";
        int count = 0; // 统计空格的个数
        char[] arr = s.toCharArray();
        int sOldSize = arr.length;
        System.out.println(sOldSize);
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == ' ') {
                count++;
            }
        }
        // 扩充字符串s的大小，也就是每个空格替换成"%20"之后的大小
        char[] array = new char[arr.length+count*2];
        for (int i = 0; i < sOldSize; i++) {
            array[i]=arr[i];
        }
        int sNewSize = array.length;
        // 从后先前将空格替换为"%20"
        for (int i = sNewSize - 1, j = sOldSize - 1; j < i; i--, j--) {
            if (array[j] != ' ') {
                array[i] = array[j];
            } else {
                array[i] = '0';
                array[i - 1] = '2';
                array[i - 2] = '%';
                i -= 2;
            }
        }
        String s1 = String.valueOf(array);
        System.out.println(s1);
        //return s1;
    }

}
