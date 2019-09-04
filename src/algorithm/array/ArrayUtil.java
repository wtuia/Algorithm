package algorithm.array;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

/**
 * 数组工具类，
 *  添加删除，不直接移动元素，操作更快，执行操作之后
 *  1，数组删除的标记实现
 *  2，随机添加
 *  3，排序
 *  4, 扩容给
 */
public class ArrayUtil {

    private int[] delEleArray;
    private int delIndex = 0;

    private static final Logger logger = LoggerFactory.getLogger(ArrayUtil.class);


    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        ArrayUtil arrayUtil = new ArrayUtil();
        // 删除
        arrayUtil.remove(arr,3);
        arrayUtil.remove(arr,2);

        // 添加
        arrayUtil.add(arr,10);
        arrayUtil.add(arr,9);
        arr = arrayUtil.add(arr,11, true);
        logger.info(Arrays.toString(arr));

        // 扩容
       arr = arrayUtil.resize(arr,12);
       logger.info(Arrays.toString(arr));
    }

    /**
     * 标记删除元素
     */
    private void remove(int[] arr, int val) {
        int len = arr.length;
        if (delEleArray == null) {
            delEleArray = new int[len];
        }
        for (int i = 0; i < len ; i++) {
            if (arr[i] == val) {
                arr[i] = 0;
                delEleArray[delIndex++] = i;
            }
        }
    }

    /**
     * 添加，默认关闭追加
     */
    private void add(int[] arr, int val) {
       arr = add(arr, val, false);
    }



    /**
     * 添加，手动设置追加模式，关闭排序
     * @param isAppend 是否追加
     */
    private int[] add(int[] arr, int val, boolean isAppend) {
       return add(arr, val, isAppend, false);
    }

    /**
     * 添加
     * @param isAppend 是否追加
     * @param isSort 是否排序
     */
    private int[] add(int[] arr, int val, boolean isAppend, boolean isSort) {
        for (int i = 0, len = delEleArray.length; i< len ; i++ ){
            if (delEleArray[i] != 0) {
                arr[delEleArray[i]] = val;
                delEleArray[i] = 0;
                return arr;
            }
        }
        if(!isAppend) {
            logger.error("数组空间已满，数组长度为{}，无法在下标{}上新增值{}",arr.length, arr.length, val);
        }else {
           arr =  append(arr, val);
        }
        if(isSort){
            sort(arr);
        }
        return arr;
    }

    /**
     * 执行插入时，若超出原长度，则追加
     * 排序默认关闭
     */
    private int[] append(int[] arr, int val) {
        return append(arr, val ,false);
    }
    private int[] append(int[] arr, int val, boolean isSort) {
        int len = arr.length;
        int[] newArr = new int[len + 1];
        System.arraycopy(arr, 0 ,newArr, 0, len);
        newArr[len] = val;
        if(isSort){
            sort(arr);
        }
        return newArr;
    }

    private int[] resize(int[] arr, int length) {
        int len = arr.length;
        if (length <= len) {
            return arr;
        }
        int[] newArr = new int[length];
        int[] delNewArr = new int[length];
        System.arraycopy(arr, 0, newArr, 0, len);
        System.arraycopy(delEleArray, 0 ,delNewArr, 0, delIndex);
        delEleArray = delNewArr;
        return newArr;
    }


    /**
     * 有序化，插入排序，原地且稳定
     */
    private void sort(int[] arr) {
        int len = arr.length, val, j;
        for (int i = 1; i < len ; i++) {
            val = arr[i];
            j = i - 1;
            for (; j >= 0 ; j--) {
                // 0 后置
                // 若val == 0, 即：插入的值为0，默认为最大，不插入，跳过
                // 若a[j] == 0 ,即比较的值为0， 默认比较的值为最大，将插入的值插入此处，此数后移
                if ((arr[j] > val || arr[j] == 0) && val != 0) {
                    arr[j+1] = arr[j];
                }else {
                    break;
                }
            }
            // j= 0 时，执行了一次j--,此处得到的j为-1
            arr[j + 1] = val;
        }
    }

}
