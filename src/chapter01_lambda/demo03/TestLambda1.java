package chapter01_lambda.demo03;

import org.junit.Test;

import java.util.Comparator;

/**
 * java8中引入了一个新的操作符 -> ，该操作符称为箭头操作符 或 Lambda操作符
 *
 * 箭头操作符将Lambda表达式拆成两部分：
 * 左侧：Lambda 表达式的参数列表
 * 右侧：Lambda表达式的所需要执行的功能，即Lambda 体
 * 语法格式1：无参数，无返回值
 */
public class TestLambda1 {

    @Test
    public void test1(){
        int num = 0;//jdk1.7前，必须是final
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello World!" + num);
            }
        };
        r.run();

        System.out.println("-------------------------");

        Runnable r2 = () -> System.out.println("Hello Lambda!");
        r2.run();
    }

    @Test
    public void test2(){
        Comparator<Integer> com = (x, y) -> {
            System.out.println("函数式接口");
            return Integer.compare(x,y);
        };
    }

    // 需求：使用函数式接口实现对数的运算
    @Test
    public void test3(){
        Integer operation = operation(3, (x) -> x * x);
        System.out.println("myFun: " + operation);

        System.out.println("----------------------------");

        Integer operation1 = operation(3, (x) -> x * 2);
        System.out.println("myFun: " + operation1);
    }
    // 定义运算的公共方法-策略模式
    public Integer operation(Integer num, MyFunc myFunc) {
        return myFunc.getValue(num);
    }

}
