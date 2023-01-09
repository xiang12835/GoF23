package online.flyingfish.pattern.Memento;

import org.junit.Test;

/*
* 备忘录模式：在不破坏封装的条件下，通过备忘录对象存储另外一个对象内部状态的快照，在将来合适的时候把这个对象还原到存储起来的状态。

备忘录模式的优点是：

- 给用户提供了一种可以恢复状态的机制，使用户能够比较方便的回到某个历史的状态
- 实现了信息的封装，使得用户不需要关心状态的保存细节

缺点是：

- 消耗资源，如果类的成员变量过多，势必会占用比较大的资源，而且每一次保存都会消耗一定的内存。

示例：备忘录模式最常见的实现就是游戏中的存档、读档功能，通过存档、读档，使得我们可以随时恢复到之前的状态。

比如 IDE 中，用户可以将自己的设置导出成 zip，当需要恢复设置时，再将导出的 zip 文件导入即可。这个功能内部的原理就是备忘录模式

* */
public class Client {
    @Test
    public void test() {
        Player player = new Player();
        // 存档
        Memento memento = player.saveState();

        // 打 Boss，打不过，壮烈牺牲
        player.fightBoss();

        // 读档
        player.restoreState(memento);
    }

}
