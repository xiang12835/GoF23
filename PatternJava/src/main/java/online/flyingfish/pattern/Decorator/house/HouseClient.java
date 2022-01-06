package online.flyingfish.pattern.Decorator.house;

import org.junit.Test;

/* 用于添加功能的装饰模式
 *
* */
public class HouseClient {
    @Test
    public void show() {
        IHouse house = new House();
        house.live();

        IStickyHookHouse stickyHookHouse = new StickyHookDecorator(house);
        stickyHookHouse.live();
        stickyHookHouse.hangThings();
    }

}
