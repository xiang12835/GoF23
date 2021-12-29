package online.flyingfish.pattern.ChainOfResponsibility;


/*
在这个抽象类中：

next 对象表示如果自己解决不了，需要将责任传递给的下一个人；
handle 方法表示自己处理此 bug 的逻辑，在这里判断是自己解决或者继续传递。

* */
public abstract class Programmer {
    protected Programmer next;

    public void setNext(Programmer next) {
        this.next = next;
    }

    abstract void handle(Bug bug);
}
