package online.zcc815.queue;

import java.util.Stack;

/**
 * Project  DataStructures
 * Package  online.zcc815.queue
 *
 * @Description 单链表实现队列(添加 修改 删除)
 * @Author ZCC
 * @Email zcc815@126.com
 * @Date 2020/6/6 22:30
 * @Version 1.0.0
 */
class SingleLinkedList {
    public static void main(String[] args) throws Exception {

        HeroCode hero1 = new HeroCode(1, "宋江", "及时雨");
        HeroCode hero2 = new HeroCode(2, "吴用", "智多星");
        HeroCode hero3 = new HeroCode(3, "林冲", "豹子头");
        SingleLinkedListAdmin singleLinkedListAdmin = new SingleLinkedListAdmin();
        singleLinkedListAdmin.addHeroCode(hero1);
        singleLinkedListAdmin.addHeroCode(hero2);
        singleLinkedListAdmin.addHeroCode(hero3);
        System.out.println("数据添加完毕");
        singleLinkedListAdmin.getNodeLength(singleLinkedListAdmin.getHead());
        singleLinkedListAdmin.reverseLinkList(singleLinkedListAdmin.getHead());
        singleLinkedListAdmin.printSingleLinkedList();
        System.out.println("____________________________________________");
        singleLinkedListAdmin.printReverseHeroCode(singleLinkedListAdmin.getHead());
        /*System.out.println("_______________________________________");
        singleLinkedListAdmin.printSingleLinkedList();
        System.out.println("_______________________________________");
        singleLinkedListAdmin.printSingleLinkedList();
        System.out.println("_______________________________________");
        singleLinkedListAdmin.modifyNode(new HeroCode(3, "小林", "豹子头"));
        System.out.println("节点修改后:");
        singleLinkedListAdmin.printSingleLinkedList();
        System.out.println("_______________________________________");
        System.out.println("节点删除后");
        singleLinkedListAdmin.deleteNode(2);
        singleLinkedListAdmin.printSingleLinkedList();
        singleLinkedListAdmin.getNodeLength(singleLinkedListAdmin.getHead());
        System.out.println("_______________________________________");
        singleLinkedListAdmin.getHeroCode(1);
        System.out.println("_______________________________________");
*/


    }
}

class SingleLinkedListAdmin {
    //头节点,初始化使用
    private HeroCode head = new HeroCode(0, "", "");

    public HeroCode getHead() {
        return head;
    }

    //添加数据
    public void addHeroCode(HeroCode heroCode) {
        HeroCode tmp = head;
        //跳出循环说明已找到最后一个节点
        while (true) {
            if (tmp.next == null) {
                break;
            }
            tmp = tmp.next;
        }
        //将新节点放入链表的最后
        tmp.next = heroCode;
    }

    //打印链表
    public void printSingleLinkedList() {
        //判断链表是不是为null
        if (head.next == null) {
            System.out.println("单链表为null");
            return;
        }
        HeroCode tmp1 = head;
        while (true) {
            tmp1 = tmp1.next;
            System.out.println(tmp1);
            if (tmp1.next == null) {
                break;
            }
        }
    }

    //修改链表中某一节点的值
    public void modifyNode(HeroCode modifiedCode) {
        //判断链表是否为空
        if (head.next == null) {
            System.out.println("链表为null");
            return;
        }
        HeroCode tmp = head;
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
        } else {
            System.out.println("找不到要修改的节点\n" + modifiedCode.no);
        }
    }

    //删除莫一节点
    public void deleteNode(int no) {
        HeroCode tmp = head.next;
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
                break;
            }
            tmp = tmp.next;
        }
        if (flag) {
            tmp.next = tmp.next.next;
        } else {
            System.out.println("没有找到要删除的节点");
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

    //腾讯面试题单链表反转
    public void reverseLinkList(HeroCode head) {
        //当链表为空||链表长度为1时,不需要反转
        if (head.next == null) {
            System.out.println("链表为null还反转什么!!");
            return;
        }
        if (head.next.next == null) {
            System.out.println("链表长度为1反转和不反转都一样");
        }
        //定义临时节点
        HeroCode curr = head.next;
        HeroCode tmp = new HeroCode(0, "", "");
        HeroCode next = null;
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

class HeroCode {
    //英雄的名字
    public String name;
    //英雄的编号
    public int no;
    //英雄的昵称
    public String nickName;
    //指向下一个节点
    public HeroCode next;

    //构造器
    public HeroCode(int no, String name, String nickName) {
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
