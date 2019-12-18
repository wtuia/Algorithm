import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class Clz {

    private final int intValue;
    private final String str;
    private final char[] chars;



    public Clz(int intValue, String str, char[] chars) {
        this.intValue = intValue;
        this.str = str;
        this.chars = chars;
    }

    @Override
    public String toString() {
        return "Clz{" +
                "intValue=" + intValue +
                ", str='" + str + '\'' +
                ", chars=" + Arrays.toString(chars) +
                '}';
    }

    public static void main(String[] args) {
        char[] chars = "123".toCharArray();
        char[] newChar = "456".toCharArray();
        Clz clz = new Clz(1, "1", chars);
        Class c = clz.getClass();
        try {
            Field field = c.getDeclaredField("chars");
            field.setAccessible(true);// 开启更改private属性
            field.set(clz, newChar);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
        System.out.println(clz);
    }


}
