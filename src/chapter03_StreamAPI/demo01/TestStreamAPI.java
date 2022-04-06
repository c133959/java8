package chapter03_StreamAPI.demo01;

import chapter01_lambda.demo02.Employee;
import org.junit.Test;

import java.lang.reflect.Array;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * 1. 创建Stream
 *
 *    获取一个流
 *
 * 2. 中间操作
 *
 *    数据处理
 *
 * 3. 终止操作（终端操作）
 *
 *    执行中间操作，并产生结果
 */
public class TestStreamAPI {

    //1. 创建Stream
    @Test
    public void test1(){
        //1. 可以通过Collection 系列集合提供的stream() 或parallelStream()
        List<String> list = new ArrayList<>();
        Stream<String> stream = list.stream();

        //2. 可以通过Arrays 中的静态方法stream() 获取数组流
        Employee[] emps = new Employee[10];
        Stream<Employee> stream1 = Arrays.stream(emps);

        // 3. 可以通过Stream 类中的静态方法of()
        Stream<String> stream2 = Stream.of("aa", "bb", "cc");

        // 4. 创建无限流
        // 迭代
        Stream<Integer> stream3 = Stream.iterate(0, (x) -> x + 2);
        stream3.limit(10)
                .forEach(System.out::println);
        // 生成
        Stream.generate(()->Math.random())
                .limit(5)
                .forEach(System.out::println);

    }

}
