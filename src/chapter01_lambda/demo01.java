package chapter01_lambda;

import chapter01_lambda.demo02.Employee;
import org.junit.Test;

import java.util.*;

public class demo01 {

    // 原来的匿名内部类
    @Test
    public void test01(){
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        };

        TreeSet<Integer> ts = new TreeSet<>(comparator);
    }

    // Lambda表达式
    public void test02(){
        Comparator<Integer> comparator = (o1, o2) -> Integer.compare(o1, o2);

        TreeSet<Integer> ts = new TreeSet<>(comparator);
    }
    // Lambda表达式优化
    public void test03(){
        Comparator<Integer> comparator = Integer::compare;

        TreeSet<Integer> ts = new TreeSet<>(comparator);
    }

    // 需求：获取当前公司员工大于35的员工信息
    public static List<Employee> employeeList = Arrays.asList(
            new Employee("zhangsan", 18, 9999.99),
            new Employee("lisi", 36, 11111.11),
            new Employee("wangwu", 35, 5555.99),
            new Employee("zhaoliu", 16, 66666.99),
            new Employee("tianqi", 8, 2229.99)
    );

    @Test
    public void test04() {
        List<Employee> employees = filterEmployees(employeeList);
        for (Employee employee : employees) {
            System.out.println(employee.getName());
        }
    }

    public List<Employee> filterEmployees(List<Employee> list) {
        ArrayList<Employee> emps = new ArrayList<>();
        for (Employee emp : list) {
            if (emp.getAge() >= 35) {
                emps.add(emp);
            }
        }
        return emps;
    }


}
