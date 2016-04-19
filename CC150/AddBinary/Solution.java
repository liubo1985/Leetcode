package CC150.AddBinary;

/**
 * Created by bliu on 4/18/2016.
 */

public class Solution {
    public String addBinary(String a, String b) {
        //find the longer string, keep it in string a
        if(a.length() < b.length()){
            return addBinary(b, a);
        }
        char[] array_a = a.toCharArray();
        char[] array_b = b.toCharArray();
        //int length = array_a.length >= array_b.length? array_a.length + 1 : array_b.length;
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int i = a.length() - 1;
        int j = b.length() - 1;
        //add each digit together untill array_b is end
        while(i >= 0 && j >= 0){
            int sum = array_a[i] - '0' + array_b[j] - '0' + carry;
            carry = sum >> 1;
            sb.insert(0, sum % 2);
            i--;
            j--;
        }
        //add the remaining of array_a
        while(i >= 0 ){
            int sum = array_a[i] - '0' + carry;
            carry = sum >> 1;
            sb.insert(0, sum % 2);
            i--;
        }
        //if has carry, add it
        if(carry == 1){
            sb.insert(0, 1);
        }
        return sb.toString();


    }
}
