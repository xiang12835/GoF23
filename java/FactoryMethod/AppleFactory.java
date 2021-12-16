/* 工厂方法模式
 
苹果工厂

*/ 
public class AppleFactory {
    public Fruit create(){
        return new Apple();
    }
}