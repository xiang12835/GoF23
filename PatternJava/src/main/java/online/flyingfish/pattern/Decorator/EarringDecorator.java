package online.flyingfish.pattern.Decorator;

public class EarringDecorator implements IBeauty{
    private final IBeauty me;

    public EarringDecorator(IBeauty me) {
        this.me = me;
    }

    public int getBeautyValue() {
        return me.getBeautyValue() + 50;
    }

}
