package online.flyingfish.pattern.Builder;

/*
* 建造者模式用于创建过程稳定，但配置多变的对象。在《设计模式》一书中的定义是：将一个复杂的构建与其表示相分离，使得同样的构建过程可以创建不同的表示。

经典的“建造者-指挥者”模式现在已经不太常用了，现在建造者模式主要用来通过链式调用生成不同的配置。比如我们要制作一杯珍珠奶茶。它的制作过程是稳定的，除了必须要知道奶茶的种类和规格外，是否加珍珠和是否加冰是可选的。使用建造者模式表示如下：

* */
public class MilkTea {
    private final String type;
    private final String size;
    private final boolean pearl;
    private final boolean ice;

    private MilkTea(String type, String size, boolean pearl, boolean ice) {
        this.type = type;
        this.size = size;
        this.pearl = pearl;
        this.ice = ice;
    }

    private MilkTea(Builder builder) {
        this.type = builder.type;
        this.size = builder.size;
        this.pearl = builder.pearl;
        this.ice = builder.ice;
    }

    public String getType() {
        return type;
    }

    public String getSize() {
        return size;
    }

    public boolean isPearl() {
        return pearl;
    }
    public boolean isIce() {
        return ice;
    }

    public static class Builder {

        private final String type;
        private String size = "中杯";
        private boolean pearl = true;
        private boolean ice = false;

        public Builder(String type) {
            this.type = type;
        }

        public Builder size(String size) {
            this.size = size;
            return this;
        }

        public Builder pearl(boolean pearl) {
            this.pearl = pearl;
            return this;
        }

        public Builder ice(boolean cold) {
            this.ice = cold;
            return this;
        }

        public MilkTea build() {
            return new MilkTea(this);
        }
    }
}