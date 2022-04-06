package chapter02_lambda.demo02;

import org.junit.Test;

import java.util.function.Function;

/**
 * 数组引用：
 *  Type::new;
 */
public class demo03 {

    @Test
    public void test(){
        Function<Integer, String[]> func = (x) -> new String[x];

        Function<Integer, String[]> func2 = String[]::new;
    }

}
