package chapter02_lambda.demo01;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * java8 内置的四大核心函数式接口
 * Consumer
 * Supplier
 * Function
 * Predicate
 */
public class test {

    // Consumer<T> 消费型接口
    @Test
    public void test1(){
        happy(100L, (m) -> System.out.println("本次消费：" + m + "元"));
    }

    public void happy(double money, Consumer<Double> consumer) {
        consumer.accept(money);
    }

    // Supplier<T> 供给型接口
    @Test
    public void test2(){
        List<Integer> numList = getNumList(3, () -> (int)(Math.random() * 50));
        System.out.println(numList);
    }
    //需求：产生指定个数的整数，并放入集合中
    public List<Integer> getNumList(int num, Supplier<Integer> supplier) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            list.add(supplier.get());
        }
        return list;
    }

    // Function<T, R> 函数型接口

    // 需求：用于处理字符串
    @Test
    public void test3(){
        String s = "\t\t\t   这是测试字符串  ";
        String strHandler = strHandler(s, str -> str.trim());
        System.out.println("处理后的值：" + strHandler);

        System.out.println("-------------");
        String lowerStr = "abcdefg";
        String strHandler1 = strHandler(lowerStr, str -> str.toUpperCase());
        System.out.println("处理后的值：" + strHandler1);
    }
    public String strHandler(String str, Function<String, String> function) {
        return function.apply(str);
    }

    // Predicate<T> 断言型接口
    @Test
    public void test4(){
        List<String> list = Arrays.asList("Hello", "atguigu", "lambda", "aaa");
        List<String> stringList = filterStr(list, (str) -> str.charAt(0) == 'a');
        System.out.println(stringList);
    }
    // 需求：将满足条件的字符添加到集合中去
    public List<String> filterStr(List<String> stringList, Predicate<String> predicate) {
        List<String> strList = new ArrayList<>();

        for (String str : stringList) {
            if (predicate.test(str)) {
                strList.add(str);
            }
        }
        return strList;
    }


}
