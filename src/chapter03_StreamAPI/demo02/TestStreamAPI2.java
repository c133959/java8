package chapter03_StreamAPI.demo02;

import chapter01_lambda.demo02.Employee;
import org.junit.Test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

/**
 * 中间操作可以连接起来形成一个流水线，
 * 除非流水线上触发终止操作，否则中间操作不会执行任何的处理
 * 而在终止操作时一次性全部处理，称为“惰性求值”
 */
public class TestStreamAPI2 {

    /*
     * 中间操作：
     * filter:接受Lambda，从流中排出某些元素。
     * limit:截断流，使其元素不超过给定数量
     * skip:跳过元素，返回一个扔掉了前n个元素的流。若流中元素不足n个，则返回一个空流。与Limit(n)互补
     * distinct:筛选，通过流所生成元素的hashCode()和equals()去除重复元素
     */
    public static List<Employee> employeeList = Arrays.asList(
            new Employee("zhangsan", 18, 9999.99),
            new Employee("lisi", 36, 11111.11),
            new Employee("wangwu", 35, 5555.99),
            new Employee("zhaoliu", 16, 66666.99),
            new Employee("tianqi", 8, 2229.99),
            new Employee("tianqi", 8, 2229.99),
            new Employee("tianqi", 8, 2229.99),
            new Employee("tianqi", 8, 2229.99)
    );


    // 内部迭代：迭代操作由Stream API 完成
    @Test
    public void test1(){
        Stream<Employee> employeeStream = employeeList.stream()
                .filter((e) -> {
                    System.out.println("Stream API 的中间操作");// 在没有写终止操作时，是不执行此段代码的
                    return e.getAge() > 35;
                });
        // 以上为中间操作，不会出结果

        // 终止操作，一次性执行全部内容——惰性求值
        employeeStream.forEach(System.out::println);

    }

    //外部迭代
    @Test
    public void test2(){
        Iterator<Employee> iterator = employeeList.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }


    @Test
    public void test3(){
        employeeList.stream()
                .filter((e) -> {
                    System.out.println("短路！");
                    return e.getSalary() > 5000;
                })
                .limit(2)// 短路，一旦发现两条满足条件的数据，就不再继续执行迭代
                .forEach(System.out::println);
    }

    @Test
    public void test4(){
        employeeList.stream()
                .filter(e -> e.getSalary() > 30)
                .distinct()
                .forEach(System.out::println);
    }

}
