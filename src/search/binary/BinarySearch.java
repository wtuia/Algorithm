package search.binary;

public class BinarySearch {

    public static void main(String[] args) {

        int index = 0;
        int num = 100_000_000;
        while (num > 10) {
            num = num >> 1;
            index++;
            System.out.println(num);
        }
        System.out.println();
        System.out.println(index);
    }


}
