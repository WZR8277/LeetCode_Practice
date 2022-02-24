public class jianzhi_58_2 {
    public String reverseLeftWords(String s,int n){
        char[] arr = s.toCharArray();
        reverse(arr,0, n-1);
        reverse(arr, n, arr.length-1);
        reverse(arr,0, arr.length-1);
        s = new String(arr);
        return s;
    }
    public void reverse(char[] arr, int left, int right) {
        while (left < right) {
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
}
