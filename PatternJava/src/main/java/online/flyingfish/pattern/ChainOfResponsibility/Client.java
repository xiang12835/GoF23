package online.flyingfish.pattern.ChainOfResponsibility;

import org.junit.Test;


/*
* 举个切身的例子，比如：普通的程序员可以解决中等难度的 bug，优秀程序员可以解决困难的 bug，而菜鸟程序员只能解决简单的 bug。
* 为了将其量化，我们用一个数字来表示 bug 的难度，(0, 20] 表示简单，(20,50] 表示中等， (50,100] 表示困难，我们来模拟一个 bug 解决的流程。
*
* 责任链模式：使多个对象都有机会处理请求，从而避免请求的发送者和接收者之间的耦合关系。将这些对象连成一条链，并沿着这条链传递该请求，直到有一个对象处理它为止。
*
* 责任链主要用于处理 职责相同，程度不同的类。
*
* 其主要优点有：
1. 降低了对象之间的耦合度。在责任链模式中，客户只需要将请求发送到责任链上即可，无须关心请求的处理细节和请求的传递过程，所以责任链将请求的发送者和请求的处理者解耦了。
2. 扩展性强，满足开闭原则。可以根据需要增加新的请求处理类。
3. 灵活性强。可以动态地改变链内的成员或者改变链的次序来适应流程的变化。
4. 简化了对象之间的连接。每个对象只需保持一个指向其后继者的引用，不需保持其他所有处理者的引用，这避免了使用众多的条件判断语句。
5. 责任分担。每个类只需要处理自己该处理的工作，不该处理的传递给下一个对象完成，明确各类的责任范围，符合类的单一职责原则。不再需要 “项目经理” 来处理所有的责任分配任务。
*
* 但我们在使用中也发现了它的一个明显缺点，如果这个 bug 没人处理，可能导致 “程序员祭天” 异常。其主要缺点有：
*
1. 不能保证每个请求一定被处理，该请求可能一直传到链的末端都得不到处理。
2. 如果责任链过长，请求的处理可能涉及多个处理对象，系统性能将受到一定影响。
3. 责任链建立的合理性要靠客户端来保证，增加了客户端的复杂性，可能会由于责任链拼接次序错误而导致系统出错，比如可能出现循环调用。
*
* */

public class Client {
    @Test
    public void test() {
        NewbieProgrammer newbie = new NewbieProgrammer();
        NormalProgrammer normal = new NormalProgrammer();
        GoodProgrammer good = new GoodProgrammer();

        Bug easy = new Bug(20);
        Bug middle = new Bug(50);
        Bug hard = new Bug(100);

        // 组成责任链
        newbie.setNext(normal);
        normal.setNext(good);

        // 从菜鸟程序员开始，沿着责任链传递
        newbie.handle(easy);
        newbie.handle(middle);
        newbie.handle(hard);
    }
}
