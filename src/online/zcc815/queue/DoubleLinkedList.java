package online.zcc815.queue;

import java.util.Stack;

/**
 * Project  DataStructures
 * Package  online.zcc815.queue
 *
 * @Description
 * @Author ZCC
 * @Email zcc815@126.com
 * @Date 2020/6/17 21:41
 * @Version 1.0.0
 */
public class DoubleLinkedList {
    public static void main(String[] args) {
        HeroCode2 hero1 = new HeroCode2(1, "宋江", "及时雨");
        HeroCode2 hero2 = new HeroCode2(2, "吴用", "智多星");
        HeroCode2 hero3 = new HeroCode2(3, "林冲", "豹子头");
        HeroCode2 hero4 = new HeroCode2(3, "林冲", "小包子");
        HeroCode2 hero5 = new HeroCode2(1, "宋江", "及时坑");
        HeroCode2 hero6 = new HeroCode2(1, "宋江", "及时6");
        SingleLinkedListAdmin2 admin2 = new SingleLinkedListAdmin2();
        System.out.println("添加节点");
        admin2.addHeroCode2(hero1);
        admin2.addHeroCode2(hero2);
        admin2.addHeroCode2(hero3);
        admin2.printDoubleLinkedList();
        admin2.reverseLinkList(admin2.getHead());
        System.out.println("---------------------");
        admin2.printDoubleLinkedList();
/*        System.out.println("----------------------------");
        System.out.println("删除节点");
        admin2.deleteNode(2);
        admin2.printDoubleLinkedList();
        System.out.println("----------------------------");
        System.out.println("修改节点");
        admin2.modifyNode(hero4);
        admin2.modifyNode(hero5);
        admin2.modifyNode(hero6);
        admin2.printDoubleLinkedList();
        System.out.println("----------------------------");
        System.out.println("打印上一个节点");
        System.out.println(hero4.pre);*/
    }


}

class SingleLinkedListAdmin2 {
    //头节点,初始化使用
    private HeroCode2 head = new HeroCode2(0, "", "");

    public HeroCode2 getHead() {
        return head;
    }

    //添加数据
    public void addHeroCode2(HeroCode2 heroCode) {
        HeroCode2 tmp = head;
        //跳出循环说明已找到最后一个节点
        while (true) {
            if (tmp.next == null) {
                break;
            }
            tmp = tmp.next;

        }
        //将新节点放入链表的最后
        tmp.next = heroCode;
        heroCode.pre = tmp;
    }

    //打印链表
    public void printDoubleLinkedList() {
        //判断链表是不是为null
        if (head.next == null) {
            System.out.println("单链表为null");
            return;
        }
        HeroCode2 tmp1 = head;
        while (true) {
            tmp1 = tmp1.next;
            System.out.println(tmp1);
            if (tmp1.next == null) {
                break;
            }
        }
    }

    //修改链表中某一节点的值
    public void modifyNode(HeroCode2 modifiedCode) {
        //判断链表是否为空
        if (head.next == null) {
            System.out.println("链表为null");
            return;
        }
        HeroCode2 tmp = head;
        //定义标识判断是否找到要修改的节点
        int flag = 0;
        while (true) {
            if (tmp.next != null) {
                if (tmp.next.no == modifiedCode.no) {
                    flag = 1;
                    break;
                }
                tmp = tmp.next;
            } else {
                break;
            }
        }
        if (flag == 1) {
           tmp.next.nickName = modifiedCode.nickName;
           tmp.next.name = modifiedCode.name;
           modifiedCode.pre = tmp;
        } else {
            System.out.println("找不到要修改的节点\n" + modifiedCode.no);
        }
    }

    //删除莫一节点
    public void deleteNode(int no) {
        HeroCode2 tmp = head;
        //定义标志判断否找到要删除的节点
        boolean flag = false;
        if (tmp.next == null) {
            System.out.println("链表是空的还删除什么");
            return;
        }
        //遍历链表找到要删除的节点
        while (true) {
            if (tmp.next == null) {
                System.out.println("没有找到要删除的节点\n" + no);
                return;
            }
            if (tmp.next.no == no) {
                flag = true;
                tmp = tmp.next;
                break;
            }
            tmp = tmp.next;
        }
        if (flag) {
            //为真说明为头结点要被删除
            if (tmp.pre == null) {
                tmp.next.pre = tmp.pre;
                return;
            }
            //为真说明尾结点要被删除
            if (tmp.next == null) {
                tmp.pre.next = tmp.next;
                return;
            }

            tmp.next.pre = tmp.pre;
            tmp.pre.next = tmp.next;
        }
    }

    //得到链表的有效数据的长度
    public int getNodeLength(HeroCode code) {
        //定义初始长度为0
        int length = 0;

        while (true) {
            if (code.next == null) {
                break;
            }
            length++;
            code = code.next;
        }
        System.out.println("链表有效数据个数为\n" + length);
        return length;
    }

    //新浪面试题求取倒数第N个节点
/*
    public HeroCode getHeroCode(int count) throws Exception {
        if (head.next == null) {
            throw new Exception("链表为空");
        }
        //记录链表有效数据的长度
        int n = getNodeLength(getHead());
        //倒序转换为正序
        n = n - count;
        if (n <= 0) {
            throw new Exception("当前取数位数已超过链表长度");
        }
        int flag = 0;
        HeroCode tmp = head.next;
        while (true) {
            if (flag == n) {
                break;
            }
            flag++;
            tmp = tmp.next;
        }
        System.out.println(tmp.toString());
        return tmp;
    }
*/

    //腾讯面试题单链表反转
    public void reverseLinkList(HeroCode2 head) {
        //当链表为空||链表长度为1时,不需要反转
        if (head.next == null) {
            System.out.println("链表为null还反转什么!!");
            return;
        }
        if (head.next.next == null) {
            System.out.println("链表长度为1反转和不反转都一样");
        }
        //定义临时节点
        HeroCode2 curr = head.next;
        HeroCode2 tmp = new HeroCode2(0, "", "");
        HeroCode2 next = null;
        while (curr != null) {
            //将后一个元素先保存到临时节点中
            next = curr.next;
            //将前一个元素放到后面
            curr.next = tmp.next;
            tmp.next = curr;
            //将后一个元素赋给当前位置的
            curr = next;
        }
        head.next = tmp.next;
    }

    //百度面试题从尾到头打印链表
    public void printReverseHeroCode(HeroCode head) {
        //判断链表是否为null
        if (head.next == null) {
            System.out.println("链表为null");
            return;
        }
        Stack<HeroCode> stack = new Stack<>();
        HeroCode curr = head.next;
        while (curr != null) {
            stack.push(curr);
            curr = curr.next;
        }
        System.out.println(stack.peek());
        System.out.println("************************");
        System.out.println("尾到头打印");
        while (stack.size() > 0) {
            System.out.println(stack.pop().toString());
        }
    }
}

class HeroCode2 {
    //英雄的名字
    public String name;
    //英雄的编号
    public int no;
    //英雄的昵称
    public String nickName;
    //指向下一个节点
    public HeroCode2 next;
    //指向上一个节点
    public HeroCode2 pre;

    //构造器
    public HeroCode2(int no, String name, String nickName) {
        this.name = name;
        this.no = no;
        this.nickName = nickName;
    }

    //重写toString方法
    @Override
    public String toString() {
        return "HeroCode=[ no= " + no + " name= " + name + "nickName= " + nickName + "]";
    }
}
