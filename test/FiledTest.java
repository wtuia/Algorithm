import org.junit.Test;

import java.lang.reflect.Field;

public class FiledTest {
    @Test
    public void test() throws Exception {
       Integer a = 1;
       Integer b = 2;
       Integer c = 1;
       int d = 2;
       Integer f = 1;
        System.out.printf("a:%d, hash:%d%n", a, a.hashCode());
       swap(a, b);
        System.out.printf("a:%d, hash:%d%n", a, a.hashCode());
        System.out.println(c);
        System.out.println(c == d);
        System.out.println(f.intValue());

    }

    public static void swap(Integer num1,Integer num2){
        Integer temp = new Integer(num1);
        try {
            Field field = Integer.class.getDeclaredField("value");
            field.setAccessible(true);// 开启更改private属性
            field.set(num1, num2);
            field.set(num2, temp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
