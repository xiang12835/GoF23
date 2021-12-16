package online.flyingfish.pattern.FactoryMethod;

/* 工厂方法模式
 
梨子工厂

*/ 
public class PearFactory {
    public Fruit create(){
        return new Pear();
    }
}
