package test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * Created by zenghuapei on 2016/6/11.
 */
public class ClassInfo {
    public static void main(String[] args) throws Exception {
        Class<Test> cls=Test.class;
        Constructor<Test> construct = cls.getConstructor(String.class);
        Test test =construct.newInstance("初始化");
        Method med=cls.getMethod("getInfo", String.class);
        med.invoke(test, "调用方法成功");
    }
}
