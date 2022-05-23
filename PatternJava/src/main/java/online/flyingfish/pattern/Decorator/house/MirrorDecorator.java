package online.flyingfish.pattern.Decorator.house;

import online.flyingfish.pattern.Decorator.house.IHouse;
import online.flyingfish.pattern.Decorator.house.IMirrorHouse;

public class MirrorDecorator implements IMirrorHouse {
    private final IHouse house;

    public MirrorDecorator(IHouse house) {
        this.house = house;
    }

    @Override
    public void live() {
        house.live();
    }

    @Override
    public void lookMirror() {
        System.out.println("有了镜子后，新增了照镜子功能");
    }

}
