package online.flyingfish.pattern.Singleton;

/*
这样增加一种检查方式后，如果 instance 已经被实例化，则不会执行同步化操作，大大提升了程序效率。上面这种写法也就是我们平时较常用的双检锁方式实现的线程安全的单例模式。
但这样的懒汉式单例仍然有一个问题，JVM 底层为了优化程序运行效率，可能会对我们的代码进行指令重排序，在一些特殊情况下会导致出现空指针，为了防止这个问题，更进一步的优化是给 instance 变量加上 volatile 关键字。

有读者可能会有疑问，我们在外面检查了 instance == null, 那么锁里面的空检查是否可以去掉呢？

答案是不可以。如果里面不做空检查，可能会有两个线程同时通过了外面的空检查，然后在一个线程 new 出实例后，第二个线程进入锁中又 new 出一个实例，导致创建多个实例。

除了双检锁方式外，还有一种比较常见的静态内部类方式保证懒汉式单例的线程安全，见 Singleton5

* */

public class Singleton4 {

    private static Singleton4 instance = null;

    private Singleton4() {
    }

    public static Singleton4 getInstance() {
        if (instance == null) {
            synchronized (Singleton4.class) {
                if (instance == null) {
                    instance = new Singleton4();
                }
            }
        }
        return instance;
    }
}
