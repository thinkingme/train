package cn.thinkingme.train.test;

/**
 * <p>
 *
 * </p>
 *
 * @author: huige
 * @date: 2022/2/10 9:27
 */
@FunctionalInterface
public interface ObjectFactory<T> {

    /**
     * Return an instance (possibly shared or independent)
     * of the object managed by this factory.
     * @return the resulting instance
     */
    T getObject();

}