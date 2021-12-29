package online.flyingfish.pattern.Singleton;

/*
静态内部类的懒加载方式，但其中的原理不一定每个人都清楚。接下来我们便来分析其原理，搞清楚两个问题：

1. 静态内部类方式是怎么实现懒加载的
2. 静态内部类方式是怎么保证线程安全的
* */

public class Singleton5 {

    private static class SingletonHolder {
        public static Singleton5 instance = new Singleton5();
    }

    private Singleton5() {
    }

    public static Singleton5 getInstance() {
        return SingletonHolder.instance;
    }
}
