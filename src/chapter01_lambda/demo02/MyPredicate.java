package chapter01_lambda.demo02;

/**
 * @ClassName: MyPredicate
 * @Description: 包含一个过滤的方法，由实现该接口的类自行设计过滤条件
 * @Author sunsl
 * @Date 2022/4/3 20:49
 * @Version 1.0
 */
public interface MyPredicate<T> {

    boolean test(T t);
}
