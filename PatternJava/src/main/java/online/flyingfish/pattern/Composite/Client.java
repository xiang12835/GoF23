package online.flyingfish.pattern.Composite;

import org.junit.Test;

/*
事实上组合模式和桥接模式的组合完全不一样。组合模式用于**整体与部分的结构**，当整体与部分有相似的结构，在操作时可以被一致对待时，就可以使用组合模式。例如：

- 文件夹和子文件夹的关系：文件夹中可以存放文件，也可以新建文件夹，子文件夹也一样。
- 总公司子公司的关系：总公司可以设立部门，也可以设立分公司，子公司也一样。
- 树枝和分树枝的关系：树枝可以长出叶子，也可以长出树枝，分树枝也一样。

在这些关系中，虽然整体包含了部分，但无论整体或部分，都具有一致的行为。

组合模式：又叫部分整体模式，是用于把一组相似的对象当作一个单一的对象。组合模式依据树形结构来组合对象，用来表示部分以及整体层次。这种类型的设计模式属于结构型模式，它创建了对象组的树形结构。

考虑这样一个实际应用：设计一个公司的人员分布结构，结构如下图所示。

![](https://pic.leetcode-cn.com/1604301891-odwCrq-image.png)

我们注意到人员结构中有两种结构，一是管理者，如老板，PM，CFO，CTO，二是职员。其中有的管理者不仅仅要管理职员，还会管理其他的管理者。这就是一个典型的整体与部分的结构。

组合模式最主要的功能就是让用户可以一致对待整体和部分结构，将两者都作为一个相同的组件。

1. 先新建一个抽象的组件类
2. 管理者继承自此抽象类
3. 职员同样继承自此抽象类

可以看到，使用组合模式后，我们解决了之前的两个弊端。一是将共有的字段与方法移到了父类中，消除了重复，并且在客户端中，可以一致对待 Manager 和 Employee 类：

- Manager 类和 Employee 类统一声明为 Component 对象
- 统一调用 Component 对象的 addComponent 方法添加子对象即可。

* */

public class Client {
    @Test
    public void test(){
        Component boss = new Manager("老板", "唱怒放的生命");
        Component HR = new Employee("人力资源", "聊微信");
        Component PM = new Manager("产品经理", "不知道干啥");
        Component CFO = new Manager("财务主管", "看剧");
        Component CTO = new Manager("技术主管", "划水");
        Component UI = new Employee("设计师", "画画");
        Component operator = new Employee("运营人员", "兼职客服");
        Component webProgrammer = new Employee("程序员", "学习设计模式");
        Component backgroundProgrammer = new Employee("后台程序员", "CRUD");
        Component accountant = new Employee("会计", "背九九乘法表");
        Component clerk = new Employee("文员", "给老板递麦克风");
        boss.addComponent(HR);
        boss.addComponent(PM);
        boss.addComponent(CFO);
        PM.addComponent(UI);
        PM.addComponent(CTO);
        PM.addComponent(operator);
        CTO.addComponent(webProgrammer);
        CTO.addComponent(backgroundProgrammer);
        CFO.addComponent(accountant);
        CFO.addComponent(clerk);

        boss.check();
    }

}
