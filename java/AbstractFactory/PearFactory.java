// 梨子工厂实现此接口
public class PearFactory implements IFactory {
    @Override
    public Fruit create(){
        return new Pear();
    }
}