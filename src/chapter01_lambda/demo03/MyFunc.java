package chapter01_lambda.demo03;

/**
 * 定义一个函数式接口
 */

//被@FunctionalInterface修饰的，必须只能包含一个抽象方法
@FunctionalInterface
public interface MyFunc {

    public Integer getValue(Integer num);

}
