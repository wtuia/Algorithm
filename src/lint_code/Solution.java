package lint_code;

import java.util.Arrays;
import java.util.List;

public class Solution {

    private int a;

    public Solution() {
    }

    public Solution(int a) {
        this.a = a;
    }

    @Override
    public String toString() {
        return "Solution{" +
                "a=" + a +
                '}';
    }

    public void setA(int a) {
        this.a = a;
    }

    private long multiplier(List<Integer> nums, int index, long prevMulti) {
        for (int i = index + 1, len = nums.size(); i < len; i++) {
            prevMulti *= nums.get(i);
        }
        return prevMulti;
    }

    static void swap(byte[] a) {
        a[0] = 1;
    }

    public static void main(String[] args) {
        int[] a = {2,2,2};
        String s = "222";
        byte[] bytes = s.getBytes();
        bytes[0] = 1;
        System.out.println(s);
    }


    public int singleNumberII(int[] A) {
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A.length; j++) {

            }
        }
        return 0;
    }

}
