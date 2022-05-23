package online.flyingfish.pattern.Decorator.beauty;

import org.junit.Test;

/* 用于增强功能的装饰模式
 *
 * 装饰模式是继承的一种替代方案。
 * 透明装饰模式可以无限装饰:这里的装饰器仅用于增强功能，并不会改变 Me 原有的功能
 * 本例如果不使用装饰模式，而是改用继承实现的话，戴着戒指的 Me 需要派生一个子类、戴着项链的 Me 需要派生一个子类、戴着耳环的 Me 需要派生一个子类、戴着戒指 + 项链的需要派生一个子类...各种各样的排列组合会造成类爆炸。
 * 而采用了装饰模式就只需要为每个装饰品生成一个装饰类即可，所以说就增加对象功能来说，装饰模式比生成子类实现更为灵活。
 * */
public class ClientBeauty {
    @Test
    public void show() {
        IBeauty me = new Me();
        System.out.println("我原本的颜值：" + me.getBeautyValue());

        // 随意挑选装饰
        IBeauty meWithNecklace = new NecklaceDecorator(me);
        System.out.println("戴上了项链后，我的颜值：" + meWithNecklace.getBeautyValue());

        // 多次装饰
        IBeauty meWithManyDecorators = new NecklaceDecorator(new RingDecorator(new EarringDecorator(me)));
        System.out.println("戴上耳环、戒指、项链后，我的颜值：" + meWithManyDecorators.getBeautyValue());

        // 任意搭配装饰
        IBeauty meWithNecklaceAndRing = new NecklaceDecorator(new RingDecorator(me));
        System.out.println("戴上戒指、项链后，我的颜值：" + meWithNecklaceAndRing.getBeautyValue());
    }

}
