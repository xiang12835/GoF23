package online.flyingfish.pattern.AbstractFactory;

// 苹果工厂实现此接口
public class AppleFactory implements IFactory {
    @Override
    public Fruit create(){
        return new Apple();
    }
}