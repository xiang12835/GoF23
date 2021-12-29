package online.flyingfish.pattern.FactoryMethod;

import org.junit.Test;

/* 简单工厂模式

调用者

*/ 
public class UserSample {
    @Test
    public void eat(){
        FruitFactory fruitFactory = new FruitFactory();
        Fruit apple = fruitFactory.create("苹果");
        Fruit pear = fruitFactory.create("梨子");
        System.out.println(apple.eat());
        System.out.println(pear.eat());
    }
}

/*
工厂模式一共有三种：

简单工厂模式
工厂方法模式
抽象工厂模式

在 GoF 所著的《设计模式》一书中，简单工厂模式被划分为工厂方法模式的一种特例，没有单独被列出来。

总而言之，简单工厂模式就是让一个工厂类承担构建所有对象的职责。调用者需要什么产品，让工厂生产出来即可。它的弊端也显而易见：

一是如果需要生产的产品过多，此模式会导致工厂类过于庞大，承担过多的职责，变成超级类。当苹果生产过程需要修改时，要来修改此工厂。梨子生产过程需要修改时，也要来修改此工厂。也就是说这个类不止一个引起修改的原因。违背了单一职责原则。
二是当要生产新的产品时，必须在工厂类中添加新的分支。而开闭原则告诉我们：类应该对修改封闭。我们希望在添加新功能时，只需增加新的类，而不是修改既有的类，所以这就违背了开闭原则。

*/