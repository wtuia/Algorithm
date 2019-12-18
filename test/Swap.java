import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class Swap {


    private   final int a;

    public Swap(int a) {
        this.a = a;
    }

    public static void main(String[] args) {
        Swap s = new Swap(1);
    }

    public static void swap(Class clz,  Object num1, Object num2) {
        try {
            Object temp = num1.getClass().getConstructor(String.class).newInstance(String.valueOf(num1));
            Field field = clz.getDeclaredField("value");
            field.setAccessible(true);// 开启更改private属性
            field.set(num1, num2);
            field.set(num2, temp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static <T> void swap(T num1, T num2) {
        try {
            Object temp = num1.getClass().getConstructor(String.class).newInstance(String.valueOf(num1));
            Field field = num1.getClass().getDeclaredField("value");
            field.setAccessible(true);// 开启更改private属性
            field.set(num1, num2);
            field.set(num2, temp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
