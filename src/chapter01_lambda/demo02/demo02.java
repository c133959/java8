package chapter01_lambda.demo02;

import chapter01_lambda.demo01;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: demo02
 * @Description: 优化员工查询方法
 * @Author sunsl
 * @Date 2022/4/3 20:48
 * @Version 1.0
 */
public class demo02 {

    /**
     * 优化方式1：设计模式思想——策略模式,即传递什么策略，就按什么策略过滤
     * @param list 员工数组
     * @param mp 过滤器（可任意指定规则
     * @return employees 筛选出的员工
     */
    public  List<Employee> filterEmployee(List<Employee> list, MyPredicate<Employee> mp) {
        // 所有过滤均可使用该方法，避免代码冗余，仅需要更改传入的过滤器对象实例即可
        List<Employee> emps = new ArrayList<>();

        for (Employee emp : list) {
            if (mp.test(emp)) {
                // 根据筛选条件
                emps.add(emp);
            }
        }
        return emps;
    }
    @Test
    public void test01(){
        FilterEmployeeByAge filter = new FilterEmployeeByAge();
        List<Employee> employees = filterEmployee(demo01.employeeList, filter);
        System.out.println("年龄大于35岁的员工信息：");
        for (Employee employee : employees) {
            System.out.println(employee.getName());
        }

        System.out.println("__________________________________");

        List<Employee> employees1 = filterEmployee(demo01.employeeList, new FilterEmployeeBySalary());
        System.out.println("薪水大于5000的员工信息：");
        for (Employee employee : employees1) {
            System.out.println(employee.getName());
        }
    }

    /**
     * 优化方式二：匿名内部类
     */
    @Test
    public void test5() {
        List<Employee> employees = filterEmployee(demo01.employeeList, new MyPredicate<Employee>() {
            @Override
            // 不用每次都重新new一个类，使用匿名内部类实现即可
            public boolean test(Employee employee) {
                return employee.getAge() >= 35;
            }
        });
    }

    /**
     * 优化方式三：lambda表达式
     */
    @Test
    public void test6(){
        List<Employee> employees = filterEmployee(demo01.employeeList, (employee) -> employee.getAge() >= 35);
        employees.forEach(System.out::println);
    }

    /**
     * 优化方式四：Stream API
     */
    @Test
    public void test7(){
        demo01.employeeList.stream()
                .filter((e) -> e.getAge() >= 35)//筛选条件
                .limit(2)//限制选择前几条
                .map(Employee::getName)//输出某一类数据
                .forEach(System.out::println);
    }

}
