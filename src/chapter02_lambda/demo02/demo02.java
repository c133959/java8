package chapter02_lambda.demo02;

import chapter01_lambda.demo02.Employee;
import org.junit.Test;

import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 构造器引用
 * 格式：
 * ClassName::new
 * 注意:
 *  需要调用的构造器参数列表需要与函数式接口中抽象方法的参数列表保持一致
 */
public class demo02 {

    @Test
    public void test(){
        Supplier<Employee> sup = () -> new Employee();

        Supplier<Employee> sup2 = Employee::new;
    }

    public void test1(){
        Function<Integer, Employee> fun = (x) -> new Employee(x);

        Function<Integer, Employee> fun2 = Employee::new;
    }

}
