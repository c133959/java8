package chapter01_lambda.demo02;

/**
 * @ClassName: FilterEmployeeBySalary
 * @Description: 通过薪水过滤
 * @Author sunsl
 * @Date 2022/4/3 21:02
 * @Version 1.0
 */
public class FilterEmployeeBySalary implements MyPredicate<Employee>{
    @Override
    public boolean test(Employee employee) {
        return employee.getSalary() >= 5000;
    }
}
