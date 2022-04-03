package chapter01_lambda.demo02;

/**
 * @ClassName: FilterEmployeeByAge
 * @Description: 继承接口来实现对员年龄过滤的过滤器类
 * @Author sunsl
 * @Date 2022/4/3 20:52
 * @Version 1.0
 */
public class FilterEmployeeByAge implements MyPredicate<Employee> {

    @Override
    public boolean test(Employee employee) {
        return employee.getAge() >= 35;
    }
}
