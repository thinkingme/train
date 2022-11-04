package cn.thinkingme.train.shua.JVM;

/**
 * @ProjectName: 题目代码
 * @Package: JVM
 * @ClassName: NameCheckerProcessor
 * @Author: huige
 * @Description:
 * @Date: 2021/8/25 16:31
 * @Version: 1.0
 */
// 可以用"*"表示支持所有Annotations

import javax.annotation.processing.*;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import java.util.Set;

//可以用"*"表示支持所有Annotations
@SupportedAnnotationTypes("*")
//只支持JDK 1.6的Java代码
@SupportedSourceVersion(SourceVersion.RELEASE_6)
public class NameCheckerProcessor extends AbstractProcessor {

    private NameChecker nameChecker;

    /**
     * 初始化名称检查插件
     */
    @Override
    public void init(ProcessingEnvironment processingEnv) {
        super.init(processingEnv);
        nameChecker = new NameChecker(processingEnv);
    }

    /**
     * 对输入的语法树的各个节点进行进行名称检查
     * annotations 注解处理器需要处理的注解集合
     * roundEnv 语法树节点集合，包含16类节点，分别为：包（PACKAGE)、类（CLASS）、方法（METHOD）、字段（FIELD）等
     */
    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        if (!roundEnv.processingOver()) {
            for (Element element : roundEnv.getRootElements())
                nameChecker.checkNames(element);
        }
        return false;
    }

}