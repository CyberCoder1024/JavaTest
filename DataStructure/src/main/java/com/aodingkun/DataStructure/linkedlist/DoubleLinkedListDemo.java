package com.aodingkun.DataStructure.linkedlist;

/**
 * +-----+-----+----+
 * |prior|data |next|
 * +-----+-----+----+
 */
public class DoubleLinkedListDemo {

    public static void main(String[] args) {
        //
        System.out.println("双向链表的测试");
        ///先创建节点
        HeroNode2 hero1 = new HeroNode2(1, "宋江", "及时雨");
        HeroNode2 hero2 = new HeroNode2(2, "吴用", "智多星");
        HeroNode2 hero3 = new HeroNode2(3, "卢俊义", "玉麒麟");
        HeroNode2 hero4 = new HeroNode2(4, "林冲", "豹子头");
        //创建的一个双向链表 对象
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        //添加节点
        doubleLinkedList.add(hero1);
        doubleLinkedList.add(hero2);
        doubleLinkedList.add(hero3);
        doubleLinkedList.add(hero4);

        doubleLinkedList.list();

        //
        HeroNode2 newHeroNode = new HeroNode2(4, "公孙胜", "入云龙");
        doubleLinkedList.update(newHeroNode);
        System.out.println("修改后列表的情况");
        doubleLinkedList.list();

        //
        doubleLinkedList.del(3);
        System.out.println("ɾ删除后列表的情况~~");
        doubleLinkedList.list();


    }

}

///定义SingleLinkedList 管理我们的英雄
////完成对对象的增删改查
class DoubleLinkedList {

    ////初始化一个头节点 头节点不要动 不妨具体数据
    //	//head节点不存放具体的数据 作用就是表示单链表头next
    private HeroNode2 head = new HeroNode2(0, "", "");

    //返回头节点
    public HeroNode2 getHead() {
        return head;
    }

    //
    //显示列表 show list
    public void list() {
        //
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        //
        HeroNode2 temp = head.next;
        while (true) {
            //
            if (temp == null) {
                break;
            }
            //
            System.out.println(temp);
            //
            temp = temp.next;
        }
    }

    //

    /**
     * 添加增加 添加一个节点到 双向列表 的最好
     * 1.先找到双向链表的最好一个节点
     * 2.
     * 3
     *
     * @param heroNode
     */
    public void add(HeroNode2 heroNode) {

        //因为head节点不能动 因此我们需要一个辅助遍历temp
        HeroNode2 temp = head;
        //遍历链表，找到最后
        while (true) {
            //找到链表的最后
            if (temp.next == null) {//
                break;
            }
            //如果没有找-到最后，让temp后移
            temp = temp.next;
        }

        //当退出while循环时 temp指向链表的最后
        //形成一个双向链表
        temp.next = heroNode;

        heroNode.pre = temp;
    }

    /**
     *
     */
    public void update(HeroNode2 newHeroNode) {
        //
        if (head.next == null) {
            System.out.println("链表为空~~");
            return;
        }
        //找到需要修改的节点 根据no 编号
        //定义一个辅助变量
        HeroNode2 temp = head.next;
        boolean flag = false; //表示是否找到该节点
        while (true) {
            if (temp == null) {
                break; //已经遍历完成
            }
            if (temp.no == newHeroNode.no) {
                //找到
                flag = true;
                break;
            }
            temp = temp.next;
        }
        //根据falg 判断是否找到要修改的节点
        if (flag) {
            temp.name = newHeroNode.name;
            temp.nickname = newHeroNode.nickname;
        } else { // 没有找到
            System.out.printf("没有找到编号 %d 的节点，不能修改\n", newHeroNode.no);
        }
    }

    /**
     * 从双向链表中删除一个节点
     * 1.对于双向链表 可以直接找到要删除的这个节点
     * 2.找到后 自我删除即可
     *
     * @param no
     */
    public void del(int no) {

        //判断当前链表是否为空
        if (head.next == null) {//空链表
            System.out.println("链表为空 无法删除");
            return;
        }
        //辅助变量（指针）
        HeroNode2 temp = head.next;
        boolean flag = false; ///标记是否找到待删除的节点
        while (true) {
            if (temp == null) { //已经到链表的最后节点的next
                break;
            }
            if (temp.no == no) {
                //找到的待删除节点的前一个节点temp
                flag = true;
                break;
            }
            temp = temp.next; //temp后移 遍历
        }
        //判断flag
        if (flag) { //
            //
            // temp.next = temp.next.next;[单向]
            temp.pre.next = temp.next;//
            //
            //防止删除的节点是最后一个节点
            if (temp.next != null) {
                temp.next.pre = temp.pre;
            }
        } else {
            System.out.printf("要删除的 %d 节点不存在\n", no);
        }
    }

}

//定义HeroNode 每个HeroNode 对象是一个节点
class HeroNode2 {
    public int no;
    public String name;
    public String nickname;
    public HeroNode2 next; //指向下一个节点 默认为空 null
    public HeroNode2 pre; //指向前一个节点，默认为空 null
    //

    public HeroNode2(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    //
    @Override
    public String toString() {
        return "HeroNode [no=" + no + ", name=" + name + ", nickname=" + nickname + "]";
    }

}
