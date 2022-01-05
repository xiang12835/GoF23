package online.flyingfish.pattern.Bridge;

import org.junit.Test;

public class DrawTest {
    @Test
    public void draw() {
        Rectangle rectangle = new Rectangle();
        rectangle.setColor(new Red());
        rectangle.draw();

        Round round = new Round();
        round.setColor(new Blue());
        round.draw();

        Triangle triangle = new Triangle();
        triangle.setColor(new Yellow());
        triangle.draw();
    }
}
