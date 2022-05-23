package online.flyingfish.pattern.Decorator.house;

import online.flyingfish.pattern.Decorator.house.House;
import online.flyingfish.pattern.Decorator.house.IHouse;
import online.flyingfish.pattern.Decorator.house.IStickyHookHouse;
import online.flyingfish.pattern.Decorator.house.StickyHookDecorator;
import org.junit.Test;

/* 用于新增功能的装饰模式
 * 半透明装饰模式:扩展了新的功能
 * 为什么叫半透明呢？由于新的接口 IStickyHookHouse 拥有之前 IHouse 不具有的方法，所以我们如果要使用装饰器中添加的功能，就不得不区别对待装饰前的对象和装饰后的对象。
 * 也就是说客户端要使用新方法，必须知道具体的装饰类 StickyHookDecorator，所以这个装饰类对客户端来说是可见的、不透明的。
 * 而被装饰者不一定要是 House，它可以是实现了 IHouse 接口的任意对象，所以被装饰者对客户端是不可见的、透明的。由于一半透明，一半不透明，所以称之为半透明装饰模式。
 *
 * */
public class ClientHouse {
    @Test
    public void show() {
        IHouse house = new House();
        house.live();

        IStickyHookHouse stickyHookHouse = new StickyHookDecorator(house);
        stickyHookHouse.live();
        stickyHookHouse.hangThings();

        IMirrorHouse mirrorHouse = new MirrorDecorator(house);
        mirrorHouse.live();
        mirrorHouse.lookMirror();

        // 半透明装饰模式中，我们无法多次装饰。
        // IStickyHookHouse stickyHookHouse = new StickyHookDecorator(house);
        IMirrorHouse houseWithStickyHookMirror = new MirrorDecorator(stickyHookHouse);
        houseWithStickyHookMirror.live();
        // houseWithStickyHookMirror.hangThings(); // 这里会报错，找不到 hangThings 方法
        houseWithStickyHookMirror.lookMirror();
    }

}
