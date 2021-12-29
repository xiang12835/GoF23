package online.flyingfish.pattern.Prototype;

import org.junit.Test;

public class Order {

    @Test
    public void create() {
        MilkTea milkTeaOfJay = new MilkTea();
        milkTeaOfJay.type = "原味";
        milkTeaOfJay.ice = false;

        MilkTea yourMilkTea = milkTeaOfJay.clone();
        System.out.println(yourMilkTea.type + "奶茶");
    }
}
