package online.flyingfish.pattern.Singleton;

/*
这样就能保证多个线程调用 getInstance 时，一次最多只有一个线程能够执行判空并 new 出实例的操作，所以 instance 只会实例化一次。
但这样的写法仍然有问题，当多个线程调用 getInstance 时，每次都需要执行 synchronized 同步化方法，这样会严重影响程序的执行效率。
所以更好的做法是在同步化之前，再加上一层检查，见Singleton4
* */
public class Singleton3 {

    private static Singleton3 instance = null;

    private Singleton3() {
    }

    public static Singleton3 getInstance() {
        synchronized (Singleton3.class) {
            if (instance == null) {
                instance = new Singleton3();
            }
        }
        return instance;
    }
}
