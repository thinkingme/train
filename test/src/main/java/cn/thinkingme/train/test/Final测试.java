package cn.thinkingme.train.test;

/**
 * <p>
 *
 * </p>
 *
 * @author: huige
 * @date: 2022/1/24 10:47
 */
public class Final测试 {
    private final String string = "45465";

    /**
     * final表示类指针指向的地址不能变化，也就是不能赋值别的对象值，单例
     */
    private final static Final测试 final测试 = new Final测试();

    public Final测试() {

    }

    public static void main(String[] args) {
        System.out.println(String.class.getClassLoader());
        System.out.println(final测试.string);
    }
}
