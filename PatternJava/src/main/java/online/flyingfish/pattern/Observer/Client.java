package online.flyingfish.pattern.Observer;

import org.junit.Test;

public class Client {
    @Test
    public void test() {
        CriminalObservable zhangSan = new CriminalObservable();
        PoliceObserver police1 = new PoliceObserver();
        PoliceObserver police2 = new PoliceObserver();
        PoliceObserver police3 = new PoliceObserver();
        zhangSan.addObserver(police1);
        zhangSan.addObserver(police2);
        zhangSan.addObserver(police3);
        zhangSan.crime("放狗咬人");
    }
}
