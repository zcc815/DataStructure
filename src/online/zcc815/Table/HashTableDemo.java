package online.zcc815.Table;

import java.util.Scanner;

/**
 * Project  DataStructures
 * Package  online.zcc815.Table
 *
 * @Description
 * @Author ZCC
 * @Email zcc815@126.com
 * @Date 2020/10/9 22:43
 * @Version 1.0.0
 */
public class HashTableDemo {
    public static void main(String[] args) {
        HashTable hashTable = new HashTable(7);
        String key = "";
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        int id = 0;
        while (flag) {
            System.out.println("add,添加雇员");
            System.out.println("delete,删除雇员");
            System.out.println("list,遍历雇员信息");
            System.out.println("exit,退出");
            key = scanner.next();
            switch (key) {
                case "add":
                    System.out.println("输入Id");
                     id = scanner.nextInt();
                    System.out.println("输入名字");
                    String name = scanner.next();
                    Emp emp = new Emp(id, name);
                    hashTable.addEmp(emp);
                    break;
                case "list":
                    hashTable.list();
                    break;
                case "delete":
                    System.out.println("输入Id");
                     id = scanner.nextInt();
                    hashTable.delete(id);
                    break;
                case "exit":
                    System.out.println("退出");
                    flag = false;
                    scanner.close();
                    break;
                default:
                    break;
            }
        }
    }
}

class Emp {
    public int id;
    public String name;
    public Emp next;

    public Emp(int id, String name) {
        super();
        this.id = id;
        this.name = name;
    }
}

class EmpLinkedList {
    private Emp head;

    //添加雇员
    public void addEmp(Emp emp) {
        //判断是否为第一个雇员
        if (head == null) {
            head = emp;
            return;
        }
        Emp currEmp = head;
        while (true) {
            //判断链表是否到了最后
            if (currEmp.next == null) {
                break;
            }
            currEmp = currEmp.next;
        }
        //添加雇员
        currEmp.next = emp;
    }

    //删除雇员
    public void deleteEmp(int id) {
        //指向当前雇员
        Emp currEmp = new Emp(0,"");
        currEmp.next= head;
        while (true) {
            if (currEmp.next.id == id ) {
                if (currEmp.next == head){
                    head = currEmp.next.next;
                    break;
                }
                if (currEmp.next.next == null){
                    currEmp.next = null;
                    break;
                }
                currEmp.next = currEmp.next.next;
                break;
            }
            currEmp = currEmp.next;
            if (currEmp.next ==null){
                System.out.println("未找到当前雇员信息");
                break;
            }
        }

    }

    //遍历雇员的信息
    public void list(int i) {
        //判断链表是不是为空
        if (head == null) {
            System.out.println("第" + i + "条链表信息为空");
            return;
        }
        System.out.println("第" + i + "条链表的信息为:");
        Emp currEmp = head;
        while (true) {
            System.out.printf("=> id=%d name=%s\t", currEmp.id, currEmp.name);
            if (currEmp.next == null) {
                break;
            }
            currEmp = currEmp.next;
        }
    }
}

class HashTable {
    private EmpLinkedList[] empLinkedLists;
    public int size;

    //初始化
    public HashTable(int size) {
        this.size = size;
        empLinkedLists = new EmpLinkedList[size];
        for (int i = 0; i < size; i++) {
            empLinkedLists[i] = new EmpLinkedList();
        }
    }

    //添加雇员
    public void addEmp(Emp emp) {
        int empLinkedListNo = getHashValue(emp.id);
        empLinkedLists[empLinkedListNo].addEmp(emp);
    }
//删除雇员
    public void delete (int id){
        empLinkedLists[getHashValue(id)].deleteEmp(id);
    }
    public void list() {
        for (int i = 0; i < size; i++) {
            empLinkedLists[i].list(i);
        }
    }
    public int getHashValue(int id) {
        return id % size;
    }
}
